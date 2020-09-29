package edu.eci.arsw.mediameet.service.roomservices.impl;

import edu.eci.arsw.mediameet.model.Room;
import edu.eci.arsw.mediameet.persistence.rooms.RoomRepository;
import edu.eci.arsw.mediameet.service.roomservices.RoomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServicesImpl implements RoomServices {

    @Autowired
    private RoomRepository repository;

    @Override
    public Room save(Room r) {
        return  repository.save(r);
    }
}
