package com.wynk.follow.dao.model;

import java.util.List;

public class Artist {

    private String id;
    private String name;
    private List<String> songsPublished;
    private long noOfFollowers;

    public Artist(String id, String name, List<String> songsPublished, long noOfFollowers) {
        this.id = id;
        this.name = name;
        this.songsPublished = songsPublished;
        this.noOfFollowers = noOfFollowers;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getSongsPublished() {
        return songsPublished;
    }

    public long getNoOfFollowers() {
        return noOfFollowers;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSongsPublished(List<String> songsPublished) {
        this.songsPublished = songsPublished;
    }

    public void setNoOfFollowers(long noOfFollowers) {
        this.noOfFollowers = noOfFollowers;
    }
}

