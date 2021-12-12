package com.example.tomoesushi.services;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestService extends StringRequest {
    private final ObjectMapper mapper;
    private final Object body;

    public RequestService(int method, String url, ObjectMapper mapper, Object body, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
        this.mapper = mapper;
        this.body = body;
    }

    @Override
    public String getBodyContentType() {
        return "application/json";
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        try {
            return mapper.writeValueAsBytes(body);
        } catch (JsonProcessingException e) {
            throw new AuthFailureError("Ocorreu um erro ao deserializar o objeto");
        }
    }
}
