package com.example.tomoesushi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tomoesushi.apiCep.Mascara;
import com.example.tomoesushi.apiCep.RESTService;
import com.example.tomoesushi.database.DBHelper;
import com.example.tomoesushi.models.CEP;
import com.example.tomoesushi.models.User;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Cadastro extends AppCompatActivity implements View.OnClickListener  {

    private final String URL_CEP = "https://viacep.com.br/ws/";

    EditText nameE, telE, emailE, senhaE, confSenha, cepE, logE, comE, numE ;
    private Button ok, pular, salvar, btnCEP;

    private Retrofit retrofitCEP;
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
        btnCEP = findViewById(R.id.btnCEP);

        
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


    private Boolean validarCampos() {

        Boolean status = true;
        String cep = cepE.getText().toString().trim();

        if (cep.isEmpty()) {
            cepE.setError("Digite um CEP válido.");
            status = false;
        }

        if ((cep.length() > 1) && (cep.length() < 10)) {
            cepE.setError("O CEP deve possuir 8 dígitos");
            status = false;
        }
        return status;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCEP:
                if (validarCampos()) {
                    esconderTeclado();
                    consultarCEP();
                }
                break;
        }
    }

    private void esconderTeclado() {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
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
        salvar = (Button)contactPopupView.findViewById(R.id.save);
        btnCEP = (Button)contactPopupView.findViewById(R.id.btnCEP);


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


        //----------------------CEP--------------------------------------------------------
        cepE.addTextChangedListener(Mascara.insert(Mascara.MASCARA_CEP, cepE));

        //configura os recursos do retrofit
        retrofitCEP = new Retrofit.Builder()
                .baseUrl(URL_CEP)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        btnCEP.setOnClickListener(this);
        //---------------------------------------------------------------------------------

    }

    private boolean validateEmailFormat(final String email) {
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return false;
        }
        return true;

    }
    //----------------------CEP---------------------------------------------------
    private void consultarCEP() {
        String sCep = cepE.getText().toString().trim();
        sCep = sCep.replaceAll("[.-]+", "");
        RESTService restService = retrofitCEP.create(RESTService.class);
        Call<CEP> call = restService.consultarCEP(sCep);
        call.enqueue(new Callback<CEP>() {
            @Override
            public void onResponse(Call<CEP> call, Response<CEP> response) {
                if (response.isSuccessful()) {
                    CEP cep = response.body();
                    logE.setText(cep.getLogradouro());
                    comE.setText(cep.getComplemento());
                    Toast.makeText(getApplicationContext(), "CEP consultado com sucesso", Toast.LENGTH_LONG).show();
                    //TODO desabilitar escrita nos campos com preenchimento automático
                }
            }

            @Override
            public void onFailure(Call<CEP> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Ocorreu um erro ao tentar consultar o CEP. Erro: " + t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }

}