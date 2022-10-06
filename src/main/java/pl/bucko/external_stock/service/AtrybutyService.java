package pl.bucko.external_stock.service;

import com.google.common.base.Splitter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Stream;

@Service
public class AtrybutyService {

    public Map readExcel(MultipartFile excelFile) throws IOException {
        InputStream fis = new BufferedInputStream(excelFile.getInputStream());

        // we create an XSSF Workbook object for our XLSX Excel File
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        // we get first sheet
        XSSFSheet sheet = workbook.getSheetAt(0);

        // we iterate on rows
        Iterator<Row> rowIt = sheet.iterator();
        Map<String, Map> finalMap = new HashMap<>();

        while (rowIt.hasNext()) {
            Row row = rowIt.next();
            String str = replaceAtrrString(row.getCell(1).toString());

            System.out.println("kod - " + row.getCell(0).toString() + "\n" + str);

            Map<String, String> map = Splitter.on(" / ")
                    .withKeyValueSeparator(':')
                    .split(str);

            finalMap.put(row.getCell(0).toString(), map);
        }
        workbook.close();
        fis.close();
        return finalMap;
    }

    public ArrayList<String> txtFileReader(MultipartFile attrFile) {
        ArrayList<String> ar = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(attrFile.getInputStream(), StandardCharsets.UTF_8));
            String line = reader.readLine();
            System.out.println(line);
            ar.add(line);
            while (line != null) {
                // read next line
                line = reader.readLine();
                System.out.println(line);
                ar.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ar;
    }

    public List<Map> mapfilter(Map<String, Map> attrybutes, ArrayList<String> atrrEnable) {
        List<Map> list = new ArrayList();
        System.out.println("Keyset: " + attrybutes.keySet());

        Map<String, Map> finalMap = new HashMap();
        Map<String, Map> errorMap = new HashMap();
        for (Object k : attrybutes.keySet()) {
            Map<String, String> tempFineMap = new HashMap();
            Map<String, String> tempErrorMap = new HashMap();
            for (Object o : attrybutes.get(k).keySet()) {
                if (o.equals("Waga") || o.equals("Wymiary")) {
                    System.out.println("xx bez sprawdzania " + o + "=" + attrybutes.get(k).get(o) + ",");
                    tempFineMap.put(o.toString(), attrybutes.get(k).get(o).toString());
                } else {
                    if (atrrEnable.contains(attrybutes.get(k).get(o).toString())) {
                        System.out.println("Jest " + attrybutes.get(k).get(o));
                        tempFineMap.put(o.toString(), attrybutes.get(k).get(o).toString());
                    }
                    if ((attrybutes.get(k).get(o)).equals("")) {
                        System.out.println("Pusty " + attrybutes.get(k).get(o));
                    }
                    if (!(attrybutes.get(k).get(o)).equals("") && !(atrrEnable.contains(attrybutes.get(k).get(o).toString()))) {
                        System.out.println("Nie ma " + attrybutes.get(k).get(o));
                        tempErrorMap.put(o.toString(), attrybutes.get(k).get(o).toString());
                    }
                }
            }
            finalMap.put(k.toString(), tempFineMap);
            errorMap.put(k.toString(), tempErrorMap);
        }
        list.add(finalMap);
        list.add(errorMap);
        return list;
    }

    public void createCsvFile(Map<String, Map> finalMap) throws IOException {
        FileOutputStream fileStream = new FileOutputStream(new File("new.csv"));
        OutputStreamWriter csvWriter = new OutputStreamWriter(fileStream, StandardCharsets.UTF_8);

        csvWriter.append("product_code");
        csvWriter.append(";");
        csvWriter.append("attributes_group");
        csvWriter.append(";");
        csvWriter.append("attributes");
        csvWriter.append("\n");

        for (Object key : finalMap.keySet()) {
            String texty = "\"" + key.toString() + "\";" + "\"Wszystkie\";" + "\"";

            for (Object s : finalMap.get(key).keySet()) {
                String txtAttr = "";
                if (!(finalMap.get(key).get(s)).equals("")) {
                    txtAttr = s + "=" + finalMap.get(key).get(s) + ",";
                }
                texty = texty + txtAttr;
            }
            texty = texty + "\"";
            csvWriter.append(texty.replace(",\"", "\""));
            csvWriter.append("\n");
        }
        csvWriter.flush();
        csvWriter.close();
    }

    public void createCsvFile2(Map<String, Map> finalMap) throws IOException {
        FileOutputStream fileStream = new FileOutputStream(new File("new.csv"));
        OutputStreamWriter csvWriter = new OutputStreamWriter(fileStream, StandardCharsets.UTF_8);

        List<String> atrybutyNazwa = Arrays.asList("Kod produktu", "Próba", "Kamień", "Kruszec Kolor", "Kolekcja", "Masa kamienia centralnego", "Barwa diamentów", "Czystość diamentów", "Wykończenie", "Symetria", "Szlif", "Kamienie dodatkowe", "Masa kamieni dodatkowych", "Barwa kamieni dodatkowych", "Czystość kamieni dodatkowych", "Waga", "Grawer", "Szerokość obrączki damskiej", "Szerokość obrączki męskiej", "Soczewka", "Dla kogo", "Rodzaj", "Typ zapięcia", "Splot", "Wizerunek", "Styl", "Pochodzenie", "Szkiełko", "Rodzaj koperty", "Szerokość koperty", "Grubość koperty", "Typ paska / bransolety", "Kolor paska / bransolety", "Wodoszczelność", "Mechanizm", "Gwarancja", "Szerokość paska / bransolety", "Wymiary", "Długość", "Kolor tarczy", "Szerokość łańcuszka", "Szerokość pierścionka");
        csvWriter.append("Grupy atrybutów;");
        for (int i = 0; i < atrybutyNazwa.size() - 1; i++) {
            csvWriter.append("Wszystkie;");
        }
        csvWriter.append("\n");
        for (String atrybutNazwa : atrybutyNazwa) {
            csvWriter.append(atrybutNazwa + ";");
        }
        csvWriter.append("\n");

        for (Object kodProduktu : finalMap.keySet()) {
            csvWriter.append(kodProduktu.toString());
            for (String atrybutNazwa : atrybutyNazwa) {
                if ((finalMap.get(kodProduktu).get(atrybutNazwa)) == null) {
                    csvWriter.append(";");
                } else {
                    csvWriter.append(finalMap.get(kodProduktu).get(atrybutNazwa) + ";");
                }
            }
            csvWriter.append("\n");
        }
        csvWriter.flush();
        csvWriter.close();
    }

    String replaceAtrrString(String text) {
        String str = text + "/ ";
        String pair = str.replaceAll("\\[[^\\[\\]]+\\]", "").replaceAll(": ", ":").replaceAll(" /", "/").replaceAll("\\||", "").replaceAll("\\|", "").replaceAll("/ ", "/").replaceAll("//", "/").replaceAll("/", " / ").trim().replaceAll("\\s{2,}", " ");
        String finalPair = pair.replaceAll(",", ".").replaceAll(" /$", "");
        return finalPair;
    }



}
