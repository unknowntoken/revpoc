package com.rev.services;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.rev.models.echo.EchoRequestModel;
import com.rev.models.echo.EchoResponseModel;

public class EchoService {

    public EchoService() {
    }

    public EchoRequestModel getEchoRequestModelFromReqBody(String requestBody) throws Exception, JsonSyntaxException {
        EchoRequestModel echoRequestModel = new Gson().fromJson(requestBody, EchoRequestModel.class);

        if (echoRequestModel.getMyString().isEmpty()) {
            throw new Exception("Field myString cannot be null or empty");
        }

        return echoRequestModel;
    }


    public EchoResponseModel processEchoRequest(EchoRequestModel echoRequestModel) {
        return new EchoResponseModel(echoRequestModel.getMyString());
    }
}
