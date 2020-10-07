package edu.eci.arsw.mediameet.service.externalservices.vimeo;

import edu.eci.arsw.mediameet.model.Video;
import edu.eci.arsw.mediameet.service.MediaMeetException;

public interface VimeoService{
    Video getVideo(String searchQuery) throws MediaMeetException;
}
