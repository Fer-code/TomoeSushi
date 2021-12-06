package com.example.tomoesushi;

import com.example.tomoesushi.http.HttpUser;
import com.example.tomoesushi.models.User;
import com.google.gson.Gson;

import java.util.HashMap;

public class Conexao {

    private static final String LOG_TAG = com.example.tomoesushi.Conexao.class.getSimpleName();
    // Constantes utilizadas pela API


    static User logarUsuario(User usuario) {
        HttpUser client = new HttpUser();
        String responseBody = client.doRequest("http://20.114.208.185/api/cliente/login", "POST", new HashMap<>(), usuario);
//        Log.d(LOG_TAG, responseBody);
        return new Gson().fromJson(responseBody, User.class);
    }
}
