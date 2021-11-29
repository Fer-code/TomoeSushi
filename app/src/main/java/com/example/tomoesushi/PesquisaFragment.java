package com.example.tomoesushi;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
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
import com.example.tomoesushi.models.Produto;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PesquisaFragment extends Fragment {

    Gson gson;
    ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_pesquisa, container, false);
        View view = inflater.inflate(R.layout.fragment_pesquisa, container, false);
        gson = new Gson();


        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        String url = "http://20.114.208.185/api/produto";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Success", response.toString());
                        tatarResposta(response);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error", error.toString());
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        queue.add(stringRequest);


        return view;
    }

    public void tatarResposta(String response) {
        Log.d("TratarResponse", response.toString());

        JSONArray itemsArray = null;
        try {
            itemsArray = new JSONArray(response);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        int i = 0;
        String nome = null;
//definir a lista de produtos no melhor local
        ArrayList<Produto> listaProduto = new ArrayList<Produto>();

        while (i < itemsArray.length()) {
            try {
                JSONObject jProd = itemsArray.getJSONObject(i);
                Produto p = gson.fromJson(jProd.toString(), Produto.class);
                listaProduto.add(p);

            } catch (JSONException e) {
                e.printStackTrace();
            }
            i++;
            String itens = String.valueOf(listaProduto.size());
            Toast.makeText(getContext(), itens,
                    Toast.LENGTH_SHORT).show();
            for (Produto p :listaProduto
            ) {

               /* StringBuilder sb=new StringBuilder(listView.getAdapter());
                sb.append("\n ID: = ");
                sb.append(p.midProd);
                sb.append("\n Categoria: = ");
                sb.append(p.mcatProd);
                sb.append("\n Nome: = ");
                sb.append(p.mnomeProd);
                sb.append("\n Descrição = ");
                sb.append(p.mdescProd);
                sb.append("\n Preço = ");
                sb.append(p.mprecoProd);
                sb.append("\n Status = ");
                sb.append(p.mstatusProd);
                sb.append("\n");
                listView.setAdapter(sb);*/

            }
            //result.setText(nome);
        }
    }
}
