package edu.eci.arsw.mediameet.services;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
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

import java.util.ArrayList;
import java.util.List;

@RunWith( SpringRunner.class )
@SpringBootTest
public class ProfileServicesTest {

    @Autowired
    private ProfileServices profileServices;

    @Test
    public void shouldSaveProfile() throws MediaMeetException {
        Profile profileTest = new Profile();
        profileTest.setId("USUARIO_TEST");
        profileServices.save(profileTest);
        Profile query = profileServices.loadById(profileTest.getId());
        if(query.getId().equals(profileTest.getId())){
            Assert.assertTrue(true);
        }else{
            Assert.fail();
        }
    }

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

    @Test
    public void shouldLoadProfiles(){
        //Clean Collection
        profileServices.deleteProfiles();

        //Add Profiles
        List<Profile> profiles =  new ArrayList<>();
        Profile p1 = new Profile();
        p1.setId("USUARIODEPRUEBA2");
        Profile p2 = new Profile();
        p2.setId("USUARIODEPRUEBA3");
        profiles.add(p1);
        profiles.add(p2);

        profileServices.save(p1);
        profileServices.save(p2);
        try {
            List<Profile> query = profileServices.loadProfiles();
            if (query.size() == profiles.size()) Assert.assertTrue(true);
        }catch (Exception e){
            Assert.fail();
        }
    }

}
