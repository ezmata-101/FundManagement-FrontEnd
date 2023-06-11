package com.example.fundmanagement.data;

public class StoreAndRetrieveToken {
    private static String tk;
    private static StoreAndRetrieveToken instance = new StoreAndRetrieveToken();

    private StoreAndRetrieveToken() {}


    public static void storeToken(String token) {
        tk = token;
    }
    public static String getToken() {
        return tk;
    }
}
