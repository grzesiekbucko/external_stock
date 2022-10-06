package pl.bucko.external_stock.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class KropaService {

    public static List<Path> findByFileName(Path path, String fileName)
            throws IOException {

        List<Path> result;
        try (Stream<Path> pathStream = Files.find(path,
                Integer.MAX_VALUE,
                (p, basicFileAttributes) ->
                        p.getFileName().toString().equalsIgnoreCase(fileName))
        ) {
            result = pathStream.collect(Collectors.toList());
        }
        return result;
    }

    public String imageCoppy(MultipartFile file) throws IOException {
        String folderPath = "";
        try (
                InputStream inputStream = file.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF8"));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.newFormat(';').withFirstRecordAsHeader());
        ) {
            folderPath = csvParser.getHeaderMap().keySet().toString().replaceAll("\\[", "").replaceAll("\\]", "");
            Path path = Paths.get(folderPath);

            for (CSVRecord csvRecord : csvParser) {
                String fileName = csvRecord.get(0);

                List<Path> result = findByFileName(path, fileName);
                File dest = new File(path + "/kopie/" + fileName);
                for (Path p : result) {
                    File source = new File(p.toString());
                    try {
                        FileUtils.copyFile(source, dest);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Utworzono folder: " + folderPath + "\\kopie";
    }

    public static void copyFileUsingApache(File from, File to) throws IOException {
        FileUtils.copyFile(from, to);
    }
}
