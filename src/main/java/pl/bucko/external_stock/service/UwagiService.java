package pl.bucko.external_stock.service;

import com.google.common.base.Splitter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UwagiService {

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
            String str = replaceAtrrString(row.getCell(1).toString(), ":", "=");

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
                if (o.equals("Waga") || o.equals("Wymiary") || o.equals("Szerokość pierścionka") ) {
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

        csvWriter.append("INDEKS_KATALOGOWY");
        csvWriter.append(";");
        csvWriter.append("UWAGI");
        csvWriter.append("\n");
        for (Object key : finalMap.keySet()) {
            String texty = key.toString() + ";";
            for (Object s : finalMap.get(key).keySet()) {
                String txtAttr = "";
                if (!(finalMap.get(key).get(s)).equals("")) {
                    txtAttr = s + ": " + finalMap.get(key).get(s) + " / ";
                }
                texty = texty + txtAttr;
            }
            csvWriter.append(texty.replace(",\"", " "));
            csvWriter.append("\n");
        }
        csvWriter.flush();
        csvWriter.close();
    }

    String replaceAtrrString(String oldString, String whatToSwap, String swapTo) {
        String finalString = null;
        Matcher m = Pattern.compile("\\[(.*?)\\]").matcher(oldString);
        while (m.find()) {
            finalString = oldString.replace(m.group(1), m.group(1).replace(whatToSwap, swapTo));
            oldString = finalString;
        }
        if (finalString == null) {
            return swapper(oldString);
        } else {
            return swapper(finalString);
        }
    }

    String swapper(String text) {
        String str = text + "/ ";
        String pair = str.replaceAll(": ", ":").replaceAll(" /", "/").replaceAll("\\||", "").replaceAll("\\|", "").replaceAll("/ ", "/").replaceAll("//", "/").replaceAll("/", " / ").trim().replaceAll("\\s{2,}", " ");
        return pair.replaceAll(" /$", "");
    }


}
