package edu.eci.arsw.mediameet.service.roomservices;

import edu.eci.arsw.mediameet.model.Message;
import edu.eci.arsw.mediameet.model.Profile;
import edu.eci.arsw.mediameet.model.Room;
import edu.eci.arsw.mediameet.service.MediaMeetException;

import java.util.List;


public interface RoomServices {

    Room save(Room r);

    Room loadById(String id) throws MediaMeetException;

    List<Room> loadRooms();

    void saveMessage(Message message, String roomId);

    List<Message> getMessagesFromRoom(String roomId);

    void addNewRoomMember(String id, Profile profile) throws MediaMeetException;

}
