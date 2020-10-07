package edu.eci.arsw.mediameet.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.eci.arsw.MediaMeetAPIApplication;
import edu.eci.arsw.mediameet.model.Room;
import edu.eci.arsw.mediameet.service.roomservices.RoomServices;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.junit.Test;

import javax.xml.bind.SchemaOutputResolver;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * The type Controller test.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={ MediaMeetAPIApplication.class })
@AutoConfigureMockMvc

@AutoConfigureDataMongo
public class RoomControllerTest {
    private Room[] rooms;
    @Autowired
    private MockMvc mvc;
    @Autowired
    private RoomServices roomServices;


    @Before
    public void setUp(){
        this.rooms = new Room[5];
        for (int i=0; i<rooms.length; i++){
            rooms[i] = new Room();
            rooms[i].setName("Prueba " + i);
        }
    }
    @Test
    public void shouldCreateRoom() throws Exception {
        for (int i=0; i< rooms.length; i++){
            mvc.perform(
                    MockMvcRequestBuilders
                            .post("/api/rooms")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(asJsonString(rooms[i]))
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated()).andExpect(jsonPath("$.name",is("Prueba " + i)));
        }
    }
    @Test
    public void shouldGetRoomById() throws Exception {
        List<Room> rooms = roomServices.loadRooms();
        for(Room room : rooms){
            mvc.perform(
                    MockMvcRequestBuilders.get("/api/rooms/{id}",room.getId())
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("")
                            .accept(MediaType.APPLICATION_JSON)
            ).andExpect(status().isOk()).andExpect(jsonPath("$.id",is(room.getId())));
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
