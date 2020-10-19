package edu.eci.arsw.mediameet.controllers;

import edu.eci.arsw.mediameet.model.Message;
import edu.eci.arsw.mediameet.service.roomservices.RoomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class ChatController {

    private String[] colors = {"red", "green", "blue", "magenta", "purple", "orange"};
    @Autowired
    private RoomServices roomServices;

    @Autowired
    private SimpMessagingTemplate webSocket;

    @MessageMapping("/chat/{roomid}")
    @SendTo("/room/chat/{roomid}")
    public Message recieveMessage(@DestinationVariable String roomid, Message message) {
        roomServices.saveMessage(message, roomid);
        return message;
    }

    @MessageMapping("/{roomid}/writing")
    @SendTo("/room/chat/writing/{roomid}")
    public String isWriting(@DestinationVariable String roomid, String username) {
        return username + (" está escribiendo...");
    }

    @MessageMapping("/{roomid}/history")
    public void history(@DestinationVariable String roomid, String clienteId) {
        webSocket.convertAndSend("/room/chat/history/" + clienteId, roomServices.getMessagesFromRoom(roomid));
    }
}
