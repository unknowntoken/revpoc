package com.rev.routes;

import spark.Request;
import spark.Response;
import spark.Route;

public class HelloRoute implements Route {

    @Override
    public Object handle(Request request, Response response) {
        response.status(200);
        response.type("application/json");
        return "{\"value\":\"hello\"}";
    }
}
