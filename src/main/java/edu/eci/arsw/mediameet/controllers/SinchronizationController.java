package edu.eci.arsw.mediameet.controllers;

import edu.eci.arsw.mediameet.model.Media;
import edu.eci.arsw.mediameet.model.Video;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


@Controller
public class SinchronizationController {
    @MessageMapping("/state/{roomId}")
    @SendTo("/room/state/{roomId}")
    public String recibirMensaje(@DestinationVariable String roomId, String message){
        return message;
    }
    @MessageMapping("/videoStatus/{roomId}")
    @SendTo("/room/videoStatus/{roomId}")
    public Media recibirMensaje(@DestinationVariable String roomId, Video currentTrack){
        System.out.println("Conectado "+roomId);
        System.out.println(currentTrack.getTime());
        return currentTrack;
    }

}
