package edu.eci.arsw.mediameet.controllers;


import edu.eci.arsw.mediameet.model.Profile;
import edu.eci.arsw.mediameet.model.Room;
import edu.eci.arsw.mediameet.service.MediaMeetException;
import edu.eci.arsw.mediameet.service.profileServices.ProfileServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    ProfileServices services;

    @PostMapping()
    public ResponseEntity<?> createProfile(@RequestBody Profile profile){
        try{
            return new ResponseEntity<>(services.save(profile), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public ResponseEntity<?> getProfiles(){
        return new ResponseEntity<>(services.loadProfiles(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProfileById(@PathVariable String id){
        try{
            Profile profile  = services.loadById(id);
            return new ResponseEntity<>(profile,HttpStatus.OK);
        }catch (MediaMeetException e){
            Map<String,String> result = new HashMap<>();
            result.put("error",e.getMessage());
            result.put("message","Perfil no encontrado");
            return new ResponseEntity<>(result,HttpStatus.NOT_FOUND);
        }
    }
}
