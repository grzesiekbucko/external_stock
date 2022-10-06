package pl.bucko.external_stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.bucko.external_stock.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
//        userService.saveUser(new User("admin@admin.ad", "PassAdmin", "Admin"));
        return modelAndView;
    }

    @RequestMapping(value = "/default", method = RequestMethod.GET)
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/raporty";
        }
        if (request.isUserInRole("ROLE_USER")) {
            return "redirect:/raporty";
        }
        return "redirect:/login";
    }

}
