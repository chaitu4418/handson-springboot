package ro.jtonic.handson.springboot.customization;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import ro.jtonic.handson.springboot.entities.Customer;

/**
 * Created by Antonel Ernest Pazargic on 10/09/16.
 * @author Antonel Ernest Pazargic
 */
// Uncomment below if you want the entities @Id id to be serialized in the sent json
// @Component
public class SpringDataRestCustomization extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Customer.class);
    }
}
