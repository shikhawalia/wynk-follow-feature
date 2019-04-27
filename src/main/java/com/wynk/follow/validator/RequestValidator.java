package com.wynk.follow.validator;

import com.wynk.follow.exception.InvalidRequestException;
import com.wynk.follow.sro.FollowRequest;
import org.springframework.stereotype.Component;

@Component
public class RequestValidator {

    public void validateFollowRequest(FollowRequest followRequest) throws InvalidRequestException {
        if(followRequest == null || followRequest.getUserId() == null || followRequest.getUserId().isEmpty() || followRequest.getArtistIds() == null || followRequest.getArtistIds().isEmpty()) {
            throw new InvalidRequestException();
        }
    }
}
