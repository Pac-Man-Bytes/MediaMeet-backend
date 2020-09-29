package edu.eci.arsw.mediameet.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class SinchronizationController {
    @MessageMapping("/state")
    @SendTo("/room/state")
    public String recibirMensaje( String message){
        System.out.println("Recibido" + message);
        return message;
    }
}
