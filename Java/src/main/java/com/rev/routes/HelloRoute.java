package com.rev.routes;

import com.rev.models.ApiResponse;
import com.rev.models.hello.HelloResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;
import spark.Route;

import static com.rev.models.ApiResponse.ResponseStatus.Success;

public class HelloRoute implements Route {

    private static final Logger logger = LoggerFactory.getLogger(HelloRoute.class);

    @Override
    public Object handle(Request request, Response response) {
        logger.info("Handling hello route");
        HelloResponseModel hello = new HelloResponseModel("hello");

        response.status(200);
        response.type("application/json");
        return new ApiResponse(Success,"Hello world ok", hello);
    }
}
