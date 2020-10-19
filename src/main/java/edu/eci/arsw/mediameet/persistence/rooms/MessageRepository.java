package edu.eci.arsw.mediameet.persistence.rooms;

import edu.eci.arsw.mediameet.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String> {
}
