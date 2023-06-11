package com.example.fundmanagement.data.Retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface RetrofitAPI {
    @POST("/finalauth/api/Auth/token/")
    Call<LoginResp> login(@Body LoginReq loginReq);

    @GET("/finalproduct/api/Product/Get")
    Call<ProductResp[]> getProducts(@Header("Authorization") String token);
}
