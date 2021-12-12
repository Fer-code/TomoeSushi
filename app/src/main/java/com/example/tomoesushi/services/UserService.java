package com.example.tomoesushi.services;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.tomoesushi.R;
import com.example.tomoesushi.interfaces.IError;
import com.example.tomoesushi.interfaces.IResponse;
import com.example.tomoesushi.models.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserService {
    private final String apiUrl;
    private final ObjectMapper mapper;
    private final RequestQueue requestQueue;

    public UserService(Context context) {
        this.requestQueue = Volley.newRequestQueue(context);
        this.mapper = new ObjectMapper();
        this.apiUrl = context.getResources().getString(R.string.api_url) + "/cliente";
    }

    public void login(User user, IResponse<User> onResponse, IError onError) {
        String url = this.apiUrl + "/login";
        RequestService requestService = new RequestService(Request.Method.POST, url, mapper, user, response -> {
            try {
                User responseUser = mapper.readValue(response, User.class);
                onResponse.onResponse(responseUser);
            } catch (JsonProcessingException e) {
                onError.onError(e);
            }
        }, onError::onError);

        requestQueue.add(requestService);
    }

    public void cadastrar(User user, IResponse<User> onResponse, IError onError) {
        RequestService requestService = new RequestService(Request.Method.POST, this.apiUrl, mapper, user, response -> {
            user.idCli = Integer.parseInt(response);
            onResponse.onResponse(user);
        }, onError::onError);

        requestQueue.add(requestService);
    }
}
