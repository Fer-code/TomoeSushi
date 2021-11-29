package com.example.tomoesushi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tomoesushi.models.Produto;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {

    private RequestQueue mQueue;
    TextView result;
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        gson = new Gson();
        final TextView result = findViewById(R.id.text_view_result);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://20.114.208.185/api/cliente/user/gabi";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        result.setText("Response is: " + response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                result.setText("That didn't work!");
            }
        });

        queue.add(stringRequest);

    }

    public void tratarResposta(String response) {
        Log.d("TratarResponse", response.toString());

        JSONArray itemsArray = null;
        try {
            itemsArray = new JSONArray(response);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        int i = 0;
        String nome = null;
//definir a lista de produtos no melhor local
        ArrayList<Produto> listaProduto = new ArrayList<Produto>();

        while (i < itemsArray.length()) {
            try {
                JSONObject jProd = itemsArray.getJSONObject(i);
                Produto p = gson.fromJson(jProd.toString(), Produto.class);
                listaProduto.add(p);

            } catch (JSONException e) {
                e.printStackTrace();
            }
            i++;
            String itens = String.valueOf(listaProduto.size());
            for (Produto p : listaProduto
            ) {

                StringBuilder sb = new StringBuilder(result.getText());
                sb.append("\n ID: = ");
                sb.append(p.midProd);
                sb.append("\n Categoria: = ");
                sb.append(p.mcatProd);
                sb.append("\n Nome: = ");
                sb.append(p.mnomeProd);
                sb.append("\n Descrição = ");
                sb.append(p.mdescProd);
                sb.append("\n Preço = ");
                sb.append(p.mprecoProd);
                sb.append("\n Status = ");
                sb.append(p.mstatusProd);
                sb.append("\n");
                result.setText(sb);

            }
            //result.setText(nome);*/
        }

    }
}