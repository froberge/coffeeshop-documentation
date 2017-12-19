package com.thecat.databaseApp;

import com.thecat.databaseApp.endPoint.DatabaseEndPoint;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("api")
public class DatabaseAppConfig  extends Application {
    private Set<Object> singletons = new HashSet<>();

    public DatabaseAppConfig() {
        singletons.add(new DatabaseEndPoint());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
