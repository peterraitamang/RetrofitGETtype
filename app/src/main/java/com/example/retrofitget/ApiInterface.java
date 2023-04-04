package com.example.retrofitget;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("https://jsonplaceholder.typicode.com/todos")
    Call<List<UserListResponse>>getUsersList();
}
