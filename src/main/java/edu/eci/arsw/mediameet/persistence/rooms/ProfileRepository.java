package edu.eci.arsw.mediameet.persistence.rooms;

import edu.eci.arsw.mediameet.model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileRepository  extends MongoRepository<Profile, String> {

}
