package ro.jtonic.handson.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Antonel Ernest Pazargic on 13/09/16.
 * @author Antonel Ernest Pazargic
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .headers().frameOptions().sameOrigin().and() // Careful this allows clickjacking attacks
            .authorizeRequests()
                .antMatchers("/admin/info", "/admin/health").permitAll()
                .antMatchers("/index.html", "/api/**").hasRole("user")
                .antMatchers("/console/**").hasRole("admin")
                .antMatchers("/admin/**").hasRole("admin")
                .anyRequest().denyAll()
            .and()
                .csrf().disable()
                .formLogin().permitAll()
            .and()
            .logout()
                .logoutUrl("/logout")
                .permitAll()
        ;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        final InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> inMemAuth = auth
                .inMemoryAuthentication();
        auth
            .inMemoryAuthentication()
                .withUser("user").password("user").roles("user")
                .and()
                .withUser("admin").password("admin").roles("user", "admin");
    }

}
