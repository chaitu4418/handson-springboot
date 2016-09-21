package ro.jtonic.handson.springboot.integr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by Antonel Ernest Pazargic on 21/09/16.
 *
 * @author Antonel Ernest Pazargic
 */
@Configuration
@EnableIntegration
@IntegrationComponentScan
public class IntegrationConfig implements CommandLineRunner {

    private Upcase upcase;

    @MessagingGateway
    public interface Upcase {
        @Gateway(requestChannel = "upcase.input")
        Collection<String> upcase(Collection<String> strings);
    }

    @Bean
    public IntegrationFlow upcase() {
        return f -> f
                .split()
                .<String, String>transform(String::toUpperCase)
                .aggregate();
    }

    @Autowired
    void upcase(Upcase uc) {
        this.upcase = uc;
    }

    @Override
    public void run(String... args) throws Exception {
        final List<String> strings = Arrays.asList("antonel", "liviu", "magda");
        final Collection<String> upcasedStrings = this.upcase.upcase(strings);
        System.out.println("Upcased strings: " + upcasedStrings);
    }

}
