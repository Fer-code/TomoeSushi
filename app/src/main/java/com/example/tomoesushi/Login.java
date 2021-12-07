package com.example.tomoesushi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tomoesushi.database.DBHelper;
import com.example.tomoesushi.http.HttpUser;
import com.example.tomoesushi.models.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.util.HashMap;

public class Login extends AppCompatActivity {

    public static final String USER_KEY = "user_key";
    public static final String SHARED_PREFS = "shared_prefs";
    SharedPreferences sharedpreferences;
    DBHelper db = new DBHelper(this);
    EditText txtCampoUsuario, txtCampoSenha;
    private final ObjectMapper mapper = new ObjectMapper();
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        txtCampoUsuario = findViewById(R.id.editTextTextPersonName2);
        txtCampoSenha = findViewById(R.id.ETsenha);
    }
    public void Cadastrar(View c){
        Intent cad = new Intent(this, Cadastro.class);
        startActivity(cad);
    }

    public void Logar(View view) {

        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        String uri = "http://20.114.208.185/api/cliente/login";
        User us = new User();
        us.userCli = txtCampoUsuario.getText().toString();
        us.senhaCli = txtCampoSenha.getText().toString();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, uri,
                response -> {
                    try {
                        User responseUser = mapper.readValue(response, User.class);
                        if(responseUser.userCli != null) {
                            String u = String.valueOf(responseUser.userCli);
                            SharedPreferences.Editor editor = sharedpreferences.edit();

                            editor.putString(USER_KEY, u);

                            editor.apply();

                            Intent intentEntrar = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intentEntrar);
                        } else {
                            Toast.makeText(Login.this, "Usuário ou senha inválidos", Toast.LENGTH_LONG).show();
                        }
                    } catch (JsonProcessingException e) {
                        Toast.makeText(Login.this, "Ocorreu um erro ao efetuar o Login, tente novamente", Toast.LENGTH_LONG).show();
                    }
                },
                error -> Toast.makeText(Login.this, "Ocorreu um erro ao efetuar o Login, tente novamente", Toast.LENGTH_LONG).show()) {
            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    return mapper.writeValueAsBytes(us);
                } catch (JsonProcessingException e) {
                    throw new AuthFailureError("Ocorreu um erro ao deserializar o objeto");
                }
            }

            @Override
            public String getBodyContentType() {
                return "application/json";
            }
        };
        requestQueue = Volley.newRequestQueue(Login.this);
        requestQueue.add(stringRequest);
    }
}