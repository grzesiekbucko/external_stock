package pl.bucko.external_stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pl.bucko.external_stock.dto.ArtykulJoinDto;
import pl.bucko.external_stock.entity.ProductEntity;
import pl.bucko.external_stock.repository.ArtykulJoinDtoRepository;
import pl.bucko.external_stock.repository.ArtykulRepository;
import pl.bucko.external_stock.repository.ProductRepository;
import pl.bucko.external_stock.service.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static pl.bucko.external_stock.service.Util.policzSprzedaz;

@Controller
public class MagazynController {

    @Autowired
    private MarkoService markoService;
    @Autowired
    private WikoService wikoService;
    @Autowired
    private ErgoldService ergoldService;
    @Autowired
    private GeseService geseService;
    @Autowired
    private GarettService garettService;
    @Autowired
    private AlkorServices alkorServices;
    @Autowired
    private JubilerService jubilerService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ArtykulRepository artykulRepository;
    @Autowired
    private ArtykulJoinDtoRepository artykulJoinDtoRepository;
    @Autowired
    private TimexService timexService;


    @RequestMapping(value = "/panel", method = RequestMethod.GET)
    public ModelAndView showHomePage() throws IOException {
        ModelAndView model = new ModelAndView("index");
        model.addObject("gese_all_product_counter", productRepository.countByDystrybutor("GESE").toString());
        model.addObject("gese_available_product_counter", productRepository.findByKodMarkoIsNotNullAndDystrybutorAndStanGreaterThan("GESE", 0).size());
        model.addObject("garett_all_product_counter", productRepository.countByDystrybutor("GARETT").toString());
        model.addObject("garett_available_product_counter", productRepository.findByKodMarkoIsNotNullAndDystrybutorAndStanGreaterThan("GARETT", 0).size());
        model.addObject("marko_all_product_counter", productRepository.countByDystrybutor("MARKO").toString());
        model.addObject("marko_available_product_counter", productRepository.findByKodMarkoIsNotNullAndDystrybutorAndStanGreaterThan("MARKO", 0).size());
        model.addObject("alkor_all_product_counter", productRepository.countByDystrybutor("ALKOR").toString());
        model.addObject("alkor_available_product_counter", productRepository.findByKodMarkoIsNotNullAndDystrybutorAndStanGreaterThan("ALKOR", 0).size());
        model.addObject("jubiler_all_product_counter", productRepository.countByDystrybutor("JUBILER").toString());
        model.addObject("jubiler_available_product_counter", productRepository.findByKodMarkoIsNotNullAndDystrybutorAndStanGreaterThan("JUBILER", 0).size());
        model.addObject("timex_all_product_counter", productRepository.countByDystrybutor("TIMEX").toString());
        model.addObject("timex_available_product_counter", productRepository.findByKodMarkoIsNotNullAndDystrybutorAndStanGreaterThan("TIMEX", 0).size());
        model.addObject("wiko_all_product_counter", productRepository.countByDystrybutor("WIKO").toString());
        model.addObject("wiko_available_product_counter", productRepository.findByKodMarkoIsNotNullAndDystrybutorAndStanGreaterThan("WIKO", 0).size());
        model.addObject("ergold_all_product_counter", productRepository.countByDystrybutor("ERGOLD").toString());
        model.addObject("ergold_available_product_counter", productRepository.findByKodMarkoIsNotNullAndDystrybutorAndStanGreaterThan("ERGOLD", 0).size());
        model.addObject("producenci", productRepository.znajdzProducentow());
        return model;
    }

    @RequestMapping(value = "/show_selected_producent", method = RequestMethod.POST)
    public String showSelected(ModelMap model, @RequestParam(required = false) String selected_producent) {
        List<String> productSplitedList = Arrays.asList(selected_producent.split(","));
        model.addAttribute("productList", productRepository.findByKodMarkoIsNotNullAndStanGreaterThanAndProducentIn(0, productSplitedList));
        model.addAttribute("gese_all_product_counter", productRepository.countByDystrybutor("GESE").toString());
        model.addAttribute("gese_available_product_counter", productRepository.findByKodMarkoIsNotNullAndDystrybutorAndStanGreaterThan("GESE", 0).size());
        model.addAttribute("garett_all_product_counter", productRepository.countByDystrybutor("GARETT").toString());
        model.addAttribute("garett_available_product_counter", productRepository.findByKodMarkoIsNotNullAndDystrybutorAndStanGreaterThan("GARETT", 0).size());
        model.addAttribute("marko_all_product_counter", productRepository.countByDystrybutor("MARKO").toString());
        model.addAttribute("marko_available_product_counter", productRepository.findByKodMarkoIsNotNullAndDystrybutorAndStanGreaterThan("MARKO", 0).size());
        model.addAttribute("alkor_all_product_counter", productRepository.countByDystrybutor("ALKOR").toString());
        model.addAttribute("alkor_available_product_counter", productRepository.findByKodMarkoIsNotNullAndDystrybutorAndStanGreaterThan("ALKOR", 0).size());
        model.addAttribute("jubiler_all_product_counter", productRepository.countByDystrybutor("JUBILER").toString());
        model.addAttribute("jubiler_available_product_counter", productRepository.findByKodMarkoIsNotNullAndDystrybutorAndStanGreaterThan("JUBILER", 0).size());
        model.addAttribute("timex_all_product_counter", productRepository.countByDystrybutor("TIMEX").toString());
        model.addAttribute("timex_available_product_counter", productRepository.findByKodMarkoIsNotNullAndDystrybutorAndStanGreaterThan("TIMEX", 0).size());
        model.addAttribute("wiko_all_product_counter", productRepository.countByDystrybutor("WIKO").toString());
        model.addAttribute("wiko_available_product_counter", productRepository.findByKodMarkoIsNotNullAndDystrybutorAndStanGreaterThan("WIKO", 0).size());
        model.addAttribute("ergold_all_product_counter", productRepository.countByDystrybutor("ERGOLD").toString());
        model.addAttribute("ergold_available_product_counter", productRepository.findByKodMarkoIsNotNullAndDystrybutorAndStanGreaterThan("ERGOLD", 0).size());

        model.addAttribute("producenci", productRepository.znajdzProducentow());
        return "index";
    }

    @RequestMapping(value = "/update_GESE", method = RequestMethod.POST)
    public String replaceGeseRow(@RequestParam("file") MultipartFile file, ModelMap model) throws IOException {
        productRepository.changeStockToZero("GESE");
        Map<String, String> kodeMap = geseService.createMapFromCsvFile(file);
//        geseService.xmlFileScrapper();
        List<ProductEntity> productList = geseService.geseProductListFromFacebookXmlFile(kodeMap);
        productRepository.saveAll(productList);
        model.addAttribute("gese_all_product_counter", productRepository.countByDystrybutor("GESE").toString());
        model.addAttribute("gese_available_product_counter", productRepository.findByKodMarkoIsNotNullAndDystrybutorAndStanGreaterThan("GESE", 0).size());
        return "redirect:/panel";
    }

    @RequestMapping(value = "/update_ERGOLD", method = RequestMethod.POST)
    public String replaceErgoldRow(@RequestParam("file") MultipartFile file, ModelMap model) throws IOException {
        productRepository.changeStockToZero("ERGOLD");
        Map<String, String> kodeMap = geseService.createMapFromCsvFile(file);
//        geseService.xmlFileScrapper();
        List<ProductEntity> productList = ergoldService.geseProductListFromXmlFile(kodeMap);
        productRepository.saveAll(productList);
        model.addAttribute("ergold_all_product_counter", productRepository.countByDystrybutor("ERGOLD").toString());
        model.addAttribute("ergold_available_product_counter", productRepository.findByKodMarkoIsNotNullAndDystrybutorAndStanGreaterThan("ERGOLD", 0).size());
        return "redirect:/panel";
    }

    @RequestMapping(value = "/update_GARETT", method = RequestMethod.POST)
    public String replaceGarettRow(@RequestParam("file") MultipartFile file, ModelMap model) throws IOException {
        productRepository.changeStockToZero("GARETT");
        Map<String, String> kodeMap = garettService.createMapFromCsvFile(file);
        List<ProductEntity> productList = garettService.garettProductListFromXmlFile(kodeMap);
        productRepository.saveAll(productList);
        model.addAttribute("garett_all_product_counter", productRepository.countByDystrybutor("GARETT").toString());
        model.addAttribute("garett_available_product_counter", productRepository.findByKodMarkoIsNotNullAndDystrybutorAndStanGreaterThan("GARETT", 0).size());
        return "redirect:/panel";
    }

    @RequestMapping(value = "/update_MARKO", method = RequestMethod.POST)
    public String replaceMarkoRow(@RequestParam("file") MultipartFile file, ModelMap model) throws IOException {
        productRepository.changeStockToZero("MARKO");
//        List<ProductEntity> productList = markoService.markoProductListFromXmlsFile("Stan_MARKO.csv");
        List<ProductEntity> productList = markoService.markoProductListFromUploadFile(file);
        productRepository.saveAll(productList);
        model.addAttribute("marko_all_product_counter", productRepository.countByDystrybutor("MARKO").toString());
        model.addAttribute("marko_available_product_counter", productRepository.findByKodMarkoIsNotNullAndDystrybutorAndStanGreaterThan("MARKO", 0).size());
        return "redirect:/panel";
    }

    @RequestMapping(value = "/update_WIKO", method = RequestMethod.POST)
    public String replaceWikoRow(@RequestParam("file") MultipartFile file, ModelMap model) throws IOException {
        productRepository.changeStockToZero("WIKO");

        List<ProductEntity> wikoProductList = wikoService.wikoProductListFromUploadFile(file);
        productRepository.saveAll(wikoProductList);
        model.addAttribute("wiko_all_product_counter", productRepository.countByDystrybutor("WIKO").toString());
        model.addAttribute("wiko_available_product_counter", productRepository.findByKodMarkoIsNotNullAndDystrybutorAndStanGreaterThan("WIKO", 0).size());
        return "redirect:/panel";
    }

    @RequestMapping(value = "/update_ALKOR", method = RequestMethod.GET)
    public String replaceAlkorRow(ModelMap model) throws IOException, ParseException {
        productRepository.changeStockToZero("ALKOR");
        List<ProductEntity> productList = alkorServices.alkorProductListFromWebsite();
        productRepository.saveAll(productList);
        model.addAttribute("alkor_all_product_counter", productRepository.countByDystrybutor("ALKOR").toString());
        model.addAttribute("alkor_available_product_counter", productRepository.findByKodMarkoIsNotNullAndDystrybutorAndStanGreaterThan("ALKOR", 0).size());

        return "index :: #row-ALKOR";
    }

    @RequestMapping(value = "/update_JUBILER", method = RequestMethod.GET)
    public String replaceJubiler(ModelMap model) throws IOException {
        productRepository.changeStockToZero("JUBILER");
        productRepository.saveAll(jubilerService.sendPOST("http://extranet.anyro.eu/index.php/mod_dostepnosc?mode=preparetable_ajax&rt=Zegarki_____BERING&_search=false&nd=1611949457881&rows=2000&page=1&sidx=id&sord=asc&oper=excel", "Bering"));
        productRepository.saveAll(jubilerService.sendPOST("http://extranet.anyro.eu/index.php/mod_dostepnosc?mode=preparetable_ajax&rt=Zegarki_____CITIZEN&_search=false&nd=1611956641681&rows=2000&page=1&sidx=id&sord=asc&oper=excel", "Citizen"));
        productRepository.saveAll(jubilerService.sendPOST("http://extranet.anyro.eu/index.php/mod_dostepnosc?mode=preparetable_ajax&rt=Zegarki_____ICE-WATCH&_search=false&nd=1611997732942&rows=2000&page=1&sidx=id&sord=asc&oper=excel", "Ice Watch"));
        productRepository.saveAll(jubilerService.sendPOST("http://extranet.anyro.eu/index.php/mod_dostepnosc?mode=preparetable_ajax&rt=Bi%C5%BCuteria_____TOMMY%20HILFIGER&_search=false&nd=1635327900397&rows=2000&page=1&sidx=id&sord=asc&oper=excel", "Tommy Bizu"));
        productRepository.saveAll(jubilerService.sendPOST("http://extranet.anyro.eu/index.php/mod_dostepnosc?mode=preparetable_ajax&rt=Zegarki_____TOMMY%20HILFIGER&_search=false&nd=1612042676164&rows=2000&page=1&sidx=id&sord=asc&oper=excel", "Tommy Hilfiger"));
        model.addAttribute("jubiler_all_product_counter", productRepository.countByDystrybutor("JUBILER").toString());
        model.addAttribute("jubiler_available_product_counter", productRepository.findByKodMarkoIsNotNullAndDystrybutorAndStanGreaterThan("JUBILER", 0).size());
        return "index :: #row-JUBILER";
    }

    @RequestMapping(value = "/update_ZIBI", method = RequestMethod.GET)
    public String replaceZibi(ModelMap model) throws Exception {
//        alkorServices.zibiStock();
        return "index :: #row-ZIBI";
    }

    @RequestMapping(value = "/update_TIMEX", method = RequestMethod.GET)
    public String replaceTimex(ModelMap model
//            , @RequestParam("file") MultipartFile file
    ) throws Exception {

//        alkorServices.karkosikProductFromWebsite();
//        productRepository.deleteByProducent("GESE");
//        geseService.geseImageScrapper(file);
        geseService.geseAndMarkoImageScrapper();
        return "index :: #row-TIMEX";
    }

    @RequestMapping(value = "/update_GESE_xml_date", method = RequestMethod.GET)
    public String updateGeseFile(ModelMap model) throws Exception {
        model.addAttribute("gese_xml_update_date", geseService.geseUpdateDateXmlFile());
        return "index :: #row-GESE-xml_date";
    }

    @RequestMapping(value = "/set_stan_wirtualny", method = RequestMethod.POST)
    public String updateVirtualStock(ModelMap model, @RequestParam(required = false) String kod_produktu, @RequestParam(required = false) String stan_wirtualny) throws ParseException {
        System.out.println("kod produktu: " + kod_produktu + " - stan: " + stan_wirtualny);
//        artykulRepository.updateStanWirtualny(new BigDecimal(stan_wirtualny), kod_produktu);
        return "index";
    }

}
