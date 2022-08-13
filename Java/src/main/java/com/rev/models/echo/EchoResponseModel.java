package com.rev.models.echo;

import com.google.gson.annotations.JsonAdapter;
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
}
