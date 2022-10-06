package pl.bucko.external_stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.bucko.external_stock.dto.ZamowienieDtoInterface;
import pl.bucko.external_stock.entity.Zamowienie;
import pl.bucko.external_stock.repository.PozycjaZamowieniaRepository;
import pl.bucko.external_stock.repository.ZamowienieDtoRepository;
import pl.bucko.external_stock.repository.ZamowienieRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class ZamowieniaController {

    @Autowired
    private ZamowienieDtoRepository zamowienieDtoRepository;
    @Autowired
    private ZamowienieRepository zamowienieRepository;
    @Autowired
    private PozycjaZamowieniaRepository pozycjaZamowieniaRepository;

    @RequestMapping(value = "/zamowienia", method = RequestMethod.GET)
    public String showRaportyPage() throws IOException, ParseException {
        return "zamowienia";
    }

    @RequestMapping(value = "/szukaj_zamowien", method = RequestMethod.POST)
    public String findOrders(ModelMap model, @RequestParam(required = false) String data_start) throws ParseException {
        model.addAttribute("data_start", data_start);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = format.parse(data_start);

        Calendar c = Calendar.getInstance();
        c.setTime(format.parse(data_start));
        c.add(Calendar.DATE, 1);  // number of days to add
        Date endDate = format.parse(format.format(c.getTime()));  // dt is now the new date

        List<Zamowienie> zamowienieList = zamowienieRepository.znajdzPoDacie(startDate, endDate);
        model.addAttribute("zamowieniaList", zamowienieList );
        return "zamowienia";
    }

    @RequestMapping(value = "/edytuj_zamowienie/{id_zam}", method = RequestMethod.GET)
    public String showSelected(ModelMap model, @PathVariable String id_zam) throws ParseException {
        List<ZamowienieDtoInterface> zamowienieDtoList = zamowienieDtoRepository.getZamowieniaDtoById(id_zam);
        model.addAttribute("zamowienieDto", zamowienieDtoList );
        model.addAttribute("id_zamowienia", id_zam);
        return "zamowienie_edit";
    }

    @RequestMapping(value = "/zamowienie/delete", method = RequestMethod.POST)
    public String deleteSelected(@RequestParam String id_poz_zam, @RequestParam String id_zam){
        System.out.println("post delete id pozycji zam - " + id_poz_zam + " / id zamowienia - " + id_zam);
        pozycjaZamowieniaRepository.deleteById(Long.valueOf(id_poz_zam));
        return "redirect:/edytuj_zamowienie/"+id_zam;
    }

    @RequestMapping(value = "/zamowienie/update", method = RequestMethod.POST)
    public String updateSelected(@RequestParam String id_poz_zam, @RequestParam String id_zam, @RequestParam String ilosc){
        System.out.println("post delete id pozycji zam - " + id_poz_zam + " / id zamowienia - " + id_zam);

        pozycjaZamowieniaRepository.updateIloscZamowienia(Long.parseLong(id_poz_zam), new BigDecimal(ilosc));
        return "redirect:/edytuj_zamowienie/"+id_zam;
    }

}
