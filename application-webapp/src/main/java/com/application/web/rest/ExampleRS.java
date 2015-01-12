package com.application.web.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/example")
public class ExampleRS {

    String response = "{\"response\":\"Awesome content from server goes here\"}";

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Response get() {

        return Response.ok(response).build();
    }

}
