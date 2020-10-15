package edu.eci.arsw.mediameet.model;

import java.io.Serializable;
import java.util.List;

public class Profile implements Serializable {
    private static final long serialVersionUID = -7788619177798333712L;

    private String id;
    private String nickname;
    private List<Profile> friends;
    private List<Room> rooms;

    public Profile(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<Profile> getFriends() {
        return friends;
    }

    public void setFriends(List<Profile> friends) {
        this.friends = friends;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
