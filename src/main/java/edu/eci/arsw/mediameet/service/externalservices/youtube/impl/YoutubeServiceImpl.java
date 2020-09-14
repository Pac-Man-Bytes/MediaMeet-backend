/*
 * Copyright (c) 2012 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package edu.eci.arsw.mediameet.service.externalservices.youtube.impl;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.*;
import edu.eci.arsw.mediameet.model.Video;
import edu.eci.arsw.mediameet.service.externalservices.youtube.YoutubeService;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;


/**
 * Prints a list of videos based on a search term.
 *
 * @author Jeremy Walker
 */
@Service
public class YoutubeServiceImpl implements YoutubeService {
    /** Global instance properties filename. */
    private String PROPERTIES_FILENAME = "youtube.properties";
    /** Global instance of the HTTP transport. */
    private final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    /** Global instance of the JSON factory. */
    private final JsonFactory JSON_FACTORY = new JacksonFactory();
    private YouTube youtube;
    @Override
    public Video getVideo(String searchQuery) throws MediaMeetException {
        edu.eci.arsw.mediameet.model.Video video = new edu.eci.arsw.mediameet.model.Video();
        List<SearchResult> searchResults = searchVideo(searchQuery,1);
        if(searchResults.isEmpty()){
            throw new MediaMeetException(MediaMeetException.NOT_VIDEOS_FOUND);
        }
        //if (rId.getKind().equals("youtube#video"))
        SearchResult singleVideo = searchResults.get(0);
        Thumbnail thumbnail = (Thumbnail) singleVideo.getSnippet().getThumbnails().get("default");
        video.setId(singleVideo.getId().getVideoId());
        video.setTitle(singleVideo.getSnippet().getTitle());
        video.setImage(thumbnail.getUrl());
        return video;
    }


    private List<SearchResult> searchVideo(String query,long numberOfVideos) {
        Properties properties = new Properties();
        try {
            InputStream in = YoutubeServiceImpl.class.getResourceAsStream("/" + PROPERTIES_FILENAME);
            properties.load(in);
        } catch (IOException e) {
            System.err.println("There was an error reading " + PROPERTIES_FILENAME + ": " + e.getCause()
                    + " : " + e.getMessage());
            System.exit(1);
        }
        try {
            youtube = new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, new HttpRequestInitializer() {
                public void initialize(HttpRequest request) throws IOException {}
            }).setApplicationName("youtube-cmdline-search-sample").build();
            YouTube.Search.List search = youtube.search().list("id,snippet");
            String apiKey = properties.getProperty("youtube.apikey");
            search.setKey(apiKey);
            search.setQ(query);
            search.setType("video");
            search.setFields("items(id/kind,id/videoId,snippet/title,snippet/thumbnails/default/url)");
            search.setMaxResults(numberOfVideos);
            SearchListResponse searchResponse = search.execute();
            List<SearchResult> searchResultList = searchResponse.getItems();
            if (searchResultList != null) {
                return searchResultList;
            }else{
                throw new MediaMeetException(MediaMeetException.NOT_VIDEOS_FOUND);
            }
        } catch (GoogleJsonResponseException e) {
            System.err.println("There was a service error: " + e.getDetails().getCode() + " : "
                    + e.getDetails().getMessage());
        } catch (IOException e) {
            System.err.println("There was an IO error: " + e.getCause() + " : " + e.getMessage());
        } catch (Throwable t) {
            t.printStackTrace();
        }return null;
    }


}