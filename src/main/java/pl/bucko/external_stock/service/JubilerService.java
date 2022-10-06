package pl.bucko.external_stock.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import pl.bucko.external_stock.entity.ProductEntity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class JubilerService {

    //converting response stream to product object list
    public List<ProductEntity> sendPOST(String url, String marka) throws IOException {
        String result = "";
        HttpPost post = new HttpPost("");
        HttpGet get = new HttpGet(url);
        get.addHeader(HttpHeaders.USER_AGENT, "Googlebot");
        List<ProductEntity> productList = new ArrayList<>();

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse responsePost = httpClient.execute(post);
             CloseableHttpResponse responseGet = httpClient.execute(get)
        ) {

            Reader reader = new BufferedReader(new InputStreamReader(responseGet.getEntity().getContent(), "UTF8"));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.newFormat(';'));

            boolean firstRound = true;
            for (CSVRecord csvRecord : csvParser) {
                if (firstRound) {
                    firstRound = false;
                } else {
                    String stock = csvRecord.get(4);
                    String dostepnosc = csvRecord.get(6);
                    if (">3".equals(stock) && "magazyn".equals(dostepnosc)) {
                        productList.add(new ProductEntity(csvRecord.get(1), csvRecord.get(1), marka, "JUBILER", 10));
                        System.out.println(csvRecord.get(1) + " | " + csvRecord.get(6) + " | " + csvRecord.get(4));
                    } else {
                        productList.add(new ProductEntity(csvRecord.get(1), csvRecord.get(1), marka, "JUBILER", 0));
                        System.out.println(csvRecord.get(1) + " | " + csvRecord.get(6) + " | " + csvRecord.get(4) + " - 0");
                    }
                }
            }
            return productList;
        }
    }


}



