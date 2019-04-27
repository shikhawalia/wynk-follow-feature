package com.wynk.follow.dao;

import com.wynk.follow.dao.model.Song;
import com.wynk.follow.exception.EntityNotFoundException;

import java.util.List;

public interface SongDao {


    List<Song> getAllSongs();
    Song getSongById(String id) throws EntityNotFoundException;
    void changePopularity(String songId, long change) throws EntityNotFoundException;
}
