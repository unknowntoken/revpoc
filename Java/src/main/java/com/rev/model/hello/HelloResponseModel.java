package com.rev.model.hello;

public class HelloResponseModel {

    private String value;

    public HelloResponseModel(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "HelloResponseModel{" +
                "value='" + value + '\'' +
                '}';
    }
}
