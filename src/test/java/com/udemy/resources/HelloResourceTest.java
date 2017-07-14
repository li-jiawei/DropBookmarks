package com.udemy.resources;

import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;

import javax.ws.rs.core.MediaType;

import static org.junit.Assert.*;

/**
 * Created by Jiawei on 7/14/17.
 */
public class HelloResourceTest {
    @Test
    @Ignore
    public void getGreeting() throws Exception {
        fail("Not implemented");
    }

    @ClassRule
    public static final ResourceTestRule RULE = ResourceTestRule
            .builder()
            .addResource(new HelloResource())
            .build();

    @Test
    public void testGetGreeting() {
        String expected = "Hello world";
        String actual = RULE.getJerseyTest()
                .target("/hello")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        assertEquals(expected, actual);
    }
}