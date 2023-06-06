package com.example.fundmanagement.data;

import android.util.Log;

import com.example.fundmanagement.data.Retrofit.LoginReq;
import com.example.fundmanagement.data.Retrofit.LoginResp;
import com.example.fundmanagement.data.Retrofit.RetrofitClient;
import com.example.fundmanagement.data.Retrofit.RetrofitPostData;
import com.example.fundmanagement.data.model.LoggedInUser;

import org.json.JSONObject;

import java.io.IOException;
import java.io.Reader;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("username", username);
            jsonObject.put("password", password);
            String json = jsonObject.toString();

            Retrofit rf = RetrofitClient.getRetrofitInstance();
            RetrofitPostData rpd = rf.create(RetrofitPostData.class);

            LoginReq loginReq = new LoginReq(username, password);
            Call<LoginResp> call = rpd.createPost(loginReq);
            Log.d("LoginReq", loginReq.toString());
            call.enqueue(new Callback<LoginResp>() {
                @Override
                public void onResponse(Call<LoginResp> call, Response<LoginResp> response) {
                    if(!response.isSuccessful()){
                        System.out.println("Code: " + response.code());
                        return;
                    }
                    LoginResp loginResp = response.body();
                    Log.d("LoginRespSuccess", loginResp.getLogres());
                    System.out.println(loginResp.getLogres());
                }

                @Override
                public void onFailure(Call<LoginResp> call, Throwable t) {
                    System.out.println(t.getMessage());
                    Log.d("LoginRespFail", t.getMessage());
                }
            });


            LoggedInUser fakeUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            "Jane Doe");
            return new Result.Success<>(fakeUser);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}