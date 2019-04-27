package com.wynk.follow.dao;

import com.wynk.follow.dao.model.Artist;
import com.wynk.follow.exception.EntityNotFoundException;

import java.util.List;

public interface ArtistDao {

    List<Artist> getAllArtists();
    Artist getArtistById(String id) throws EntityNotFoundException;
    void changeNoOfFollowers(String artistId, long change) throws EntityNotFoundException;
}
