package com.example.fundmanagement.data;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.fundmanagement.data.Retrofit.LoginReq;
import com.example.fundmanagement.data.Retrofit.LoginResp;
import com.example.fundmanagement.data.Retrofit.RetrofitClient;
import com.example.fundmanagement.data.Retrofit.RetrofitAPI;
import com.example.fundmanagement.data.model.LoggedInUser;
import com.example.fundmanagement.ui.login.LoggedInUserView;
import com.example.fundmanagement.ui.login.LoginResult;

import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {
    private static final String TAG = LoginDataSource.class.getSimpleName();
    public Result<LoggedInUser> login(String username, String password, MutableLiveData<LoginResult> loginResult) {
        try {
            // TODO: handle loggedInUser authentication
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("username", username);
            jsonObject.put("password", password);
            String json = jsonObject.toString();

            Retrofit rf = RetrofitClient.getInstance();
            RetrofitAPI rpd = rf.create(RetrofitAPI.class);

            LoginReq loginReq = new LoginReq(username, password);
            Call<LoginResp> call = rpd.login(loginReq);


            call.enqueue(new Callback<LoginResp>() {
                @Override
                public void onResponse(Call<LoginResp> call, Response<LoginResp> response) {
                    if(response.isSuccessful()){
                        Log.d(TAG, "onResponse: " + response.body().toString());
                        LoginResp loginResp = response.body();
                        if(loginResp.authType.equalsIgnoreCase("bearer")){
                            loginResult.setValue(new LoginResult(new LoggedInUserView(loginResp.name)));
                            StoreAndRetrieveToken.storeToken(loginResp.token);
                        }else {
                            loginResult.setValue(new LoginResult(Integer.parseInt(loginResp.status)));
                        }
                    }
                }

                @Override
                public void onFailure(Call<LoginResp> call, Throwable t) {
                    loginResult.setValue(new LoginResult(500));
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