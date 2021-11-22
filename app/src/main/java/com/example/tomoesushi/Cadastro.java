package com.example.tomoesushi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tomoesushi.database.DBHelper;
import com.example.tomoesushi.models.User;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Cadastro extends AppCompatActivity {

    EditText nameE, telE, emailE, senhaE, confSenha, cepE, logE, comE, numE ;
    Button ok, pular, salvar;

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;

    DBHelper db = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        getSupportActionBar().hide();

        ok = findViewById(R.id.button2);
        nameE = findViewById(R.id.edtName);
        emailE = findViewById(R.id.edtEmail);
        telE = findViewById(R.id.edtTel);
        senhaE = findViewById(R.id.edtSenha);
        confSenha = findViewById(R.id.edtConfSenha);

        
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nameE.getText().toString().isEmpty() || emailE.getText().toString().isEmpty() ||
                        senhaE.getText().toString().isEmpty() || telE.getText().toString().isEmpty() ||
                        confSenha.getText().toString().isEmpty() ){
                    Toast.makeText(Cadastro.this, "Insira os dados corretamente", Toast.LENGTH_SHORT).show();
                }
                else if  (!senhaE.getText().toString().equals(confSenha.getText().toString())){
                    Toast.makeText(Cadastro.this, "As senhas não correspondem", Toast.LENGTH_SHORT).show();
                }
                else if (validateEmailFormat(emailE.getText().toString())  == true)
                {
                    Toast.makeText(Cadastro.this, "Email inserido incorretamente", Toast.LENGTH_SHORT).show();
                }
                else if (db.ValidacaoEmail(emailE.getText().toString())) {
                    Toast.makeText(Cadastro.this, "Email já utilizado", Toast.LENGTH_SHORT).show();
                }
                else {

                    createNewContactDialog();
                }
            }
        });
    }

    //Dialog
    public void createNewContactDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.cep_dialog, null);

        cepE = (EditText) contactPopupView.findViewById(R.id.cep);
        logE = (EditText) contactPopupView.findViewById(R.id.log);
        comE = (EditText) contactPopupView.findViewById(R.id.comp);
        numE = (EditText) contactPopupView.findViewById(R.id.num);
        pular = (Button) contactPopupView.findViewById(R.id.pular);
        salvar = (Button) contactPopupView.findViewById(R.id.save);

        dialogBuilder.setView(contactPopupView);
        dialog = dialogBuilder.create();
        dialog.show();

        pular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addUsuario(new User(nameE.getText().toString(), emailE.getText().toString(),
                        telE.getText().toString(), senhaE.getText().toString()));
                Toast.makeText(Cadastro.this, "adicionado com sucesso", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Cadastro.this, Login.class);
                startActivity(intent);

                finish();
            }
        });

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addUsuario(new User(nameE.getText().toString(), emailE.getText().toString(),
                        telE.getText().toString(), senhaE.getText().toString(), cepE.getText().toString(),
                        logE.getText().toString(), comE.getText().toString(), numE.getText().toString()));
                Toast.makeText(Cadastro.this, "adicionado com sucesso", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Cadastro.this, Login.class);
                startActivity(intent);

                finish();
            }
        });
    }

    private boolean validateEmailFormat(final String email) {
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return false;
        }
        return true;
    }
}