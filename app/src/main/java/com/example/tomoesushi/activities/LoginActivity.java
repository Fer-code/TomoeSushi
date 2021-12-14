package com.example.tomoesushi.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tomoesushi.R;
import com.example.tomoesushi.models.User;
import com.example.tomoesushi.services.UserService;

public class LoginActivity extends AppCompatActivity {
    public static final String USER_KEY = "user_key";
    public static final String USER_ID_KEY = "user_id";

    private EditText editTextUsuario;
    private EditText editTextSenha;
    private UserService userService;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        editTextUsuario = findViewById(R.id.editTextTextPersonName2);
        editTextSenha = findViewById(R.id.ETsenha);
        userService = new UserService(LoginActivity.this);
        sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
    }

    public void abrirCadastro(View view) {
        Intent cad = new Intent(this, CadastroActivity.class);
        startActivity(cad);
    }

    public void realizarLogin(View view) {
        User us = new User();
        us.UserCli = editTextUsuario.getText().toString();
        us.senhaCli = editTextSenha.getText().toString();

        userService.login(us, response -> {
            if (response.UserCli != null) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(USER_KEY, response.UserCli);
                editor.putString(USER_ID_KEY, String.valueOf(response.IdCli));
                editor.apply();
                Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainIntent);
            } else {
                Toast.makeText(LoginActivity.this, "Usuário ou senha inválidos", Toast.LENGTH_LONG).show();
            }
        }, error -> Toast.makeText(LoginActivity.this, "Ocorreu um erro ao efetuar o Login, tente novamente", Toast.LENGTH_LONG).show());
    }
}
