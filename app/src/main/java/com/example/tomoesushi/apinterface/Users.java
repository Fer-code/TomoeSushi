package com.example.tomoesushi.apinterface;

import com.example.tomoesushi.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Users {
    @POST("users")
    Call<User> createPost(@Body User user);
}
