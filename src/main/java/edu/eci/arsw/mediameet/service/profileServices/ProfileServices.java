package edu.eci.arsw.mediameet.service.profileServices;

import edu.eci.arsw.mediameet.model.Profile;
import edu.eci.arsw.mediameet.service.MediaMeetException;

import java.util.List;

public interface ProfileServices {

    Profile save(Profile p);
    Profile loadById(String id) throws MediaMeetException;
    List<Profile> loadProfiles();
}
