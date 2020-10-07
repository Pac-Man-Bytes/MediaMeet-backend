package edu.eci.arsw.mediameet.controllers;

import edu.eci.arsw.MediaMeetAPIApplication;
import edu.eci.arsw.mediameet.model.Room;
import edu.eci.arsw.mediameet.service.roomservices.RoomServices;
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
public class MediaControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldGetMediaByQueryString() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/api/media/youtube")
                        .param("query","prueba")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("")
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }
    @Test
    public void shouldGetMediaByQueryUrl() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/api/media/youtube")
                        .param("query","https://www.youtube.com/watch?v=uNkXChX_uHM")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("")
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }
}
