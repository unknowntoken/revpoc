package com.rev.routes;

import com.google.gson.Gson;
import com.rev.models.ApiResponse;
import com.rev.models.echo.EchoRequestModel;
import com.rev.models.echo.EchoResponseModel;
import spark.Request;
import spark.Response;
import spark.Route;

import static com.rev.models.ApiResponse.ResponseStatus;

public class EchoRoute implements Route {
    @Override
    public Object handle(Request request, Response response) {
        System.out.println("Handling Echo Route");

        if (!request.contentType().toLowerCase().contains("application/json")) {
            System.out.println();
            response.status(415);
            return new ApiResponse(ResponseStatus.Failure, "Invalid content type",null);
        }


        EchoRequestModel echoRequestModel = new Gson().fromJson(request.body(), EchoRequestModel.class);
        EchoResponseModel echoResponseModel = new EchoResponseModel(echoRequestModel.getMyString());

        response.status(200);
        response.type("application/json");
        return new ApiResponse(ResponseStatus.Success, "ECHO_SUCCESS", echoResponseModel);
    }
}
