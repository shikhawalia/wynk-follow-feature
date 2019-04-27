package com.wynk.follow.config;

import com.wynk.follow.exception.provider.InvalidRequestExceptionHandler;
import com.wynk.follow.resource.impl.FollowFeatureResourceImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class FollowFeatureResourceConfig extends ResourceConfig{

    public FollowFeatureResourceConfig() {
        register(FollowFeatureResourceImpl.class);
        register(InvalidRequestExceptionHandler.class);
    }
}
