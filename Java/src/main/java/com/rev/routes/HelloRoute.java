package com.rev.routes;

import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.get;

public class HelloRoute implements Route {

    @Override
    public Object handle(Request request, Response response) throws Exception {

        return "{value:'hello'}";
    }
}
