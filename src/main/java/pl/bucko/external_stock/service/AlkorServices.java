package pl.bucko.external_stock.service;

import com.squareup.okhttp.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import pl.bucko.external_stock.entity.ProductEntity;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlkorServices {

    public void allegroOpinie() throws IOException {

            String pageUrl = "https://allegro.pl/uzytkownik/markobizuteria/oceny?recommend=true&page=1";
//            String pageUrl = "https://www.marko.pl/pl/p/Zloty-lancuszek-Pancerka-proba-333/56609";

            Document contentPage = Jsoup.connect(pageUrl)
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("http://www.google.com")
                    .get();
            Elements classId = contentPage.select("._9hx3e");
//            Elements classId = contentPage.select(".code");
            String stockOnWebsite = classId.select("span").text();

            System.out.println(stockOnWebsite);
    }



    public List<ProductEntity> alkorProductListFromWebsite() throws IOException {

        List<ProductEntity> alkorProductList = new ArrayList();
        int numberOfPage = getNumberOfPage();

        for (int i = 0; i < numberOfPage; i++) {
            String pageUrl = "https://kupzegarek.com/pl/10-marki?q=Kategorie-Adriatica-Pierre+Ricaud&page=" + (i + 1);

            Document contentPage = Jsoup.connect(pageUrl).get();
            Elements classId = contentPage.select(".product_item");
            int stock;

            for (Element p : classId) {
                String stockOnWebsite = p.select("span").attr("style");
                int stockBefore = Integer.parseInt(stockOnWebsite.replaceAll("width: ", "").replaceAll("%;", "").replaceAll(" ", ""));

                if (stockBefore > 25) {
                    stock = 10;
                } else {
                    stock = 0;
                }
                alkorProductList.add(new ProductEntity(p.select(".product-title").text(), p.select(".product-title").text(), p.select(".list-manufacturer-name").text(), "ALKOR", stock));
            }
        }
        return alkorProductList;
    }

    private Integer getNumberOfPage() throws IOException {

        Document pageContent = Jsoup.connect("https://kupzegarek.com/pl/10-marki?q=Kategorie-Adriatica-Pierre+Ricaud").get();
        Elements elements = pageContent.select(".page-list");

        String iloscStron = elements.text();

        char[] characters = iloscStron.toCharArray();
        char ostatni = characters[characters.length - 1];
        char przedostatni = characters[characters.length - 2];

        StringBuilder sb = new StringBuilder().append(przedostatni).append(ostatni);
        //   System.out.println("liczba podstron: " + sb);

        return Integer.parseInt(String.valueOf(sb));
    }

    public void karkosikProductFromWebsite() throws IOException {

        int numberOfPage = 1;

        String fileName = "Karkosik_new.csv";
        FileWriter csvWriter = new FileWriter(fileName);
        csvWriter.append("Nazwa");
        csvWriter.append(";");
        csvWriter.append("Kod produktu");
        csvWriter.append(";");
        csvWriter.append("Cena");
        csvWriter.append(";");
        csvWriter.append("Link do produktu");
        csvWriter.append(";");
        csvWriter.append("\n");

        for (int i = 0; i < numberOfPage; i++) {
            String pageUrl = "https://www.karkosik.pl/874-linki?amp%253Bid_category=874&n=480&orderby=quantity&orderway=desc&p=" + (i + 1);

            Document contentPage = Jsoup.connect(pageUrl).timeout(90 * 1000).get();
            Elements classId = contentPage.select(".box-product");
            System.out.println("---------------- " + i + " ----------------");

            for (Element p : classId) {
                String linkDoKartyProduktu = p.select(".product_img_link").attr("href");
                String nazwa = p.select(".name").select("a").attr("title");

                System.out.println(linkDoKartyProduktu);
                Document productPage = Jsoup.connect(linkDoKartyProduktu).timeout(90 * 1000).get();

                String imageClass = productPage.select("#bigpic").attr("src");
                String productKodClass = productPage.select("#product_reference").select("span").text();
                String price = productPage.select("#our_price_display").text();

                csvWriter.append(nazwa);
                csvWriter.append(";");
                csvWriter.append(productKodClass);
                csvWriter.append(";");
                csvWriter.append(price);
                csvWriter.append(";");
                csvWriter.append(linkDoKartyProduktu);
                csvWriter.append(";");
                csvWriter.append("\n");

                System.out.println("Nazwa " + nazwa);
                System.out.println("Kod " + productKodClass);
                System.out.println("Cena " + price);
                System.out.println("Zdjecie " + imageClass);

                //save image
//                try {
//                    InputStream in = new URL(imageClass).openStream();
//                    Files.copy(in, Paths.get("src/main/resources/img/" + productKodClass.replaceAll("/", "_") + ".jpg"));
//                    System.out.println("Zapisano zdjęcie - " + productKodClass + "\n");
//                } catch (FileAlreadyExistsException e) {
//
//                    String random = RandomStringUtils.randomAlphanumeric(2).toUpperCase();
//                    InputStream in = new URL(imageClass).openStream();
//
//                    Files.copy(in, Paths.get("src/main/resources/img/" + productKodClass.replaceAll("/", "_") + "_" + random + ".jpg"));
//                }
            }
        }
        csvWriter.flush();
        csvWriter.close();

    }


}
