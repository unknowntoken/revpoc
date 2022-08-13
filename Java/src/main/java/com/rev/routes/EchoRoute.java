package com.rev.routes;

import com.rev.models.ApiResponse;
import com.rev.models.echo.EchoResponseModel;
import com.rev.services.EchoService;
import spark.Request;
import spark.Response;
import spark.Route;

import static com.rev.models.ApiResponse.ResponseStatus;

public class EchoRoute implements Route {

    private final EchoService echoService = new EchoService();

    @Override
    public Object handle(Request request, Response response) {
        System.out.println("Handling Echo Route");

        if (!request.contentType().toLowerCase().contains("application/json")) {
            System.out.println();
            response.status(415);
            response.type("application/json");
            return new ApiResponse(ResponseStatus.Failure, "Invalid content type", null);
        }


        try {
            EchoResponseModel echoResponseModel = echoService.getEchoResponseModel(request.body());
            System.out.println("Incoming EcoRequestModel object:" + echoResponseModel.toString());

            response.status(200);
            response.type("application/json");
            return new ApiResponse(ResponseStatus.Success, "ECHO_SUCCESS", echoResponseModel);

        } catch (Exception exception) {
            exception.printStackTrace();
            response.status(400);
            response.type("application/json");
            return new ApiResponse(ResponseStatus.Failure, "Bad Request", null);
        }
    }
}
