package edu.eci.arsw.mediameet.service.roomservices.impl;

import edu.eci.arsw.mediameet.model.Room;
import edu.eci.arsw.mediameet.persistence.rooms.RoomRepository;
import edu.eci.arsw.mediameet.service.MediaMeetException;
import edu.eci.arsw.mediameet.service.roomservices.RoomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServicesImpl implements RoomServices {

    @Autowired
    private RoomRepository repository;

    @Override
    @Transactional
    public Room save(Room r) {
        return  repository.save(r);
    }

    @Override
    @Transactional(readOnly = true)
    public Room loadById(String id) throws MediaMeetException{
        Optional<Room> room = repository.findById(id);
        if(room.isPresent()){
            return room.get();
        }else{
            throw new MediaMeetException(MediaMeetException.RESOURCE_NOT_FOUND);
        }
    }
    @Override
    @Transactional(readOnly = true)
    public List<Room> loadRooms() {
        return repository.findAll();
    }
}
