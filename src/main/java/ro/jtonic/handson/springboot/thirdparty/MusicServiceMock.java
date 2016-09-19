package ro.jtonic.handson.springboot.thirdparty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheKey;
import javax.cache.annotation.CacheResult;
import javax.inject.Inject;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Antonel Ernest Pazargic on 19/09/16.
 *
 * @author Antonel Ernest Pazargic
 */
@CacheDefaults(cacheName = "music")
public class MusicServiceMock implements MusicService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MusicServiceMock.class);

    private MelodyGenerator melodyGenerator;

    @Inject
    void config(MelodyGenerator melodyGenerator) {
        this.melodyGenerator = melodyGenerator;
    }

    @Override
    @CacheResult
    public List<String> getMelodies(@CacheKey String singer) {
        return this.melodyGenerator.generateMelodies(singer);
    }

    @Component
    public static class MelodyGenerator {
        private Random random = new Random();

        public List<String> generateMelodies(String singer) {
            final String melody = "Melody #"  + Integer.toString(random.nextInt(Integer.MAX_VALUE));
            final List<String> melodies = Collections.singletonList(melody);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(String.format("The melodies: %s", melodies.toString()));
            }
            return melodies;
        }

    }
}
