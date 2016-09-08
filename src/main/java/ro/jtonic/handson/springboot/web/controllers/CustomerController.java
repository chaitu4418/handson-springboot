package ro.jtonic.handson.springboot.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.jtonic.handson.springboot.entities.Customer;
import ro.jtonic.handson.springboot.repositories.CustomerRepository;

import java.util.List;

/**
 * Created by antonelpazargic on 07/09/16.
 */
@Controller
public class CustomerController {

    private CustomerRepository customerRepository;

    @Autowired
    void config(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping(value = "/customers.do", method = RequestMethod.GET, produces = {MediaType.TEXT_HTML_VALUE})
    public String customers(Model model) {
        final List<Customer> customers = this.customerRepository.findAll();
        model.addAttribute("customers", customers);
        return "customers";
    }

}
