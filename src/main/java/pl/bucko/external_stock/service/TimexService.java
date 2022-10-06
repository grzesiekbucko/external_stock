package pl.bucko.external_stock.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import pl.bucko.external_stock.entity.ProductEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Service
public class TimexService {

    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    public void getProductsFromWebsite() throws Exception {

        TimexService obj = new TimexService();
        try {
            System.out.println("Testing 2 - Send Http POST request");
            obj.sendPost();
            System.out.println("Testing 1 - Send Http GET request");
            obj.sendGet();
        } finally {
            obj.close();
        }
    }

    private void close() throws IOException {
        httpClient.close();
    }

    private void sendPost() throws Exception {
        HttpPost post = new HttpPost("https://obslugaklienta.timex.pl/pl-PL/");

        // add request parameter, form parameters
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("Type", "complaint"));
        urlParameters.add(new BasicNameValuePair("UserName", ""));
        urlParameters.add(new BasicNameValuePair("Password", ""));
        urlParameters.add(new BasicNameValuePair("X-Requested-With", "XMLHttpRequest"));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            System.out.println(EntityUtils.toString(response.getEntity()));
        }
    }

    private void sendGet() throws Exception {

        HttpGet request = new HttpGet("https://obslugaklienta.timex.pl/pl-PL/DynFiles/");

        // add request headers
        request.addHeader(HttpHeaders.USER_AGENT, "Googlebot");

        try (CloseableHttpResponse response = httpClient.execute(request)) {

            // Get HttpResponse Status
            System.out.println(response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
            System.out.println(headers);

            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }

        }

    }


}



