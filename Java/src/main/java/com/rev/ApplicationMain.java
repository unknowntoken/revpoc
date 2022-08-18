package com.rev;

import com.rev.model.JsonTransformer;
import com.rev.routes.EchoRoute;
import com.rev.routes.HelloRoute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static spark.Spark.get;
import static spark.Spark.post;

public class ApplicationMain {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationMain.class);

    public static void main(String[] args) {
        logger.info("Starting app");

        logger.debug("Debug: setting routes");
        //Server server = new Server(new QueuedThreadPool(200, 8, 60));
        get("/hello", new HelloRoute(), new JsonTransformer());
        post("/echo", "application/json", new EchoRoute(), new JsonTransformer());
    }


}
