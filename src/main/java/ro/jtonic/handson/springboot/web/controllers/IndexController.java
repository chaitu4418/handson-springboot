package ro.jtonic.handson.springboot.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Antonel Ernest Pazargic on 11/09/16.
 * @author Antonel Ernest Pazargic
 */
// @Controller
public class IndexController {

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

}
