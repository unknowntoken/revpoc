package com.rev.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import spark.ResponseTransformer;

public class JsonTransformer implements ResponseTransformer {

    private Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().serializeNulls().create();

    @Override
    public String render(Object model) throws Exception {
        String json = gson.toJson(model);
        System.out.println("JSON TRANSFORMER CALLED. Output:" + json);
        return json;
    }
}
