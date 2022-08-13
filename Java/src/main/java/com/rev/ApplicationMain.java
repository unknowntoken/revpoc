package com.rev;

import com.rev.models.JsonTransformer;
import com.rev.routes.EchoRoute;
import com.rev.routes.HelloRoute;

import static spark.Spark.get;
import static spark.Spark.post;

public class ApplicationMain {


    public static void main(String[] args) {


        System.out.println("App Start");
        //Server server = new Server(new QueuedThreadPool(200, 8, 60));
        get("/hello", new HelloRoute());
        post("/echo", "application/json", new EchoRoute(), new JsonTransformer());
    }


}
