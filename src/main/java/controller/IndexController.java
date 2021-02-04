package controller;

import kpfu.Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Azat Zaripov on 23.12.2015.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getPage(){
        Service service = new Service();
        System.out.println(service.showString());
        return "index";
    }

}
