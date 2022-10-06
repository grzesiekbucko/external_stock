package pl.bucko.external_stock.service;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@Service
public class ShoperApiImageService {


    public static String updateImageNameByImageId(MultipartFile file, String token) throws InterruptedException {
        try {
            InputStream fis = new BufferedInputStream(file.getInputStream());

            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            int lastRow = sheet.getLastRowNum();

            HttpURLConnection httpURLConnection = null;
            DataOutputStream dataOutputStream = null;

            for (int i = 0; i <= lastRow; i++) {
                Thread.sleep(300);
                org.apache.poi.ss.usermodel.Row row = sheet.getRow(i);
                //1st Cell as Value
                org.apache.poi.ss.usermodel.Cell valueCell = row.getCell(1);
                //0th Cell as Key
                org.apache.poi.ss.usermodel.Cell keyCell = row.getCell(0);
                //2st Cell as url
                org.apache.poi.ss.usermodel.Cell urlCell = row.getCell(2);

                Double key = keyCell.getNumericCellValue();
                String value = valueCell.getStringCellValue().trim();
                String link = urlCell.getStringCellValue().trim();

                //image_id converting from double to String
                String newValueKey = String.format("%.0f", key);

                String completeUrl = "https://www.marko.pl/webapi/rest/product-images";

                // Sending POST request
                URL url = new URL(completeUrl);
                System.out.println(i + 1 + ". " + newValueKey + " - " + link);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(15000);
                conn.setConnectTimeout(15000);
                conn.setRequestProperty("Authorization", "Bearer " + token);
                conn.setRequestProperty("Content-Type", "text/plain");
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                OutputStreamWriter out = new OutputStreamWriter(
                        conn.getOutputStream());
                String data = "{\"name\":\"" + value + "\"}";
                String data2 = "{\"product_id\":\"" + newValueKey + "\",\"name\":\"" + value + "\",\"url\":\"" + link + "\"}";

                conn.getOutputStream().write(data2.getBytes("UTF-8"));
                conn.getInputStream();
                out.close();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            return "Brak Tokena";
        } catch (RuntimeException e) {
            return "Błędny plik";

        }
        return "zaimportowano";
    }
}
