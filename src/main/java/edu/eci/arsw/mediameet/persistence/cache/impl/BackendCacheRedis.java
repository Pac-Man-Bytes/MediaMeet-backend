package edu.eci.arsw.mediameet.persistence.cache.impl;

import edu.eci.arsw.mediameet.model.Media;
import edu.eci.arsw.mediameet.model.Video;
import edu.eci.arsw.mediameet.persistence.cache.IBackendCache;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.List;

@Repository
public class BackendCacheRedis implements IBackendCache {

    public static final String MEDIA_KEY = "edu:eci:arsw:media";

    private HashOperations hashOperations;
    private ValueOperations valueOperations;

    private RedisTemplate redisTemplate;

    public BackendCacheRedis(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = this.redisTemplate.opsForHash();
        this.valueOperations = this.redisTemplate.opsForValue();
    }

    @Override
    public boolean exists(String query) {
        return get(query) != null;
    }

    @Override
    public Video get(String query) {
        return (Video) hashOperations.get("MediaMeetCache", getKey(query));
    }

    @Override
    public List<Video> getAll() {
        return hashOperations.values("MediaMeetCache");
    }

    @Override
    public void put(Video video,String query) {
        hashOperations.put("MediaMeetCache", getKey(query), video);
    }

    private String getKey(String title) {
        return String.format("%s:%s", MEDIA_KEY, title);
    }

}
