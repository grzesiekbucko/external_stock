package pl.bucko.external_stock.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.bucko.external_stock.entity.ProductEntity;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MarkoService {

    public List<ProductEntity> markoProductListFromXmlsFile(String src) throws FileNotFoundException {
        List<ProductEntity> markoProductList = new ArrayList<>();

            try (

                    Reader reader = new BufferedReader( new InputStreamReader( new FileInputStream(src), "UTF8"));

                    CSVParser csvParser = new CSVParser(reader, CSVFormat.newFormat(';'))
            ) {
                for (CSVRecord csvRecord : csvParser) {
                    Integer stock = Integer.valueOf(csvRecord.get(1));
                    markoProductList.add(new ProductEntity(csvRecord.get(0), csvRecord.get(0), "MARKO", "MARKO", stock));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return markoProductList;
        }
    public List<ProductEntity> markoProductListFromUploadFile(MultipartFile file) throws FileNotFoundException {
        List<ProductEntity> markoProductList = new ArrayList<>();

        try (
                InputStream inputStream = file.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"UTF8"));

                CSVParser csvParser = new CSVParser(reader, CSVFormat.newFormat(';'))
        ) {
            for (CSVRecord csvRecord : csvParser) {
                Integer stock = Integer.valueOf(csvRecord.get(1));
                markoProductList.add(new ProductEntity(csvRecord.get(0), csvRecord.get(0), "MARKO", "MARKO", stock));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return markoProductList;
    }


}
