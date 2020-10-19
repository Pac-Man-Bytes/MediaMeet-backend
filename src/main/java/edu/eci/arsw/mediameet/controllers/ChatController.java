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
        System.out.println(roomid + "CHAT");
        System.out.println(message.getText());
        System.out.println(message.getType());
        if (message.getType().equals("NEW_USER")) {
            message.setColor(colors[new Random().nextInt(colors.length)]);
            message.setText("is connected.");
        } else {
            System.out.println(message.getText() + "MENSAJEEEEEEE");
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
        System.out.println(roomid + "writing");
        System.out.println("writinnnnnng");
        return username + (" writing...");
    }

    @MessageMapping("/chat/{roomid}/history")
    @SendTo("/room/chat/{roomid}/history/")
    public List<Message> history(@DestinationVariable String roomid, String clienteId) {
        System.out.println(roomid + "history");
        System.out.println("history");
        List<Message> messageList = null;
        try {
            messageList = roomServices.getMessagesFromRoom(roomid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(messageList.size());
        return messageList;
    }
}
