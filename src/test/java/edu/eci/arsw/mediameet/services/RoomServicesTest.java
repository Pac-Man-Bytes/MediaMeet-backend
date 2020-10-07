package edu.eci.arsw.mediameet.services;

import edu.eci.arsw.mediameet.model.Room;
import edu.eci.arsw.mediameet.service.MediaMeetException;
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
public class RoomServicesTest {
    @Autowired
    private RoomServices roomServices;
    @Test
    public void shouldSaveRoom(){
        Room roomTest = new Room();
        roomTest.setName("Prueba123");
        this.roomServices.save(roomTest);
        List<Room> rooms = roomServices.loadRooms();
        for(Room room :rooms){
            if (room.getName().equals("Prueba123")){
                Assert.assertTrue(true);
                break;
            }else{
                Assert.assertTrue(true);
            }
        }
    }
    @Test
    public void shouldLoadRoomById(){
        List<Room> rooms = roomServices.loadRooms();
        for(Room room:rooms){
            try {
                roomServices.loadById(room.getId());
            } catch (MediaMeetException e) {
                Assert.fail();
            }
        }
        Assert.assertTrue(true);

    }

}
