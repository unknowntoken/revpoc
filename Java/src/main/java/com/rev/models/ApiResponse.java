package com.rev.models;

import spark.Response;

public class ApiResponse {
    private ResponseStatus status;
    private String message;
    private Object data;

    public ApiResponse( ResponseStatus status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }


    public ResponseStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public enum ResponseStatus {
        Success,
        Failure
    }
}
