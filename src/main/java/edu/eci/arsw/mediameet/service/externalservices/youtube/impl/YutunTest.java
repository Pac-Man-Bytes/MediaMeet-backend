package edu.eci.arsw.mediameet.service.externalservices.youtube.impl;


import edu.eci.arsw.mediameet.service.MediaMeetException;

import java.io.IOException;

public class YutunTest {
    public static void main(String[] args) throws MediaMeetException, IOException {
       YoutubeServiceImpl yt = new YoutubeServiceImpl();
       System.out.println(yt.getVideo("https://www.youtube.com/watch?v=c4gIRJhcPCY"));
    }
}
