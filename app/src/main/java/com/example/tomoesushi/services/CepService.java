package com.example.tomoesushi.services;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.tomoesushi.interfaces.IError;
import com.example.tomoesushi.interfaces.IResponse;
import com.example.tomoesushi.models.CEP;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CepService {
    private final String URL_CEP = "https://viacep.com.br/ws";
    private final ObjectMapper mapper;
    private final RequestQueue requestQueue;

    public CepService(Context context) {
        this.requestQueue = Volley.newRequestQueue(context);
        this.mapper = new ObjectMapper();
    }

    public void obterCep(String cep, IResponse<CEP> onResponse, IError onError) {
        String formattedCep = cleanCep(cep);
        String url = URL_CEP + "/" + formattedCep + "/json";
        RequestService requestService = new RequestService(Request.Method.GET, url, mapper, null, response -> {
            try {
                CEP responseCEP = mapper.readValue(response, CEP.class);
                onResponse.onResponse(responseCEP);
            } catch (JsonProcessingException e) {
                onError.onError(e);
            }
        }, onError::onError);

        requestQueue.add(requestService);
    }

    public String cleanCep(String rawCep) {
        return rawCep.trim().replaceAll("[.-]+", "");
    }
}
