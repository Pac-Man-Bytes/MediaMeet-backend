package edu.eci.arsw.mediameet.service.profileServices.impl;

import edu.eci.arsw.mediameet.model.Profile;
import edu.eci.arsw.mediameet.persistence.rooms.ProfileRepository;
import edu.eci.arsw.mediameet.service.profileServices.ProfileServices;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProfileServicesImpl implements ProfileServices {

    @Autowired
    ProfileRepository  repository;


    @Override
    public Profile save(Profile p) {
        return repository.save(p);
    }

    @Override
    public Profile loadById(String id) {
        Optional<Profile> query = repository.findById(id);
        return query.orElse(null);
    }

    @Override
    public List<Profile> loadProfiles() {
        return repository.findAll();
    }
}
