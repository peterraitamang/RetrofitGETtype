package com.example.retrofitget;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    private static Retrofit retrofit = null;
    public static ApiInterface getClient() {

        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        ApiInterface api = retrofit.create(ApiInterface.class);
        return api;
    }

}
