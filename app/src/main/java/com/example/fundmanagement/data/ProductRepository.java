package com.example.fundmanagement.data;

import android.util.Log;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;

import com.example.fundmanagement.data.Retrofit.ProductResp;
import com.example.fundmanagement.data.Retrofit.RetrofitAPI;
import com.example.fundmanagement.data.Retrofit.RetrofitClient;
import com.example.fundmanagement.data.model.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductRepository {
    private static final String TAG = ProductRepository.class.getSimpleName();
    private final MutableLiveData<List<Product>> products = new MutableLiveData<>();
    private static ProductRepository instance;

    public static ProductRepository get(){
        if(instance == null){
            instance = new ProductRepository();
        }
        return instance;
    }

    public ProductRepository() {
        RetrofitAPI rf = RetrofitClient.getInstance().create(RetrofitAPI.class);
        Log.d(TAG, "ProductRepository: " + StoreAndRetrieveToken.getToken());
        Call<ProductResp[]> call = rf.getProducts(StoreAndRetrieveToken.getToken());

        call.enqueue(new Callback<ProductResp[]>() {
            @Override
            public void onResponse(Call<ProductResp[]> call, Response<ProductResp[]> response) {
                if(response.isSuccessful()){
                    ProductResp[] productResps = response.body();
                    List<Product> productList = new ArrayList<>();
                    for(ProductResp productResp : productResps){
                        productList.add(new Product(productResp.productCode, productResp.productTitle, productResp.status));
                        Log.d(TAG, "onResponse: " + productResp.productCode + " " + productResp.productTitle + " " + productResp.status);
                    }
                    products.setValue(productList);
                }else {
                    Log.d(TAG, "onResponse: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<ProductResp[]> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    public MutableLiveData<List<Product>> getProducts() {
        return products;
    }




}
