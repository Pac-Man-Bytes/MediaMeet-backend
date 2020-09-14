package edu.eci.arsw.mediameet.service.externalservices.youtube.impl;

public class MediaMeetException extends Exception{
    public static final String NOT_VIDEOS_FOUND = "NOT_VIDEOS_FOUND";
    public MediaMeetException(String message){
        super(message);
    }
}
