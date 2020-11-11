package edu.eci.arsw.mediameet.service;

public class MediaMeetException extends Exception{
    public static final String NOT_VIDEOS_FOUND = "NOT_VIDEOS_FOUND";
    public static final String RESOURCE_NOT_FOUND  = "RESOURCE_NOT_FOUND";
    public static final String REPEAT_ROOM = "THE USER ALREADY BELONGS TO THAT ROOM.";
    public static final String THAT_MEMBER_ALREADY_EXISTS = "ALREADY A MEMBER OF THIS ROOM";
    public MediaMeetException(String message){
        super(message);
    }
}
