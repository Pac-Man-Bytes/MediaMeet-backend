package edu.eci.arsw.mediameet.persistence.rooms;

import edu.eci.arsw.mediameet.model.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends MongoRepository<Room, String> {

    public Room saveRoom(Room room);

}
