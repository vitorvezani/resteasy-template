package com.application.web.rest.config;

import com.application.web.rest.ExampleRS;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class RestApplication extends Application {

    private final Set<Class<?>> classes = new HashSet<Class<?>>();

    @Override
    public Set<Class<?>> getClasses() {

        classes.add(ExampleRS.class);
        return classes;
    }

}
