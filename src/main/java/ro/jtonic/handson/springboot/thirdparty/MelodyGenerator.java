package ro.jtonic.handson.springboot.thirdparty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Antonel Ernest Pazargic on 20/09/16.
 *
 * @author Antonel Ernest Pazargic
 */
public class MelodyGenerator {
    private static final Logger LOGGER = LoggerFactory.getLogger(MelodyGenerator.class);

    private Random random = new Random();

    public List<String> generateMelodies(String singer) {
        final String melody = "Melody #" + Integer.toString(random.nextInt(Integer.MAX_VALUE));
        final List<String> melodies = Collections.singletonList(melody);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("The melodies: %s", melodies.toString()));
        }
        return melodies;
    }

}
