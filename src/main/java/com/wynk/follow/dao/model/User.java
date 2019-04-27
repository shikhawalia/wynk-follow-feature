package com.wynk.follow.dao.model;

import java.util.List;

public class User {
    private String id;
    private String name;
    private List<String> followedArtists;

    public User(String id, String name, List<String> followedArtists) {
        this.id = id;
        this.name = name;
        this.followedArtists = followedArtists;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getFollowedArtists() {
        return followedArtists;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFollowedArtists(List<String> followedArtists) {
        this.followedArtists = followedArtists;
    }
}
