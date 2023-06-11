package com.example.fundmanagement.data.Retrofit;

import com.google.gson.annotations.SerializedName;

public class ProductResp {
    @SerializedName("productCode") public String productCode;
    @SerializedName("productTitle") public String productTitle;
    @SerializedName("status") public String status;
}
