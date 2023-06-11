package com.example.fundmanagement.data.Retrofit;

import com.google.gson.annotations.SerializedName;

public class LoginResp {
    @SerializedName("status")
    public String status;
    @SerializedName("message")
    public String message;


    @SerializedName("name") public String name;
    @SerializedName("authType") public String authType;
    @SerializedName("token") public String token;

    @Override
    public String toString(){
        return "Status: " + this.status + "\nMessage: " + this.message + "\nName: " + this.name + "\nAuthType: " + this.authType + "\nToken: " + this.token;
    }
}
