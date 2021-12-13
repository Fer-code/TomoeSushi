package com.example.tomoesushi.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tomoesushi.R;
import com.example.tomoesushi.models.User;
import com.example.tomoesushi.services.CepService;
import com.example.tomoesushi.services.UserService;
import com.example.tomoesushi.utils.Mascara;

public class CadastroActivity extends AppCompatActivity {
    private EditText editTextNome;
    private EditText editTextUsuario;
    private EditText editTextEmail;
    private EditText editTextTelefone;
    private EditText editTextSenha;
    private EditText editTextConfirmacaoSenha;

    private EditText editTextCep;
    private EditText editTextLogradouro;
    private EditText editTextComplemento;
    private EditText editTextNumero;

    private CepService cepService;
    private UserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        getSupportActionBar().hide();

        editTextNome = findViewById(R.id.edtName);
        editTextUsuario = findViewById(R.id.edtUser);
        editTextEmail = findViewById(R.id.edtEmail);
        editTextTelefone = findViewById(R.id.edtTel);
        editTextSenha = findViewById(R.id.edtSenha);
        editTextConfirmacaoSenha = findViewById(R.id.edtConfSenha);

        cepService = new CepService(this);
        userService = new UserService(this);
    }


    public void cadastrarUsuario(View view) {
        createNewContactDialog();
        if (editTextNome.getText().toString().isEmpty() || editTextUsuario.getText().toString().isEmpty()
                || editTextEmail.getText().toString().isEmpty() || editTextSenha.getText().toString().isEmpty()
                || editTextTelefone.getText().toString().isEmpty() || editTextConfirmacaoSenha.getText().toString().isEmpty()) {
            Toast.makeText(CadastroActivity.this, "Insira os dados corretamente", Toast.LENGTH_SHORT).show();
        } else if (!editTextSenha.getText().toString().equals(editTextConfirmacaoSenha.getText().toString())) {
            Toast.makeText(CadastroActivity.this, "As senhas não correspondem", Toast.LENGTH_SHORT).show();
        } else if (!isEmailValid(editTextEmail.getText().toString())) {
            Toast.makeText(CadastroActivity.this, "Email inserido incorretamente", Toast.LENGTH_SHORT).show();
        } else {
            createNewContactDialog();
        }
    }

    private boolean isEmailValid(final String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void createNewContactDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.cep_dialog, null);

        editTextCep = (EditText) contactPopupView.findViewById(R.id.cep);
        editTextLogradouro = (EditText) contactPopupView.findViewById(R.id.log);
        editTextComplemento = (EditText) contactPopupView.findViewById(R.id.comp);
        editTextNumero = (EditText) contactPopupView.findViewById(R.id.num);
        Button btnPular = (Button) contactPopupView.findViewById(R.id.pular);
        Button btnSalvar = (Button) contactPopupView.findViewById(R.id.save);
        Button btnCEP = (Button) contactPopupView.findViewById(R.id.btnCEP);

        btnPular.setOnClickListener(this::pular);
        btnSalvar.setOnClickListener(this::salvar);
        btnCEP.setOnClickListener(this::consultarCep);

        editTextCep.addTextChangedListener(Mascara.insert(Mascara.MASCARA_CEP, editTextCep));

        dialogBuilder.setView(contactPopupView);
        Dialog dialog = dialogBuilder.create();
        dialog.show();
    }

    private void pular(View view) {
        User user = new User();
        user.NomeCli = editTextNome.getText().toString();
        user.EmailCli = editTextEmail.getText().toString();
        user.userCli = editTextUsuario.getText().toString();
        user.senhaCli = editTextSenha.getText().toString();
        user.TelefoneCli = editTextTelefone.getText().toString();

        user.cepCli = "";
        user.logradouroCli = "";
        user.complementoCli = "";
        user.numCli = "";

        cadastrar(user);
    }

    private void salvar(View view) {
        String cep = cepService.cleanCep(editTextCep.getText().toString());
        if (cep.isEmpty()) {
            editTextCep.setError("Digite um CEP válido.");
        } else if (cep.length() != 8) {
            editTextCep.setError("O CEP deve possuir 8 dígitos");
        } else {
            User user = new User();
            user.NomeCli = editTextNome.getText().toString();
            user.EmailCli = editTextEmail.getText().toString();
            user.userCli = editTextUsuario.getText().toString();
            user.senhaCli = editTextSenha.getText().toString();
            user.TelefoneCli = editTextTelefone.getText().toString();
            user.cepCli = cep;
            user.logradouroCli = editTextLogradouro.getText().toString();
            user.complementoCli = editTextComplemento.getText().toString();
            user.numCli = editTextNumero.getText().toString();

            cadastrar(user);
        }
    }

    private void consultarCep(View view) {
        cepService.obterCep(editTextCep.getText().toString(), response -> {
            editTextLogradouro.setText(response.logradouro);
            editTextComplemento.setText(response.complemento);
            Toast.makeText(getApplicationContext(), "CEP consultado com sucesso", Toast.LENGTH_LONG).show();
            //TODO desabilitar escrita nos campos com preenchimento automático
        }, error -> {
            Toast.makeText(getApplicationContext(), "Ocorreu um erro ao tentar consultar o CEP. Erro: " + error.getMessage(), Toast.LENGTH_LONG).show();
        });
    }

    private void cadastrar(User user) {
        userService.cadastrar(user, response -> {
            Toast.makeText(this, "Usuário cadastrado com sucesso.", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }, error -> {
            Toast.makeText(this, "Ocorreu um erro durante o cadastro: " + error.getMessage(), Toast.LENGTH_LONG).show();
        });
    }
}
