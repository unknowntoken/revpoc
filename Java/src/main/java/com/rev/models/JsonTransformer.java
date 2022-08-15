package com.rev.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.ResponseTransformer;

public class JsonTransformer implements ResponseTransformer {

    private static final Logger logger = LoggerFactory.getLogger(JsonTransformer.class);
    private final Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().serializeNulls().create();

    @Override
    public String render(Object model) throws Exception {
        String json = gson.toJson(model);
        logger.debug("JSON TRANSFORMER CALLED. Output:" + json);
        return json;
    }
}
