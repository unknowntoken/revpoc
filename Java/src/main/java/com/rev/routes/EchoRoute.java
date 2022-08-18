package com.rev.routes;

import com.google.gson.Gson;
import com.rev.models.ApiResponse;
import com.rev.models.echo.EchoRequestModel;
import com.rev.models.echo.EchoResponseModel;
import com.rev.services.EchoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;
import spark.Route;

import static com.rev.models.ApiResponse.ResponseStatus;

public class EchoRoute implements Route {

    private static final Logger logger = LoggerFactory.getLogger(EchoRoute.class);
    private final EchoService echoService = new EchoService();

    public EchoRoute (){}

    @Override
    public Object handle(Request request, Response response) {
        logger.info("Handling Echo Route");

        if (!request.contentType().toLowerCase().contains("application/json")) {
            logger.debug("Invalid content type");
            response.status(415);
            response.type("application/json");
            return new ApiResponse(ResponseStatus.Failure, "Invalid content type", null);
        }

        try {
            EchoRequestModel echoRequestModel = echoService.getEchoRequestModelFromReqBody(request.body());
            EchoResponseModel echoResponseModel = echoService.processEchoRequest (echoRequestModel);
            logger.debug("Incoming EcoRequestModel object:" + echoResponseModel.toString());

            response.status(200);
            response.type("application/json");
            ApiResponse echo_success = new ApiResponse(ResponseStatus.Success, "ECHO_SUCCESS", echoResponseModel);
            return echo_success;

        } catch (Exception exception) {
            logger.error("Unable to handle request");
            exception.printStackTrace();
            response.status(400);
            response.type("application/json");
            return new ApiResponse(ResponseStatus.Failure, "Bad Request", exception.getMessage());
        }
    }
}
