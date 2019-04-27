package com.wynk.follow.resource.impl;

import com.wynk.follow.resource.FollowFeatureResource;
import com.wynk.follow.service.FollowArtistService;
import com.wynk.follow.sro.FollowRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;

@Service
public class FollowFeatureResourceImpl implements FollowFeatureResource {

    @Autowired
    private FollowArtistService followArtistService;

    @Override
    public Response follow(FollowRequest followRequest) throws Exception{
        followArtistService.followArtist(followRequest);
        com.wynk.follow.sro.Response responseSRO = new com.wynk.follow.sro.Response("ok", followRequest.getUserId() + " started following " + followRequest.getArtistIds());
        return Response.ok(responseSRO).build();
    }
}
