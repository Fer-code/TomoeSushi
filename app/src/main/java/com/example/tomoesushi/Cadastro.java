package com.example.tomoesushi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Cadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        getSupportActionBar().hide();
    }

    public void Cadastrar(View v){
        Intent inte = new Intent(this, Login.class);
        startActivity(inte);
        finish();
    }
}