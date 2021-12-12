package com.example.tomoesushi.services;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.tomoesushi.R;
import com.example.tomoesushi.interfaces.IError;
import com.example.tomoesushi.interfaces.IResponse;
import com.example.tomoesushi.models.Reserva;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReservaService {

    private final String apiUrl;
    private final ObjectMapper mapper;
    private final RequestQueue requestQueue;

    public ReservaService(Context context) {
        this.requestQueue = Volley.newRequestQueue(context);
        this.mapper = new ObjectMapper();
        this.apiUrl = context.getResources().getString(R.string.api_url) + "/reserva";
    }

    public void fazerReserva(Reserva reserva, IResponse<Reserva> onResponse, IError onError) {
        RequestService requestService = new RequestService(Request.Method.POST, this.apiUrl, mapper, reserva, response -> {
            reserva.idReserva = Integer.parseInt(response);
            onResponse.onResponse(reserva);
        }, onError::onError);

        requestQueue.add(requestService);
    }
}
