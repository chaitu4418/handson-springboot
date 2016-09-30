package ro.jtonic.handson.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import ro.jtonic.handson.springboot.entities.Customer;
import ro.jtonic.handson.springboot.repositories.CustomerRepository;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MainApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(applicationClass);
	}

	private static Class<MainApplication> applicationClass = MainApplication.class;

	private CustomerRepository customerRepository;

	@Autowired
	private void config(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			final List<Customer> customers = Arrays.asList(
					new Customer("Antonel Ernest Pazargic"),
					new Customer("Irina Stan", (byte) 25),
					new Customer("Liviu Pazargic", (byte) 33),
					new Customer("Magdalena Jipa", (byte) 43)
			);
			customers.forEach(c -> customerRepository.save(c));
		};
	}

}


