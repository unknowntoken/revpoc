package com.rev.models.echo;

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


}
