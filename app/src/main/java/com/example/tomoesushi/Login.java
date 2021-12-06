package com.example.tomoesushi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tomoesushi.database.DBHelper;
import com.example.tomoesushi.http.HttpUser;
import com.example.tomoesushi.models.User;
import com.google.gson.Gson;

import java.util.HashMap;

public class Login extends AppCompatActivity {

    DBHelper db = new DBHelper(this);
    EditText txtCampoUsuario, txtCampoSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        txtCampoUsuario = findViewById(R.id.editTextTextPersonName2);
        txtCampoSenha = findViewById(R.id.ETsenha);
    }
    /*public void Enter(View v){
        Intent in = new Intent(Login.this, MainActivity.class);
        startActivity(in);

    }*/
    public void Cadastrar(View c){
        Intent cad = new Intent(this, Cadastro.class);
        startActivity(cad);
    }

    public void Logar(View view) {

        /*User us = new User();
       /* us.setUserCli(txtCampoUsuario.getText().toString());
        us.setSenhaUser(txtCampoSenha.getText().toString());

        us.setUserCli("aurora");
        us.setSenhaUser("a");

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        User usuarioLogado = Conexao.logarUsuario(us);

        if(usuarioLogado.getIdUser() == 0 && usuarioLogado.getUserCli() == null) {
            Toast.makeText(this, "Usuario inválido", Toast.LENGTH_SHORT).show();
        } else {*/
        Intent intentEntrar = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intentEntrar);
        //}

    }

    //--------------------------------------------------------------------------
    /*static User logarUsuario(User usuario) {
        HttpUser client = new HttpUser();
        String responseBody = client.doRequest("http://20.114.208.185/api/cliente/login", "POST", new HashMap<>(), usuario);
//        Log.d(LOG_TAG, responseBody);
        return new Gson().fromJson(responseBody, User.class);
    }*/
}