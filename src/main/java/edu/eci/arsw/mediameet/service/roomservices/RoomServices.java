package edu.eci.arsw.mediameet.service.roomservices;

import edu.eci.arsw.mediameet.model.Room;
import edu.eci.arsw.mediameet.service.MediaMeetException;

import java.util.List;


public interface RoomServices {

    Room save( Room r);
    Room loadById(String id) throws MediaMeetException;
    List<Room> loadRooms();

}
