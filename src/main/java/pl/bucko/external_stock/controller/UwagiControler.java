package pl.bucko.external_stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pl.bucko.external_stock.service.UwagiService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UwagiControler {

    @Autowired
    private UwagiService uwagiService;

    @RequestMapping(value = "/uwagi_opis", method = RequestMethod.GET)
    public ModelAndView showAtrybutyPage() throws IOException {
        return new ModelAndView("uwagi_opis");
    }

    @RequestMapping(value = "/convert_uwagi", method = RequestMethod.POST)
    public ModelAndView replaceMarkoRow(@RequestParam("file") MultipartFile file, @RequestParam("attrFile") MultipartFile attrFile) throws IOException {
        ModelAndView model = new ModelAndView("uwagi_opis");
        ArrayList<String> arr = uwagiService.txtFileReader(attrFile);

        Map<String, Map> map = uwagiService.readExcel(file);
        List mapList = uwagiService.mapfilter(map, arr);
        Map<String, Map> fineMap = (Map<String, Map>) mapList.get(0);
        uwagiService.createCsvFile(fineMap);
        System.out.println("Fine MAP: " + fineMap);
        System.out.println("Error MAP: " + mapList.get(1));
        model.addObject("error", mapList.get(1));
        return model;
    }

    @RequestMapping(value = "/download_file_uwagi", method = RequestMethod.GET)
    @ResponseBody
    public FileSystemResource downloadFile() {
        return new FileSystemResource(new File("new.csv"));
    }

}
