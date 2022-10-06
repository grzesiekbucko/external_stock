package pl.bucko.external_stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.bucko.external_stock.entity.Artykul;
import pl.bucko.external_stock.repository.ArtykulRepository;
import pl.bucko.external_stock.service.KompletyServices;

import java.io.IOException;
import java.util.List;

@Controller
public class KompletyController {

    @Autowired
    private ArtykulRepository artykulRepository;

    @Autowired
    private KompletyServices kompletyServices;

    @RequestMapping(value = "/komplety", method = RequestMethod.GET)
    public ModelAndView showHomePage() throws IOException {
        ModelAndView model = new ModelAndView("komplety");
//        artykulRepository.findAllByIdIn(kompletyServices.pobierzIdKompetow());
//        model.addObject("komplety",  artykulRepository.findAllByIdIn(kompletyServices.pobierzIdKompetow()));
        model.addObject("komplety",  kompletyServices.produktykompletow());

        return model;
    }

    @RequestMapping(value = "/find_komplet", method = RequestMethod.POST)
    public String showSelected(ModelMap model, @RequestParam(required = false) String kod_kompletu) {
        System.out.println("kod - " + kod_kompletu);
        List<Artykul> komplety = artykulRepository.findByIndeksKatalogowy(kod_kompletu);
        model.addAttribute("komplety", komplety);
        System.out.println(komplety);
        return "komplety";
    }


}
