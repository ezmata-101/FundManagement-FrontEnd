package com.example.fundmanagement.data.Retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitPostData {
    @POST("/auth/login/")
    Call<LoginResp> createPost(@Body LoginReq loginReq);
}
