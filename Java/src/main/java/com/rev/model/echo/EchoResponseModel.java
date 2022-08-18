package com.rev.model.echo;

import com.google.gson.annotations.SerializedName;

public class EchoResponseModel {

    @SerializedName("your-string")
    private String yourString;

    public EchoResponseModel(String yourString) {
        this.yourString = yourString;
    }

    public String getYourString() {
        return yourString;
    }

    public void setYourString(String yourString) {
        this.yourString = yourString;
    }

    @Override
    public String toString() {
        return "EchoResponseModel{" +
                "yourString='" + yourString + '\'' +
                '}';
    }
}
