package com.francalino.frankley.hellowildfly.rest;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * JAXActivator is an arbitrary name, what is important is that javax.ws.rs.core.Application is extended
 * and the @ApplicationPath annotation is used with a "rest" path.  Without this the rest routes linked to
 * from index.html would not be found.
 */
@ApplicationPath("api")
public class JAXActivator extends Application {
    // Left empty intentionally
}