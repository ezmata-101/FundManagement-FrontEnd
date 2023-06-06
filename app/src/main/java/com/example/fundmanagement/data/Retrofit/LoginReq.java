package com.example.fundmanagement.data.Retrofit;

import com.google.gson.annotations.SerializedName;

public class LoginReq {
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;

    public LoginReq(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginReq getUser(){
        return this;
    }
    public void setUserData(String username, String password){
        this.username = username;
        this.password = password;
    }
    public void setUserData(LoginReq userData){
        this.username = userData.username;
        this.password = userData.password;
    }
}
