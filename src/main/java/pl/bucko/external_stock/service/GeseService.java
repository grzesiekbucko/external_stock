package pl.bucko.external_stock.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.bucko.external_stock.entity.ProductEntity;
import pl.bucko.external_stock.model.ImageProductsGese;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GeseService {

    public List<ProductEntity> geseProductListFromXmlFile(Map<String, String> productCode) throws IOException {
        InputStream fis = new URL("http://www.gese.pl/console/integration/execute/name/CeneoV2").openStream();
        Document doc = Jsoup.parse(fis, null, "", Parser.xmlParser());
        List<ProductEntity> geseProductList = new ArrayList<>();
        for (Element e : doc.select("o")) {
            String produktCode = e.select("a").get(1).text();
            String markoProduktCode = (String) productCode.get(produktCode);
            int stock = Integer.parseInt(e.attr("stock"));
            geseProductList.add(new ProductEntity(produktCode, markoProduktCode, "GESE", "GESE", stock));
        }
        return geseProductList;
    }

    public void xmlFileScrapper() throws IOException {
        InputStream fis = new URL("http://www.gese.pl/console/integration/execute/name/FacebookCatalogFeed/lang/pl_PL").openStream();
        Document doc = Jsoup.parse(fis, null, "", Parser.xmlParser());

        FileOutputStream fileStream = new FileOutputStream(new File("Kody_GESE.csv"));
        OutputStreamWriter csvWriter = new OutputStreamWriter(fileStream, StandardCharsets.UTF_8);

        csvWriter.append("Id");
        csvWriter.append(";");
        csvWriter.append("Group_id");
        csvWriter.append(";");
        csvWriter.append("Rodzaj");
        csvWriter.append(";");
        csvWriter.append("Kod");
        csvWriter.append(";");
        csvWriter.append("Stan");
        csvWriter.append(";");
        csvWriter.append("Gramatura");
        csvWriter.append(";");
        csvWriter.append("Tytuł");
        csvWriter.append(";");
        csvWriter.append("Link");
        csvWriter.append(";");
        csvWriter.append("Opis");
        csvWriter.append(";");
        csvWriter.append("Zdjecie");
        csvWriter.append("\n");

        for (Element e : doc.select("entry")) {

            String xmlId = e.select("id").text();
            String xmlGroupId = e.select("item_group_id").text();
            String xmlRodzaj = e.select("product_type").text();
            String xmlTitle = e.select("title").text();
            String xmlInventory = e.select("inventory").text();
            String xmlMpn = e.select("mpn").text();
            String xmlLink = e.select("link").text();
            String xmlDescription = e.select("description").text();
            String xmlImage_link = e.select("image_link").text();

            csvWriter.append(xmlId);
            csvWriter.append(";");
            csvWriter.append(xmlGroupId);
            csvWriter.append(";");
            csvWriter.append(xmlRodzaj);
            csvWriter.append(";");
            csvWriter.append(xmlMpn);
            csvWriter.append(";");
            csvWriter.append(xmlInventory);
            csvWriter.append(";");
            if (StringUtils.substringBetween(xmlTitle, "(", ")") != null) {
                csvWriter.append(StringUtils.substringBetween(xmlTitle, "(", ")").replaceAll("Gramatura: ", ""));
            } else {
                csvWriter.append("");
            }
            csvWriter.append(";");
            csvWriter.append(xmlTitle);
            csvWriter.append(";");
            csvWriter.append(xmlLink);
            csvWriter.append(";");
            csvWriter.append(xmlDescription);
            csvWriter.append(";");
            csvWriter.append(xmlImage_link);
            csvWriter.append("\n");
        }
        csvWriter.flush();
        csvWriter.close();
    }

    public List<ProductEntity> geseProductListFromFacebookXmlFile(Map<String, String> productCode) throws IOException {
        InputStream fis = new URL("http://www.gese.pl/console/integration/execute/name/FacebookCatalogFeed/lang/pl_PL").openStream();
        Document doc = Jsoup.parse(fis, null, "", Parser.xmlParser());
        List<ProductEntity> geseProductList = new ArrayList<>();
        Map<String, ProductEntity> geseProduktMap = new HashMap<>();

        for (Element e : doc.select("entry")) {
            String xmlProduktCode = e.select("mpn").text();
            String clearCode;
            String[] extensions = {"-a", "-b", "-c", "-d", "-e", "-f", "-g", "-h", "-i", "-j", "-k", "-l", "-m", "-n", "-o", "-p", "-r", "-s"};

            if (org.apache.commons.lang3.StringUtils.endsWithAny(xmlProduktCode, extensions)) {
                clearCode = xmlProduktCode.substring(0, xmlProduktCode.length() - 2);
            } else {
                clearCode = xmlProduktCode;
            }

            String markoProduktCode = (String) productCode.get(clearCode);
            int stock = Integer.parseInt(e.select("inventory").text());

            ProductEntity productGese = new ProductEntity(clearCode, markoProduktCode, "GESE", "GESE", stock);

            if (geseProduktMap.isEmpty()) {
                geseProduktMap.put(clearCode, productGese);

            } else if (geseProduktMap.containsKey(clearCode)) {

                int stanZMapy = geseProduktMap.get(clearCode).getStan();
                int stanZPliku = productGese.getStan();

                geseProduktMap.get(clearCode).setStan(stanZPliku + stanZMapy);

            } else {
                geseProduktMap.put(clearCode, productGese);
            }
        }

        for (String k : geseProduktMap.keySet()) {
            geseProductList.add(geseProduktMap.get(k));
        }

        return geseProductList;
    }

    public Map<String, String> createMapFromCsvFile(MultipartFile file) {
        Map<String, String> returnMap = new HashMap<>();

        try (
                InputStream inputStream = file.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF8"));

                CSVParser csvParser = new CSVParser(reader, CSVFormat.newFormat(';'))
        ) {
            for (CSVRecord csvRecord : csvParser) {
                returnMap.put(csvRecord.get(1), csvRecord.get(0));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnMap;
    }

    public List geseImageScrapper(MultipartFile file) throws IOException {
        Map<String, String> codeMap = geseAndMarkoImageScrapper();
        List<ImageProductsGese> imageProductList = new ArrayList();
        try (
                InputStream inputStream = file.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF8"));

                CSVParser csvParser = new CSVParser(reader, CSVFormat.newFormat(';'))
        ) {
            for (CSVRecord csvRecord : csvParser) {
                ImageProductsGese imageGese = new ImageProductsGese(csvRecord.get(1), codeMap.get(csvRecord.get(1)), csvRecord.get(0), codeMap.get(csvRecord.get(0)));
                imageProductList.add(imageGese);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageProductList;
    }

    public Map geseAndMarkoImageScrapper() throws IOException {
        String geseUrl = "http://www.gese.pl/console/integration/execute/name/FacebookCatalogFeed/lang/pl_PL";
//        String markoUrl = "http://www.marko.pl/console/integration/execute/name/CeneoV2";
        String markoUrl = "http://www.marko.pl/console/integration/execute/name/FacebookCatalogFeed/lang/pl_PL";

        Map<String, String> imageLink = new HashMap<>();

        InputStream fis = new URL(geseUrl).openStream();
        Document doc = Jsoup.parse(fis, null, "", Parser.xmlParser());
        for (Element e : doc.select("entry")) {
            String xmlProduktCode = e.select("mpn").text();
            String clearCode;
            String[] extensions = {"-a", "-b", "-c", "-d", "-e", "-f", "-g", "-h", "-i", "-j", "-k", "-l", "-m", "-n", "-o", "-p", "-r", "-s"};

            if (org.apache.commons.lang3.StringUtils.endsWithAny(xmlProduktCode, extensions)) {
                clearCode = xmlProduktCode.substring(0, xmlProduktCode.length() - 2);
            } else {
                clearCode = xmlProduktCode;
            }
            if (clearCode != null && !clearCode.equals("")) {
                String xmlProduktImg = e.select("image_link").text();
                imageLink.put(clearCode, xmlProduktImg);
                System.out.println("Gese - " + xmlProduktCode + " - " + xmlProduktImg);
            }
        }

        InputStream fis2 = new URL(markoUrl).openStream();
        Document doc2 = Jsoup.parse(fis2, null, "", Parser.xmlParser());

//        for (Element e : doc2.select("o")) {
//            Elements code = e.select("a").attr("name", "Kod_producenta");
//            String xmlProduktCode = code.get(1).text();
//            String xmlProduktImg = e.select("main").attr("url");
//            imageLink.put(xmlProduktCode, xmlProduktImg);
//            System.out.println("Marko - " + xmlProduktCode + " - " + xmlProduktImg);
//        }

//        for (Element e : doc2.select("entry")) {
//            String xmlProduktCode = e.select("mpn").text();
//            String xmlProduktImg = e.select("image_link").text();
//            imageLink.put(xmlProduktCode, xmlProduktImg);
//            System.out.println("Marko - " + xmlProduktCode + " - " + xmlProduktImg);
//        }

        return imageLink;
    }

    public String geseUpdateDateXmlFile() throws IOException {
        String geseUrl = "http://www.gese.pl/console/integration/execute/name/FacebookCatalogFeed/lang/pl_PL";
        InputStream fis = new URL(geseUrl).openStream();
        Document doc = Jsoup.parse(fis, null, "", Parser.xmlParser());

        String updateTime = doc.select("updated").text();
        System.out.println(updateTime);
        return updateTime;
    }
}
