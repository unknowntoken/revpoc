package com.rev.model.echo;

import com.google.gson.annotations.SerializedName;

public class EchoRequestModel {

    @SerializedName("my-string")
    private String myString;

    public EchoRequestModel(String myString) {
        this.myString = myString;
    }

    public void setMyString(String myString) {
        this.myString = myString;
    }

    public String getMyString() {
        return myString;
    }

    @Override
    public String toString() {
        return "EchoRequestModel{" +
                "myString='" + myString + '\'' +
                '}';
    }
}
