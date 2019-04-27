package com.wynk.follow.exception.provider;

import com.wynk.follow.exception.InvalidRequestException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidRequestExceptionHandler implements ExceptionMapper<InvalidRequestException>{
    @Override
    public Response toResponse(InvalidRequestException e) {
        return Response.status(400).entity(new com.wynk.follow.sro.Response(e.getStatus(), e.getMessage())).build();
    }
}
