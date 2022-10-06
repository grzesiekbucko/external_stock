package pl.bucko.external_stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pl.bucko.external_stock.service.GeseService;
import pl.bucko.external_stock.service.ShoperApiImageService;

import java.io.IOException;

@Controller
public class ShoperApiImagesControler {

    @Autowired
    private GeseService geseService;
    @Autowired
    private ShoperApiImageService shoperApiImageService;

    @RequestMapping(value = "/shoper_images", method = RequestMethod.GET)
    public ModelAndView showApiPage() throws IOException {
        return new ModelAndView("shoper_images");
    }

    @RequestMapping(value = "/shoper_images_convert", method = RequestMethod.POST)
    public ModelAndView imageImport(@RequestParam("imageListFile") MultipartFile file, @RequestParam("token") String token) throws IOException, InterruptedException {
        shoperApiImageService.updateImageNameByImageId(file, token);

        ModelAndView model = new ModelAndView("shoper_images");

        return model;
    }

    @RequestMapping(value = "/image_comparison", method = RequestMethod.POST)
    public ModelAndView imageImport(@RequestParam("imageListFile") MultipartFile imageListFile) throws IOException, InterruptedException {
        ModelAndView model = new ModelAndView("shoper_images");
        model.addObject("productList", geseService.geseImageScrapper(imageListFile));
        return model;
    }

}
