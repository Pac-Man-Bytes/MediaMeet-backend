package edu.eci.arsw.mediameet.service.roomservices.impl;

import edu.eci.arsw.mediameet.model.Message;
import edu.eci.arsw.mediameet.model.Profile;
import edu.eci.arsw.mediameet.model.Room;
import edu.eci.arsw.mediameet.persistence.rooms.RoomRepository;
import edu.eci.arsw.mediameet.service.MediaMeetException;
import edu.eci.arsw.mediameet.service.roomservices.RoomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RoomServicesImpl implements RoomServices {

    @Autowired
    private RoomRepository repository;

    @Override
    @Transactional
    public Room save(Room r) {
        return repository.save(r);
    }

    @Override
    public Room loadById(String id) throws MediaMeetException{
        Optional<Room> room = repository.findById(id);
        if (room.isPresent()) {
            return room.get();
        } else {
            throw new MediaMeetException(MediaMeetException.RESOURCE_NOT_FOUND);
        }
    }
    @Override
    @Transactional(readOnly = true)
    public List<Room> loadRooms() {
        return repository.findAll();
    }

    @Override
    public void saveMessage(Message message, String roomId) {
        Room room = null;
        try {
            room = this.loadById(roomId);
        } catch (MediaMeetException e) {
            e.printStackTrace();
        }
        Objects.requireNonNull(room).addMessage(message);
        repository.save(Objects.requireNonNull(room));
    }

    @Override
    public List<Message> getMessagesFromRoom(String roomId) {
        Room room = null;
        try {
            room = this.loadById(roomId);
        } catch (MediaMeetException e) {
            e.getMessage();
        }
        return room.getChat();
    }

    @Override
    public void addNewRoomMember(String id, Profile profile) throws MediaMeetException {

        Room room = loadById(id);
        List<Profile> profiles = room.getMembers();
        if(profiles.stream().anyMatch(p -> p.getId().equals(profile.getId()))) throw new MediaMeetException(MediaMeetException.THAT_MEMBER_ALREADY_EXISTS)
        profiles.add(profile);
        room.setMembers(profiles);
        save(room);

    }
}
