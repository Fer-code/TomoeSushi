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
import com.example.tomoesushi.models.User;
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
         result = findViewById(R.id.text_view_result);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://20.114.208.185/api/cliente";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Success", response.toString());
                        tratarRespostaProfile(response);
                        //result.setText(response);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error", error.toString());
                result.setText(error.getMessage());
            }
        });
        queue.add(stringRequest);

    }

    public void tratarRespostaProfile(String response) {
        Log.d("TratarResponse", response.toString());

        JSONArray itemsArray = null;
        try {
            itemsArray = new JSONArray(response);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        int i = 0;
        String nome = null;
        ArrayList<User> listaProduto = new ArrayList<User>();

        while (i < itemsArray.length()) {
            try {
                JSONObject jProd = itemsArray.getJSONObject(i);
                User p = gson.fromJson(jProd.toString(), User.class);
                listaProduto.add(p);

            } catch (JSONException e) {
                e.printStackTrace();
            }
            i++;
            for (User p :listaProduto
            ) {

                StringBuilder sb=new StringBuilder(result.getText());
                sb.append("\n ID: = ");
                sb.append(p.idUser);
                sb.append("\n Nome: = ");
                sb.append(p.nomeUser);
                sb.append("\n email: = ");
                sb.append(p.emailUser);
                sb.append("\n User = ");
                sb.append(p.userCli);
                sb.append("\n Senha = ");
                sb.append(p.senhaUser);
                sb.append("\n Telefone = ");
                sb.append(p.telUser);
                sb.append("\n Telefone = ");
                sb.append(p.cepUser);
                sb.append("\n Telefone = ");
                sb.append(p.logUser);
                sb.append("\n Telefone = ");
                sb.append(p.numUser);
                sb.append("\n Telefone = ");
                sb.append(p.complementoUser);
                sb.append("\n");
                result.setText(sb);

            }
            //result.setText(nome);*/
        }
    }
}