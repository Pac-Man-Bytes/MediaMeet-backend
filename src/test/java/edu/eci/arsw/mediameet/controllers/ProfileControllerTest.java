package edu.eci.arsw.mediameet.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.eci.arsw.MediaMeetAPIApplication;
import edu.eci.arsw.mediameet.model.Profile;
import edu.eci.arsw.mediameet.model.Room;
import edu.eci.arsw.mediameet.service.profileServices.ProfileServices;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={ MediaMeetAPIApplication.class })
@AutoConfigureMockMvc

@AutoConfigureDataMongo
public class ProfileControllerTest {

    private Profile profile;
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ProfileServices profileServices;


    @Before
    public void setUp(){
        profile = new Profile();
        profile.setId("USUARIODEPRUEBA");
        profileServices.deleteProfiles();
    }
    @Test
    public void shouldSaveProfile() throws Exception {
            mvc.perform(
                    MockMvcRequestBuilders
                            .post("/api/profiles")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(asJsonString(profile))
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated()).andExpect(jsonPath("$.id",is("USUARIODEPRUEBA" )));
    }
    @Test
    public void shouldGetProfileById() throws Exception {
        profileServices.deleteProfiles();

        //Add Profiles
        Profile p1 = new Profile();
        p1.setId("USUARIODEPRUEBA2");
        Profile p2 = new Profile();
        p2.setId("USUARIODEPRUEBA3");

        profileServices.save(p1);
        profileServices.save(p2);


        List<Profile> query = profileServices.loadProfiles();
        for(Profile profile : query){
            mvc.perform(
                    MockMvcRequestBuilders.get("/api/profiles/{id}",profile.getId())
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("")
                            .accept(MediaType.APPLICATION_JSON)
            ).andExpect(status().isOk()).andExpect(jsonPath("$.id",is(profile.getId())));
        }
    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
