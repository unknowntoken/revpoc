package com.rev.services;

import com.google.gson.Gson;
import com.rev.models.echo.EchoRequestModel;
import com.rev.models.echo.EchoResponseModel;

public class EchoService {

    public EchoService() {
    }

    public EchoResponseModel getEchoResponseModel(String jsonString) throws Exception {
        EchoRequestModel echoRequestModel = new Gson().fromJson(jsonString, EchoRequestModel.class);
        if (echoRequestModel == null || echoRequestModel.getMyString().isEmpty()) {
            throw new Exception("Unable to process json object");
        }

        EchoResponseModel echoResponseModel = new EchoResponseModel(echoRequestModel.getMyString());
        return echoResponseModel;
    }


}
