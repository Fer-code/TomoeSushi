package com.example.tomoesushi.services;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.tomoesushi.R;
import com.example.tomoesushi.interfaces.IError;
import com.example.tomoesushi.interfaces.IResponse;
import com.example.tomoesushi.models.CEP;
import com.example.tomoesushi.models.Produto;
import com.example.tomoesushi.models.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class ProdutoService {
    private final String apiUrl;
    private final ObjectMapper mapper;
    private final RequestQueue requestQueue;

    public ProdutoService(Context context) {
        this.requestQueue = Volley.newRequestQueue(context);
        this.mapper = new ObjectMapper();
        this.apiUrl = context.getResources().getString(R.string.api_url) + "/produto";
    }

    public void listarProdutos(IResponse<List<Produto>> onResponse, IError onError) {
        RequestService requestService = new RequestService(Request.Method.GET, apiUrl, mapper, null, response -> {
            try {
                List<Produto> productList = mapper.readValue(response, new TypeReference<List<Produto>>(){});
                onResponse.onResponse(productList);
            } catch (JsonProcessingException e) {
                onError.onError(e);
            }
        }, onError::onError);

        requestQueue.add(requestService);
    }

}
