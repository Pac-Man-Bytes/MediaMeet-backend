package edu.eci.arsw.mediameet.controllers;

import edu.eci.arsw.mediameet.model.Media;
import edu.eci.arsw.mediameet.model.Room;
import edu.eci.arsw.mediameet.model.Video;
import edu.eci.arsw.mediameet.service.MediaMeetException;
import edu.eci.arsw.mediameet.service.roomservices.RoomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class SinchronizationController {
    @Autowired
    RoomServices roomServices;
    @Autowired
    private SimpMessagingTemplate webSocket;

    @MessageMapping("/state/{roomId}")
    @SendTo("/room/state/{roomId}")
    public String recibirMensaje(@DestinationVariable String roomId, String message) {
        return message;
    }

    @MessageMapping("/videoStatus/{roomId}")
    @SendTo("/room/videoStatus/{roomId}")
    public Media recibirMensaje(@DestinationVariable String roomId, Video currentTrack) {
        return currentTrack;
    }

    @MessageMapping("/next/{roomId}")
    @SendTo("/room/next/{roomId}")
    public Media recibirMensajeDevolver(@DestinationVariable String roomId, Video currentTrack) {
        return currentTrack;
    }

    //Guarda
    @MessageMapping("/queue/{roomId}")
    public void receiveMedia(@DestinationVariable String roomId, Video currentTrack) throws MediaMeetException {
        Room room = roomServices.loadById(roomId);
        room.addTrack(currentTrack);
        roomServices.save(room);
        webSocket.convertAndSend("/room/queue/" + roomId, room.getPlaylist());
    }

    @MessageMapping("/queue/{roomId}/playlist")
    public void getMedia(@DestinationVariable String roomId) throws MediaMeetException {
        Room room = roomServices.loadById(roomId);
        webSocket.convertAndSend("/room/queue/" + roomId + "/playlist", room.getPlaylist());
    }

    @MessageMapping("/fetch/{roomId}")
    public void fetchMedia(@DestinationVariable String roomId) throws MediaMeetException {
        System.out.println(":D");
        Room room = roomServices.loadById(roomId);
        webSocket.convertAndSend("/room/fetch/" + roomId, room.getId());
    }

    @MessageMapping("/currentTime/{roomId}")
    @SendTo("/room/currentTime/{roomId}")
    public String time(@DestinationVariable String roomId, String time) {
        System.out.println(time);
        return time;
    }

    //Obtener cola actual
    //actualiza cola actual
    @MessageMapping("/queue/{roomId}/playlists")
    public void getMedia(@DestinationVariable String roomId, List<Video> playlist) throws MediaMeetException {
        Room room = roomServices.loadById(roomId);
        room.setPlaylist(playlist);
        roomServices.save(room);
        webSocket.convertAndSend("/room/queue/" + roomId + "/playlists", room.getPlaylist());
    }

}
