package edu.eci.arsw.mediameet.controllers;

import edu.eci.arsw.mediameet.model.Room;
import edu.eci.arsw.mediameet.service.MediaMeetException;
import edu.eci.arsw.mediameet.service.roomservices.RoomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//@CrossOrigin(origins = {"http://localhost:4200","https://media-meet.web.app"})
@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    RoomServices services;

    @PostMapping()
    public ResponseEntity<?> createRoom(@RequestBody Room room){
        try{
            return new ResponseEntity<>(services.save(room), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getRoomById(@PathVariable String id){
        try{
            Room room  = services.loadById(id);
            return new ResponseEntity<>(room,HttpStatus.OK);
        }catch (MediaMeetException e){
            Map<String,String> result = new HashMap<>();
            result.put("error",e.getMessage());
            result.put("message","Sala no encontrada");
            return new ResponseEntity<>(result,HttpStatus.NOT_FOUND);
        }
    }



}
