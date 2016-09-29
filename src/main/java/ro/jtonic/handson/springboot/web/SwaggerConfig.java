package ro.jtonic.handson.springboot.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by Antonel Ernest Pazargic on 22/09/16.
 *
 * @author Antonel Ernest Pazargic
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("customers")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/customers.*"))
                .build()
                ;
    }

    @Bean
    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring boot REST with swagger")
                .description("Spring boot REST with swagger")
                .version("1.0")
                .contact(new Contact("Antonel Ernest Pazargic", "", "antonel.pazargic@gmail.com"))
                .license("Apache License Version 2.0")
                .build();
    }

}
