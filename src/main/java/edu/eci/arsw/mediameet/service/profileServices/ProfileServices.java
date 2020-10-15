package edu.eci.arsw.mediameet.service.profileServices;

import edu.eci.arsw.mediameet.model.Profile;

import java.util.List;

public interface ProfileServices {

    Profile save(Profile p);
    Profile loadById(String id);
    List<Profile> loadProfiles();
}
