package com.wynk.follow.resource;

import com.wynk.follow.sro.FollowRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/wynk/")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
@Produces({ MediaType.APPLICATION_JSON })
public interface FollowFeatureResource {

    @POST
    @Path("/follow")
    public Response follow(FollowRequest followRequest) throws Exception;
}
