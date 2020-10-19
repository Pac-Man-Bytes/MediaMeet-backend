package edu.eci.arsw.mediameet.service.externalservices.youtube;

import edu.eci.arsw.mediameet.model.Video;
import edu.eci.arsw.mediameet.service.MediaMeetException;

import java.io.IOException;

public interface YoutubeService{
    Video getVideo(String searchQuery) throws MediaMeetException, IOException;
}
