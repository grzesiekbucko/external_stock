package pl.bucko.external_stock.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.bucko.external_stock.service.CacheService;


import java.io.IOException;

@Controller
public class CacheControler {

    @Autowired
    private CacheService cacheService;

    @RequestMapping(value = "/cache", method = RequestMethod.GET)
    public ModelAndView showKropaPage() throws IOException {
        return new ModelAndView("cache");
    }

    @RequestMapping(value = "/clear_cache", method = RequestMethod.POST)
    public ModelAndView imageImport(
            @RequestParam("time_start") String startHour) throws IOException, InterruptedException, UnirestException {
        ModelAndView model = new ModelAndView("cache");

        model.addObject("timeFromDb", cacheService.clearCacheOnTime(startHour));

        return model;
    }

}
