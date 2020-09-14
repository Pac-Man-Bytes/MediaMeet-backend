package edu.eci.arsw.mediameet.service.externalservices.youtube;

import edu.eci.arsw.mediameet.model.Video;
import edu.eci.arsw.mediameet.service.externalservices.youtube.impl.MediaMeetException;

public interface YoutubeService{
    Video getVideo(String searchQuery) throws MediaMeetException;
}
