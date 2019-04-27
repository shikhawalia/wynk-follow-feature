package com.wynk.follow.sro;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FollowRequest {

    @JsonProperty("user")
    private String userId;

    @JsonProperty("artist")
    private List<String> artistIds;

    @JsonCreator
    public FollowRequest(@JsonProperty("user") String userId, @JsonProperty("artist") List<String> artistIds) {
        this.userId = userId;
        this.artistIds = artistIds;
    }

    public String getUserId() {
        return userId;
    }

    public List<String> getArtistIds() {
        return artistIds;
    }
}
