package com.rev.routes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;
import spark.Route;

public class HelloRoute implements Route {

    private static final Logger logger = LoggerFactory.getLogger(HelloRoute.class);

    @Override
    public Object handle(Request request, Response response) {
        logger.info("Handling hello route");
        response.status(200);
        response.type("application/json");
        return "{\"value\":\"hello\"}";
    }
}
