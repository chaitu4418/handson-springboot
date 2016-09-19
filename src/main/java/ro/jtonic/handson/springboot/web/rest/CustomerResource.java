package ro.jtonic.handson.springboot.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.jtonic.handson.springboot.entities.Customer;
import ro.jtonic.handson.springboot.repositories.CustomerRepository;

/**
 * Created by Antonel Ernest Pazargic on 07/09/16.
 * @author Antonel Ernest Pazargic
 */
@RestController
public class CustomerResource {

    private CustomerRepository customerRepository;

    @Autowired
    void config(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping("/customers.rest")
    String home() {
        final Customer customer = customerRepository.findAll().get(0);
        return customer.getName();
    }

}
