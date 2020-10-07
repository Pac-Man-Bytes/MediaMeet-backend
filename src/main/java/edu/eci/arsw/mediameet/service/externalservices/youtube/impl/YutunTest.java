package edu.eci.arsw.mediameet.service.externalservices.youtube.impl;


import edu.eci.arsw.mediameet.service.MediaMeetException;

public class YutunTest {
    public static void main(String[] args) throws MediaMeetException {
       YoutubeServiceImpl yt = new YoutubeServiceImpl();
       System.out.println(yt.getVideo("https://www.youtube.com/watch?v=c4gIRJhcPCY"));
    }
}
