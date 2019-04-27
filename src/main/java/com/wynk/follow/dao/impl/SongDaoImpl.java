package com.wynk.follow.dao.impl;

import com.wynk.follow.dao.SongDao;
import com.wynk.follow.dao.model.Song;
import com.wynk.follow.exception.EntityNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SongDaoImpl implements SongDao{

    private Map<String, Song> songs;

    @PostConstruct
    public void initializeSongs() {
        songs = new HashMap<String, Song>();
        songs.put("s1", new Song("s1", "Song 1", 3));
        songs.put("s2", new Song("s2", "Song 2", 1));

    }
    @Override
    public List<Song> getAllSongs() {
        return new ArrayList<Song>(songs.values());
    }

    @Override
    public Song getSongById(String id) throws EntityNotFoundException {
        if(songs.get(id) == null)
            throw new EntityNotFoundException("Song ID : " + id + " not found");
        return songs.get(id);
    }

    @Override
    public void changePopularity(String songId, long change) throws EntityNotFoundException {
        Song song = songs.get(songId);
        if(song == null)
            throw new EntityNotFoundException("Song ID : " + songId + " not found");
        song.setPopularity(song.getPopularity()+change);
    }


}
