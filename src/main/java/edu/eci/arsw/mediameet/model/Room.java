package edu.eci.arsw.mediameet.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Document(collection = "rooms")
public class Room implements Serializable {
    private static final long serialVersionUID = -7788619177798333712L;

    @Id
    private String id;

    @NotNull
    private String name;


    private List<Profile> members = new ArrayList<>();

    private List<Video> playlist = new LinkedList<>();
    private List<Message> chat = new LinkedList<Message>();
    private List<Role> roles;
    private List<Permission> permissions;

    public Room() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Video> getPlaylist() {
        return playlist;
    }

    public synchronized void setPlaylist(List<Video> playlist) {
        this.playlist = playlist;
    }

    public List<Message> getChat() {
        return chat;
    }

    public void setChat(List<Message> chat) {
        this.chat = chat;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<Profile> getMembers() {
        return members;
    }

    public void setMembers(List<Profile> members) {
        this.members = members;
    }

    public void addTrack(Video track) {
        synchronized (playlist) {
            playlist.add(track);
        }
    }

    public void addMessage(Message message) {
        synchronized (chat) {
            chat.add(message);
        }
    }
}
