package pl.bucko.external_stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pl.bucko.external_stock.service.KropaService;

import java.io.File;
import java.io.IOException;

@Controller
public class KropaZdjeciaControler {

    @Autowired
    private KropaService kropaService;

    @RequestMapping(value = "/kropa_zdjecia", method = RequestMethod.GET)
    public ModelAndView showKropaPage() throws IOException {
        return new ModelAndView("kropa_zdjecia");
    }


    @RequestMapping(value = "/kropa_image_copy", method = RequestMethod.POST)
    public ModelAndView imageImport(
            @RequestParam("imageListFile") MultipartFile imageListFile
//            , @RequestParam("imageFolder") MultipartFile folderPath
    ) throws IOException, InterruptedException {
        ModelAndView model = new ModelAndView("kropa_zdjecia");

        model.addObject("file_name", kropaService.imageCoppy(imageListFile));

        return model;
    }

}
