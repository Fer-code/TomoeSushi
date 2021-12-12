package com.example.tomoesushi.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tomoesushi.R;
import com.example.tomoesushi.models.User;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

public class Profile extends AppCompatActivity {

    public static final String SHARED_PREFS = "shared_prefs";
    public static final String USER_KEY = "user_key";
    SharedPreferences sharedpreferences;
    TextView result, nome, email, tel, e;
    Gson gson;
    User user;
    JSONArray[] itemsArray = new JSONArray[1];
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        gson = new Gson();
        result = findViewById(R.id.text_view_result);
        nome = findViewById(R.id.NomeAlterarTXT);
        email = findViewById(R.id.TelAlterarTXT);
        tel = findViewById(R.id.EmailAlterarTXT);

        //---------------PEGA USER------------------------------------------------------------------
        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        String codU = sharedpreferences.getString(USER_KEY, null);

        //------------------------------------------------------------------------------------------
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://20.114.208.185/api/cliente/user/" + codU;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Success", response);
                        Perfil(response);


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

    public void Perfil(String response) {

        JSONObject jsonObject = null;
        Log.d("Success Perfil", response);
        try {
            jsonObject = new JSONObject(response);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        user = gson.fromJson(jsonObject.toString(), User.class);
        nome.setText(user.getNomeCli());
        email.setText(user.getEmailCli());
        tel.setText(user.getTelefoneCli());
    }
}


