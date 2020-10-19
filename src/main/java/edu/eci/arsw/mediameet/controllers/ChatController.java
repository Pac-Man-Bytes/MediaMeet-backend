package edu.eci.arsw.mediameet.controllers;

import edu.eci.arsw.mediameet.model.Message;
import edu.eci.arsw.mediameet.service.roomservices.RoomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Random;

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
        if (message.getType().equals("NEW_USER")) {
            message.setColor(colors[new Random().nextInt(colors.length)]);
            message.setText("se ha conectado.");
        } else {
            try {
                roomServices.saveMessage(message, roomid);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return message;
    }

    @MessageMapping("/chat/{roomid}/writing")
    @SendTo("/room/chat/{roomid}/writing")
    public String isWriting(@DestinationVariable String roomid, String username) {
        return username + (" escribiendo...");
    }

    @MessageMapping("/chat/{roomid}/history")
    @SendTo("/room/chat/{roomid}/history")
    public List<Message> history(@DestinationVariable String roomid, String clienteId) {
        List<Message> messageList = null;
        try {
            messageList = roomServices.getMessagesFromRoom(roomid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return messageList;
    }
}
