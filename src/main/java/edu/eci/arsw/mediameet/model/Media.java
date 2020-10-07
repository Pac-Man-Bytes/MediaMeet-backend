package edu.eci.arsw.mediameet.model;

import java.io.Serializable;

public abstract class Media implements Serializable {
    private static final long serialVersionUID = -7788619177798333712L;

    private String id;
    private String title;
    private String image;
    private long time;

    public Media(String id, String title, String image, long time) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Media{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", time=" + time +
                '}';
    }
}
