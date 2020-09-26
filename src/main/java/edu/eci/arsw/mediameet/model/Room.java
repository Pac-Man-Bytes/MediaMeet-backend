package edu.eci.arsw.mediameet.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Document(collection = "rooms")
public class Room implements Serializable {
    private static final long serialVersionUID = -7788619177798333712L;

    @Id
    @NotNull
    private int id;

    @NotNull
    private String name;

    private List<Media> playlist;
    private List<Message> chat;
    private List<Role> roles;
    private List<Permission> permissions;

    public Room(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Media> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<Media> playlist) {
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
}
