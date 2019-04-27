package com.wynk.follow.service.impl;

import com.wynk.follow.dao.ArtistDao;
import com.wynk.follow.dao.SongDao;
import com.wynk.follow.dao.UserDao;
import com.wynk.follow.dao.model.Artist;
import com.wynk.follow.dao.model.Song;
import com.wynk.follow.dao.model.User;
import com.wynk.follow.exception.EntityNotFoundException;
import com.wynk.follow.exception.InvalidRequestException;
import com.wynk.follow.service.FollowArtistService;
import com.wynk.follow.sro.FollowRequest;
import com.wynk.follow.validator.RequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class FollowArtistServiceImpl implements FollowArtistService {

    @Autowired
    private RequestValidator requestValidator;

    @Autowired
    private ArtistDao artistDao;

    @Autowired
    private SongDao songDao;

    @Autowired
    private UserDao userDao;

    @Override
    public void followArtist(FollowRequest followRequest) throws Exception {
        requestValidator.validateFollowRequest(followRequest);

        try {
            Set<String> playListBeforeFollow = getPlayList(followRequest.getUserId());

            for (String artistId : followRequest.getArtistIds()) {
                Artist artist = artistDao.getArtistById(artistId);
                artistDao.changeNoOfFollowers(artistId,1);
                for (String songId : artist.getSongsPublished()) {
                    if (!playListBeforeFollow.contains(songId)) {
                        songDao.changePopularity(songId,1);
                    }
                }
            }

            userDao.addArtist(followRequest.getUserId(), followRequest.getArtistIds());

        } catch (EntityNotFoundException e) {
            throw new InvalidRequestException(e);
        }


    }

    Set<String> getPlayList(String userId) throws Exception{
        Set<String> songs = new HashSet<String>();
        User user = userDao.getUserById(userId);
        for(String artistId: user.getFollowedArtists()) {
            Artist artist = artistDao.getArtistById(artistId);
            songs.addAll(artist.getSongsPublished());
        }
        return songs;
    }
}
