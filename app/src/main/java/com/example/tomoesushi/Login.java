package com.example.tomoesushi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();
    }
    public void Enter(View v){
        Intent in = new Intent(Login.this, MainActivity.class);
        startActivity(in);
    }
    public void Cadastrar(View c){
        Intent cad = new Intent(this, Cadastro.class);
        startActivity(cad);
    }
}