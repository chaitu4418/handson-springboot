package ro.jtonic.handson.springboot.web.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by antonelpazargic on 07/09/16.
 */
@Controller
public class CustomerController {

    @RequestMapping(value = "/customers.php", method = RequestMethod.GET, produces = {MediaType.TEXT_PLAIN_VALUE})
    public @ResponseBody String customerId() {
        return "1";
    }

}
