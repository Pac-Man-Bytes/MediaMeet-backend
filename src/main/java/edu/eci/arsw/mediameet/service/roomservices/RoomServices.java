package edu.eci.arsw.mediameet.service.roomservices;

import edu.eci.arsw.mediameet.model.Room;
import edu.eci.arsw.mediameet.service.MediaMeetException;


public interface RoomServices {

    public Room save( Room r);
    public Room loadById(String id) throws MediaMeetException;
}
