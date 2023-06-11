package com.example.fundmanagement.data.Retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitPostData {
    @POST("/finalauth/api/Auth/token/")
    Call<LoginResp> createPost(@Body LoginReq loginReq);
}
