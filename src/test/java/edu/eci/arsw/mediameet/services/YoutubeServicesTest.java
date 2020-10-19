package edu.eci.arsw.mediameet.services;

import edu.eci.arsw.mediameet.model.Video;
import edu.eci.arsw.mediameet.service.MediaMeetException;
import edu.eci.arsw.mediameet.service.externalservices.youtube.YoutubeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith( SpringRunner.class )
@SpringBootTest
public class YoutubeServicesTest {
    @Autowired
    private YoutubeService youtubeService;
    @Test
    public void shouldGetMediaByQueryString(){
        try {
            Video video = youtubeService.getVideo("Prueba1");
            Assert.assertTrue(video.getTitle().length() > 0);
            Assert.assertTrue(video.getImage().length() > 0);
            Assert.assertEquals(video.getTime(),0);
        } catch (MediaMeetException e) {
            Assert.fail();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void shouldGetMediaByQueryUrl(){
        try {
            Video video = youtubeService.getVideo("https://www.youtube.com/watch?v=uNkXChX_uHM");
            Assert.assertTrue(video.getTitle().length() > 0);
            Assert.assertTrue(video.getImage().length() > 0);
            Assert.assertEquals(video.getTime(),0);
        } catch (MediaMeetException e) {
            Assert.fail();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
