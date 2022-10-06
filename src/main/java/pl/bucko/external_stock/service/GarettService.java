package pl.bucko.external_stock.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.bucko.external_stock.entity.ProductEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GarettService {

    public List<ProductEntity> garettProductListFromXmlFile(Map<String, String> productCode) throws IOException {
        InputStream fis = new URL("http://www.garett.com.pl/console/integration/execute/name/CeneoV2").openStream();
        Document doc = Jsoup.parse(fis, null, "", Parser.xmlParser());
        List<ProductEntity> geseProductList = new ArrayList<>();
        for (Element e : doc.select("o")) {
            String produktCode = e.select("a").get(1).text();
            String markoProduktCode = (String) productCode.get(produktCode);
            int stock = Integer.parseInt(e.attr("stock"));
            geseProductList.add(new ProductEntity(produktCode, markoProduktCode, "GARETT", "GARETT", stock));
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


}
