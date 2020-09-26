package edu.eci.arsw.mediameet.controllers;

import edu.eci.arsw.mediameet.model.Media;
import edu.eci.arsw.mediameet.model.Query;
import edu.eci.arsw.mediameet.service.externalservices.youtube.YoutubeService;
import edu.eci.arsw.mediameet.service.MediaMeetException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.*;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/media")
public class MediaController {
    @Autowired
    YoutubeService youtubeService;

    //    @GetMapping("/youtube")
//    public ResponseEntity<?> getVideo(@RequestBody Query query) {
//        System.out.println(query.getQuery());
//        Media video = null;
//        Map<String, Object> response = new HashMap<>();
//        try {
//            video = youtubeService.getVideo(query.getQuery());
//            System.out.println(video);
//        } catch (MediaMeetException e) {
//            response.put("mensaje", "No se encontraron videos");
//            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<Media>(video, HttpStatus.OK);
//
//    }
    @GetMapping("/youtube")
    public ResponseEntity<?> getVideo(@RequestParam String query) throws UnsupportedEncodingException {
//        System.out.println("----------------");
//        System.out.println(query);
//        System.out.println("----------------");
//        String uri = "";
        Media video = null;
        Map<String, Object> response = new HashMap<>();
        try {
            video = youtubeService.getVideo(query);
            System.out.println(video);
        } catch (MediaMeetException e) {
            response.put("mensaje", "No se encontraron videos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Media>(video, HttpStatus.OK);

    }

}
