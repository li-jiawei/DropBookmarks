package com.udemy.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataParam;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by Jiawei on 7/23/17.
 */

@Path("/contact")
@Produces(MediaType.APPLICATION_JSON)
public class ContactResource {
    @GET
    @Path("/{id}")
    public Response getContact(@PathParam("id") int id) {
        return Response
//                .ok("{\"contact_id\": " + id + ", \"name\": \"Dummy Name\", \"phone\": \"+0123455689\"}")
                .ok()
                .build();
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response createContact(@FormDataParam("name") String name, @FormDataParam("phone") String phone) {
        // store the new contact
        URI uri = null;
        try {
             uri = new URI("http://localhost:8085/contact/2");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return Response
                .created(uri)
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteContact(@PathParam("id") int id) {
        // delete the contact with the provided id
        return Response
                .noContent()
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateContact(
            @PathParam("id") int id,
            @FormParam("name") String name,
            @FormParam("phone") String phone) {
        // update the contact with the provided ID
        return Response
                .ok("{\"contact_id\": " + id + ", \"name\": \"Dummy Name\", \"phone\": \"+0123455689\"}")
                .build();
    }
}