package com.example.fundmanagement.data.Retrofit;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class LoginReq {
    @SerializedName("UserId")
    private String username;
    @SerializedName("UserPass")
    private String password;
    @SerializedName("dataSign")
    private String dataSign;

    public LoginReq(String username, String password) {
        this.username = username;
        this.password = password;
        this.dataSign = "string";
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

    @NonNull
    @Override
    public String toString(){
        return "Username: " + this.username + "\nPassword: " + this.password;
    }
}
