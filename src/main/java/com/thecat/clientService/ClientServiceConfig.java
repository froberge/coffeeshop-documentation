package com.thecat.clientService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.thecat.clientService.endPoint.ClientEndPoint;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("api")
public class ClientServiceConfig extends Application {
    private Set<Object> singletons = new HashSet<>();

    public ClientServiceConfig() {
        singletons.add(new ClientEndPoint());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
