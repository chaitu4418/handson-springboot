package ro.jtonic.handson.springboot;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Antonel Ernest Pazargic on 10/09/16.
 * @author Antonel Ernest Pazargic
 */
@Configuration
public class ServletsRegistrationConfigurer {

    @Bean
    public ServletRegistrationBean
    h2servletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
        registration.addUrlMappings("/console/*");
        return registration;
    }

}
