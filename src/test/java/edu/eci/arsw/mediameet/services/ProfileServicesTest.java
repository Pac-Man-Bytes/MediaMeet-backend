package edu.eci.arsw.mediameet.services;

import edu.eci.arsw.mediameet.model.Profile;
import edu.eci.arsw.mediameet.model.Room;
import edu.eci.arsw.mediameet.service.MediaMeetException;
import edu.eci.arsw.mediameet.service.profileServices.ProfileServices;
import edu.eci.arsw.mediameet.service.roomservices.RoomServices;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith( SpringRunner.class )
@SpringBootTest
public class ProfileServicesTest {

    @Autowired
    private ProfileServices profileServices;

    @Test
    public void shouldSLoadProfileById(){
        Profile profileTest = new Profile();
        profileTest.setId("USUARIO_TEST");
        this.profileServices.save(profileTest);
        try{
            profileServices.loadById(profileTest.getId());
            Assert.assertTrue(true);
        }catch (MediaMeetException e){
            Assert.fail();
        }
    }

}
