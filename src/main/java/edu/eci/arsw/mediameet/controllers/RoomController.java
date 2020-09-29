package edu.eci.arsw.mediameet.controllers;

import edu.eci.arsw.mediameet.model.Room;
import edu.eci.arsw.mediameet.service.roomservices.RoomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    RoomServices services;

    @PostMapping()
    public ResponseEntity<?> createRoom(@RequestBody Room room){
        try{
            System.out.println(room.getName());
            return new ResponseEntity<>(services.save(room), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
