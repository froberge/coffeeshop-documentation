package com.thecat.databaseService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.thecat.databaseService.endPoint.DatabaseEndPoint;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("api")
public class DatabaseServiceConfig  extends Application {
    private Set<Object> singletons = new HashSet<>();

    public DatabaseServiceConfig() {
        singletons.add(new DatabaseEndPoint());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
