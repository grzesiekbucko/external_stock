package pl.bucko.external_stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pl.bucko.external_stock.service.AtrybutyService;
import pl.bucko.external_stock.service.Util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class AttributesControler {

    @Autowired
    private AtrybutyService atrybutyService;

    @RequestMapping(value = "/atrybuty", method = RequestMethod.GET)
    public ModelAndView showAtrybutyPage() throws IOException {
        return new ModelAndView("atrybuty");
    }

    @RequestMapping(value = "/convert_attributes", method = RequestMethod.POST)
    public ModelAndView replaceMarkoRow(@RequestParam("file") MultipartFile file, @RequestParam("attrFile") MultipartFile attrFile) throws IOException {
        ModelAndView model = new ModelAndView("atrybuty");
        ArrayList<String> arr = atrybutyService.txtFileReader(attrFile);

        Map<String, Map> map = atrybutyService.readExcel(file);
        List mapList = atrybutyService.mapfilter(map, arr);
        Map<String, Map> fineMap = (Map<String, Map>) mapList.get(0);
//        atrybutyService.createCsvFile(fineMap);
        atrybutyService.createCsvFile2(fineMap);
        System.out.println("Fine MAP: " + fineMap);
        System.out.println("Error MAP: " + mapList.get(1));
        model.addObject("error", mapList.get(1));
        return model;
    }

    @RequestMapping(value = "/download_file", method = RequestMethod.GET)
    @ResponseBody
    public FileSystemResource downloadFile() {
        return new FileSystemResource(new File("new.csv"));
    }

}
