package com.wynk.follow.sro;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    @JsonProperty("status")
    private String status;

    @JsonProperty("message")
    private String message;

    @JsonCreator
    public Response(@JsonProperty("status") String status,@JsonProperty("message") String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
