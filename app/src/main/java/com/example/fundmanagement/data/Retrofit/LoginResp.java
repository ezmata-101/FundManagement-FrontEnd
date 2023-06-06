package com.example.fundmanagement.data.Retrofit;

import com.google.gson.annotations.SerializedName;

public class LoginResp {
    @SerializedName("logres")
    private String logres;

    public LoginResp(String logres) {
        this.logres = logres;
    }

    public String getLogres() {
        return logres;
    }

    public void setLogres(String logres) {
        this.logres = logres;
    }
}
