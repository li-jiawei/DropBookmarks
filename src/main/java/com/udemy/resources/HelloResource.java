package com.udemy.resources;

import com.udemy.core.User;
import io.dropwizard.auth.Auth;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Jiawei on 7/13/17.
 */

@Path("/hello")
public class HelloResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getGreeting() {
        return "Hello world";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/secured")
    public String getSecuredGreeting(@Auth User user) {
        return "Hello secured world";
    }
}
