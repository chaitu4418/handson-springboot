package ro.jtonic.handson.springboot.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by antonelpazargic on 07/09/16.
 */
@RestController
public class CustomerResource {

    @RequestMapping("/customers")
    String home() {
        return "Hello Spring Boot!!!";
    }

}
