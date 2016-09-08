package ro.jtonic.handson.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import ro.jtonic.handson.springboot.entities.Customer;

/**
 * Created by antonelpazargic on 06/09/16.
 */
@RepositoryRestResource(path = "customers") // customers is the default by I dropped this annotation in order to see how this can be changed
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @RestResource(path = "byName", rel = "byName")
    // curl -X GET -v "http://localhost:8080/customers/search/byName?name=Antonel%20Pazargic"
    Customer findByName(@Param("name") String name);

    @RestResource(path = "byId", rel = "byId")
    // curl -v -X GET "http://localhost:8080/customers/search/byId?id=1"
    Customer findById(@Param("id") Long id);

}
