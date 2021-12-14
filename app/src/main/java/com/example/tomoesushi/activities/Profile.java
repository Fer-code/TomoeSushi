package com.example.tomoesushi.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tomoesushi.R;
import com.example.tomoesushi.models.User;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

public class Profile extends AppCompatActivity {

    public static final String SHARED_PREFS = "shared_prefs";
    public static final String USER_KEY = "user_key";
    SharedPreferences sharedpreferences;
    TextView result, nome, email, tel, userE, end, definir;
    ImageView profile;
    Gson gson;
    User user;
    JSONArray[] itemsArray = new JSONArray[1];
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        gson = new Gson();

        nome = findViewById(R.id.NomeAlterarTXT);
        email = findViewById(R.id.TelAlterarTXT);
        tel = findViewById(R.id.EmailAlterarTXT);
        userE = findViewById(R.id.UserAlterarTXT);
        profile = findViewById(R.id.imagePerfil);
        end = findViewById(R.id.EndAlterarTXT);
        definir = findViewById(R.id.definir);

        //---------------PEGA USER------------------------------------------------------------------
        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        String codU = sharedpreferences.getString(USER_KEY, null);

        //---------------Imagem---------------------------------------------------------------------
        definir.setOnClickListener(this::imagePicker);

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


    //---------------PARA CAMERA E GALERIA----------------------------------------------------------
    private void imagePicker(View view) {
        ImagePicker.with(this)
                .crop()
                .compress(1024)
                .maxResultSize(1080, 1080)
                .start();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Uri uri = data.getData();
        profile.setImageURI(uri);
    }

    //----------------------------------------------------------------------------------------------
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
        userE.setText(user.getUserCli());

        if( user.getLogradouroCli() != null){
            String localCadastrado = user.getLogradouroCli() + " - " + user.getCepCli() + " - " + user.getNumCli()
                    + " - " + user.getComplementoCli();

            end.setText(localCadastrado);
        }
    }
}


