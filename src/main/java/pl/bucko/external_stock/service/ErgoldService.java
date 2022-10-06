package pl.bucko.external_stock.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import pl.bucko.external_stock.entity.ProductEntity;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ErgoldService {

    public List<ProductEntity> geseProductListFromXmlFile(Map<String, String> productCode) throws IOException {
        InputStream fis = new URL("https://ergold.pl/sync/xml.php").openStream();
        Document doc = Jsoup.parse(fis, null, "", Parser.xmlParser());
        List<ProductEntity> ergoldProductList = new ArrayList<>();
        Map<String, ProductEntity> ergoldProduktMap = new HashMap<>();

        for (Element e : doc.select("PRODUCT")) {

            if (e.select("VARIANT").isEmpty()) {
                System.out.println("Product: " + e.select("REFERENCE").text() + ";" + e.select("IMAGE").text());

                String xmlProduktCode = e.select("REFERENCE").text();
                String quantity = e.select("TOTAL_QUANTITY").text();
                int stock = Integer.parseInt(quantity);
                if (Integer.parseInt(quantity) < 0 || quantity.equals("")) {
                    stock = 0;
                }
                String markoProduktCode = productCode.get(xmlProduktCode);
                if (markoProduktCode != null) {
                    ProductEntity productErgold = new ProductEntity(xmlProduktCode, markoProduktCode, "ERGOLD", "ERGOLD", stock);
                    System.out.println(productErgold.getKodProducenta() + " ; " + productErgold.getKodMarko() + " ; " + stock);
                    ergoldProductList.add(productErgold);
                }
            }
            if (!e.select("VARIANT").isEmpty()) {
                System.out.println("Wariant: " + e.select("VARIANT_REFERENCE").text());

                for (Element w : e.select("VARIANT")) {
                    String xmlProduktCode = w.select("VARIANT_REFERENCE").text();
                    String quantity = w.select("VARIANT_QUANTITY").text();
                    int stock = Integer.parseInt(quantity);
                    if (Integer.parseInt(quantity) < 0 || quantity.equals("")) {
                        stock = 0;
                    }
                    String markoProduktCode = productCode.get(xmlProduktCode);
                    if (markoProduktCode != null) {
                        ProductEntity productErgold = new ProductEntity(xmlProduktCode, markoProduktCode, "ERGOLD", "ERGOLD", stock);
//                        System.out.println(productErgold.getKodProducenta() + " ; " + productErgold.getKodMarko() + " ; " + stock);
                        System.out.println("Wariant: " + w.select("VARIANT_REFERENCE").text());
                        ergoldProductList.add(productErgold);
                    }
                }
            }

        }

        return ergoldProductList;
    }

}
