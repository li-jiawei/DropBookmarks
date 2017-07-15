package com.udemy.auth;

import com.google.common.base.Optional;
import com.udemy.core.User;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

/**
 * Created by Jiawei on 7/14/17.
 */
public class HelloAuthenticator implements Authenticator<BasicCredentials, User>{
    private String password;

    public HelloAuthenticator(String password) {
        this.password = password;
    }

    @Override
    public Optional<User> authenticate(BasicCredentials basicCredentials) throws AuthenticationException {
        // basiCredenticals contains password, then query database
        // we hard code here
        // if found it, return the user wrapped by Optional
        if (password.equals(basicCredentials.getPassword())) {
            return Optional.of(new User());
        } else {
            return Optional.absent();
        }
    }
}
