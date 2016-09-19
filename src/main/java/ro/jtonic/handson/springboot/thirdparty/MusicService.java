package ro.jtonic.handson.springboot.thirdparty;

import java.util.List;

/**
 * Created by Antonel Ernest Pazargic on 19/09/16.
 *
 * @author Antonel Ernest Pazargic
 */
public interface MusicService {

    List<String> getMelodies(String singer);

}
