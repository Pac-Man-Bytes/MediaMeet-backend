package edu.eci.arsw.mediameet.service.profileServices.impl;

import edu.eci.arsw.mediameet.model.Profile;
import edu.eci.arsw.mediameet.model.Room;
import edu.eci.arsw.mediameet.persistence.rooms.ProfileRepository;
import edu.eci.arsw.mediameet.service.MediaMeetException;
import edu.eci.arsw.mediameet.service.profileServices.ProfileServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServicesImpl implements ProfileServices {

    @Autowired
    ProfileRepository  repository;


    @Override
    public Profile save(Profile p) {
        if(repository.existsById(p.getId())){
            return p;
        }else{
            return repository.save(p);
        }
    }

    @Override
    public Profile loadById(String id) throws MediaMeetException {
        Optional<Profile> query = repository.findById(id);
        return query.orElseThrow(() ->new MediaMeetException(MediaMeetException.RESOURCE_NOT_FOUND));
    }

    @Override
    public List<Profile> loadProfiles() {
        return repository.findAll();
    }

    @Override
    public void addNewRoom(String id, Room room) throws MediaMeetException {
        Profile profile = loadById(id);
        if(profile.getRooms().stream().anyMatch(r -> r.getId().equals(room.getId()))) throw new MediaMeetException(MediaMeetException.REPEAT_ROOM);
        List<Room> rooms = profile.getRooms();
        rooms.add(room);
        profile.setRooms(rooms);
        save(profile);
    }

    @Override
    public void deleteProfiles() {
        repository.deleteAll();
    }
}
