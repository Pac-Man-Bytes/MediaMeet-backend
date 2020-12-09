package edu.eci.arsw.mediameet.persistence.cache;

import edu.eci.arsw.mediameet.model.Media;
import edu.eci.arsw.mediameet.model.Video;

import java.util.List;

public interface IBackendCache {

    boolean exists(String video);

    Video get(String video);

    List<Video> getAll();

    public void put(Video video,String query);
}
