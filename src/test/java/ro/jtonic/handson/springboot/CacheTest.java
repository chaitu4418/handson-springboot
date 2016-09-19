package ro.jtonic.handson.springboot;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ro.jtonic.handson.springboot.thirdparty.MusicService;
import ro.jtonic.handson.springboot.thirdparty.MusicServiceMock.MelodyGenerator;

import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

/**
 * Created by Antonel Ernest Pazargic on 19/09/16.
 *
 * @author Antonel Ernest Pazargic
 */
@SpringBootTest
public class CacheTest extends AbstractTestNGSpringContextTests {

    private MusicService musicService;
    private Cache cache;
    private MelodyGenerator melodyGenerator;

    @Inject
    void config(MusicService musicService, CacheManager cacheManager, MelodyGenerator melodyGenerator) {
        this.musicService = musicService;
        this.cache = cacheManager.getCache("music");
        this.melodyGenerator = melodyGenerator;
    }

    @AfterTest
    public void tearDown() {
        Mockito.<Class>reset(CacheTest.class);
        // this.cache.clear();
    }

    public CacheTest() {
    }

    @DataProvider(name = "dp1")
    public Object[][] dataProvider() {
        return new Object[][]{
                {"Madonna", "Melody 1"},
                {"Madonna", "Melody 2"},
                {"Madonna", "Melody 3"},
                {"Madonna", "Melody 4"},
        };
    }

    @Test(dataProvider = "dp1")
    public void testCache(String singerName, String expectedMelody) throws Exception {
        Mockito.when(this.melodyGenerator.generateMelodies(singerName)).thenReturn(Collections.singletonList(expectedMelody));

        final List<String> melodies = musicService.getMelodies(singerName);
        Assert.assertThat(melodies, Matchers.hasSize(1));

        org.testng.Assert.assertEquals(melodies.get(0), "Melody 1");
    }

    @Configuration
    static class TestConfig {
        @Bean
        MelodyGenerator melodyGenerator() {
            return Mockito.mock(MelodyGenerator.class);
        }
    }
}
