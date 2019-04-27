package com.wynk.follow.dao.model;

public class Song {

    private String id;
    private String name;
    private long popularity;

    public Song(String id, String name, long popularity) {
        this.id = id;
        this.name = name;
        this.popularity = popularity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPopularity() {
        return popularity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopularity(long popularity) {
        this.popularity = popularity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song song = (Song) o;

        return id.equals(song.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
