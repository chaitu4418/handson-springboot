package ro.jtonic.handson.springboot;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.jtonic.handson.springboot.thirdparty.MelodyGenerator;
import ro.jtonic.handson.springboot.thirdparty.MusicService;
import ro.jtonic.handson.springboot.thirdparty.MusicServiceMock;

/**
 * Created by Antonel Ernest Pazargic on 19/09/16.
 *
 * @author Antonel Ernest Pazargic
 */
@Configuration
@EnableCaching(proxyTargetClass = true)
public class ApplicationConfig {

    @Bean
    MusicService musicService() {
        return new MusicServiceMock();
    }

    @Bean
    MelodyGenerator melodyGenerator() {
        return new MelodyGenerator();
    }


}
