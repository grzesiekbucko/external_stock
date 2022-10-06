package pl.bucko.external_stock.service;

import com.google.common.collect.Iterables;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.net.ftp.FTPClient;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.bucko.external_stock.entity.ProductEntity;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class WikoService {

    public Map<String, String> createMapFromWikoCsvFile(MultipartFile file) {
        Map<String, String> returnMap = new HashMap<>();

        try (
                InputStream inputStream = file.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF8"));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.newFormat(';'))
        ) {
            for (CSVRecord csvRecord : csvParser) {
                String key = csvRecord.get(1);
                String value = csvRecord.get(0);
                returnMap.put(key, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnMap;
    }

    public List<ProductEntity> wikoProductListFromUploadFile(MultipartFile file) throws FileNotFoundException, UnsupportedEncodingException {
        List<ProductEntity> wikoProductList = new ArrayList<>();
        Map<String, String> productCodeMapper = createMapFromWikoCsvFile(file);
        String fileWiko = ftpWikoDownload();

        try (
                InputStream inputStream = new FileInputStream(fileWiko);
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF8"));

                CSVParser csvParser = new CSVParser(reader, CSVFormat.newFormat(';'))
        ) {
            for (CSVRecord csvRecord : Iterables.skip(csvParser, 1)) {
                String stockBefore = csvRecord.get(2).replaceAll("\\+", "").replaceAll(",00", "");

                String wikoProduktCode = csvRecord.get(0).replaceAll("  ", "").replaceAll(" ", "").replaceAll("\\s", "");
                String marcoProduktCode = productCodeMapper.get(wikoProduktCode);

                int stock = Integer.parseInt(stockBefore);

                System.out.println(wikoProduktCode + " - " + marcoProduktCode + " - " + "WIKO" + " - " + "WIKO" + " - " + stock);
                ProductEntity product = new ProductEntity(wikoProduktCode, marcoProduktCode, "WIKO", "WIKO", stock);
                wikoProductList.add(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wikoProductList;
    }

    public static String ftpWikoDownload() throws FileNotFoundException, UnsupportedEncodingException {
        FTPClient client = new FTPClient();
        String date = date();
        String remoteFile1 = date + "_wiko_stany.csv";
        String path = null;
        try {
            client.connect("ftp.eml.pl", 21);
            boolean login = client.login("", "!");
            System.out.println(login);
            File downloadFile1 = new File("temp_WIKO.csv");
            OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));

            path = downloadFile1.getPath();
            Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF8"));

            boolean success = client.retrieveFile(remoteFile1, outputStream1);
            System.out.println(success);
            outputStream1.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return path;
    }

    private static String date() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
        Date todaysDate = new Date();
        Date yesterday = new DateTime(todaysDate).minusDays(1).toDate();
        return dateFormat.format(yesterday);
    }
}
