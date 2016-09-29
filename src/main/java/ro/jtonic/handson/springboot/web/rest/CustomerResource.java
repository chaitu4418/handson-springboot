package ro.jtonic.handson.springboot.web.rest;

import io.swagger.annotations.*;
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

    @ApiOperation(value = "getGreeting", nickname = "getGreeting")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "User's name", required = false, dataType = "string", paramType = "query", defaultValue = "jtonic")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping("/customers.rest")
    String home() {
        final Customer customer = customerRepository.findAll().get(0);
        return customer.getName();
    }

}
