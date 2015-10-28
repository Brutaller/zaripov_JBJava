package controller;

import model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Azat Zaripov on 23.10.2015.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/")
    public String getIndexPage(Model model) {
        model.addAttribute(new Student());
        return "index";
    }

    ;

}
