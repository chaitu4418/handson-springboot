package ro.jtonic.handson.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.jtonic.handson.springboot.entities.Customer;

/**
 * Created by antonelpazargic on 06/09/16.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByName(String name);

}
