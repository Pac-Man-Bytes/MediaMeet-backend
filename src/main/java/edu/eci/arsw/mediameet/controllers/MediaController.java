package edu.eci.arsw.mediameet.controllers;

import edu.eci.arsw.mediameet.model.Media;
import edu.eci.arsw.mediameet.service.externalservices.youtube.YoutubeService;
import edu.eci.arsw.mediameet.service.MediaMeetException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/media")
public class MediaController {
    @Autowired
    YoutubeService youtubeService;
    @GetMapping("/youtube/{query}")
    public ResponseEntity<?> getVideo (@PathVariable String query) {
        Media video = null;
        Map<String,Object> response = new HashMap<>();
        try {
            video = youtubeService.getVideo(query);
        } catch(MediaMeetException e) {
            response.put("mensaje","No se encontraron videos");
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Media>(video,HttpStatus.OK);

    }
}
