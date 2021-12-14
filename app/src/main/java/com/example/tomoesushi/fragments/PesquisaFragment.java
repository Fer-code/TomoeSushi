package com.example.tomoesushi.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tomoesushi.R;
import com.example.tomoesushi.models.Produto;
import com.example.tomoesushi.models.User;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;

public class PesquisaFragment extends Fragment {

    Gson gson;
    EditText buscaItemTXT;
    TextView resultTXT;
    Button pesquisarBTN;
    GifImageView vemvai;

    Produto produto;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_pesquisa, container, false);
        View view = inflater.inflate(R.layout.fragment_pesquisa, container, false);
        gson = new Gson();

        buscaItemTXT = view.findViewById(R.id.buscaItem);
        pesquisarBTN = view.findViewById(R.id.pesquisarBtn);
        resultTXT = view.findViewById(R.id.produtoProcurado);
        vemvai = view.findViewById(R.id.gif);

        pesquisarBTN.setOnClickListener(this::PesquisarNome);

        return view;
    }

    private void PesquisarNome(View view) {

        if(buscaItemTXT.getText().toString().isEmpty()){
            Toast.makeText(getActivity(), "Informe o nome do produto", Toast.LENGTH_SHORT).show();
        }else{
            RequestQueue queue = Volley.newRequestQueue(getActivity());
            String url = "http://20.114.208.185/api/produto/nome/"+buscaItemTXT.getText().toString();

            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("Success", response);
                            Qual(response);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("Error", error.toString());
                    Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
            queue.add(stringRequest);
        }
    }

    private void Qual(String response) {
        JSONObject jsonObject = null;
        Log.d("Success", response);
        try {
            jsonObject = new JSONObject(response);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        produto = gson.fromJson(jsonObject.toString(), Produto.class);
        if(produto.getNomeProd()!=null) {
            String resultado = produto.getNomeProd() + "\n" + " "
                    + produto.getDescProd() + '\n' + " " +
                    produto.getPrecoProd() + "\n" + " " +
                    produto.getStatusProd();
            resultTXT.setText(resultado);

            vemvai.setVisibility(View.GONE);
        }
        else{
            resultTXT.setText("Produto não encontrado");

        }

    }


}
