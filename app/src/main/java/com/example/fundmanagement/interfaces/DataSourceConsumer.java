package com.example.fundmanagement.interfaces;

import com.example.fundmanagement.data.Result;

public interface DataSourceConsumer {
    void onSuccessfulReceive(Result result);
    void onFailedReceive(Result result);
}
