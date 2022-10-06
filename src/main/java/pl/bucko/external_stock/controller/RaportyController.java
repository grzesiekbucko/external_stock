package pl.bucko.external_stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.bucko.external_stock.dto.ArtykulJoinDto;
import pl.bucko.external_stock.repository.ArtykulJoinDtoRepository;
import pl.bucko.external_stock.repository.ArtykulRepository;
import pl.bucko.external_stock.repository.ProductRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static pl.bucko.external_stock.service.Util.policzSprzedaz;

@Controller
public class RaportyController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ArtykulRepository artykulRepository;
    @Autowired
    private ArtykulJoinDtoRepository artykulJoinDtoRepository;

    @RequestMapping(value = "/raporty", method = RequestMethod.GET)
    public ModelAndView showRaportyPage() throws IOException {
        ModelAndView model = new ModelAndView("raporty");
        model.addObject("dostawcy", artykulRepository.znajdzDostawcow());
        return model;
    }

    @RequestMapping(value = "/sprzedaz_od_producenta", method = RequestMethod.POST)
    public String showSelected(ModelMap model, @RequestParam(required = false) String selected_producent, @RequestParam(required = false) String data_start, @RequestParam(required = false) String data_end) throws ParseException {
        model.addAttribute("dostawcy", artykulRepository.znajdzDostawcow());
        model.addAttribute("selected_producent", selected_producent);
        model.addAttribute("data_start", data_start);
        model.addAttribute("data_end", data_end);
        List<String> productSplitedList = Arrays.asList(selected_producent.split(","));
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = format.parse(data_start);
        Date endDate = format.parse(data_end);
        List<ArtykulJoinDto> artykulJoinDtoList = policzSprzedaz(artykulJoinDtoRepository.getArtykulJoinDto(productSplitedList, startDate, endDate));
        model.addAttribute("productList", artykulJoinDtoList );
        return "raporty";
    }

    @RequestMapping(value = "/update/{id}_{stock}_{stock_max}", method = RequestMethod.POST)
    public void updateStockById(@PathVariable String id, @PathVariable String stock, @PathVariable String stock_max) throws ParseException {
        artykulRepository.updateStanMinimalny(Long.parseLong(id), new BigDecimal(stock), new BigDecimal(stock_max));
        System.out.println("post controler id - " + id + " stock " + stock);

    }

}
