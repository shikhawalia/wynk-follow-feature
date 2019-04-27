package com.wynk.follow.dao.impl;

import com.wynk.follow.dao.ArtistDao;
import com.wynk.follow.dao.model.Artist;
import com.wynk.follow.exception.EntityNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class ArtistDaoImpl implements ArtistDao{

    private Map<String, Artist> artists;

    @PostConstruct
    public void initializeArtists() {
        artists = new HashMap<String, Artist>();
        artists.put("a1",new Artist("a1", "Artist 1", new ArrayList<String>(Arrays.asList("s1")), 3));
        artists.put("a2", new Artist("a2", "Artist 2", new ArrayList<String>(Arrays.asList("s1","s2")), 1));
    }

    @Override
    public List<Artist> getAllArtists() {
        return new ArrayList<Artist>(artists.values());
    }

    @Override
    public Artist getArtistById(String id) throws EntityNotFoundException {
        if(artists.get(id) == null)
         throw new EntityNotFoundException("Artist ID : " + id + " not found");
        return artists.get(id);
    }

    @Override
    public void changeNoOfFollowers(String artistId, long change) throws EntityNotFoundException {
        Artist artist = artists.get(artistId);
        if(artist == null)
            throw new EntityNotFoundException("Artist ID : " + artistId + " not found");
         artist.setNoOfFollowers(artist.getNoOfFollowers()+change);
    }
}
