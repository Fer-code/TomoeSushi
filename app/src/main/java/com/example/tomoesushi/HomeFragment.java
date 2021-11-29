package com.example.tomoesushi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tomoesushi.models.Produto;
import com.google.gson.Gson;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RequestQueue mQueue;

    TextView result;
    CardView cardView;
    Toolbar toolbar;
    Gson gson;

    private int[] mImages = new int[]{
            R.drawable.prato_apres_1,
            R.drawable.prato_apres_2,
            R.drawable.prato_apres_3,
            R.drawable.prato_apres_4
    };

    @SuppressLint("WrongViewCast")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_home, container, false;

        gson = new Gson();
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        CarouselView carouselView = (CarouselView) view.findViewById(R.id.carousel_view);
        cardView = (CardView) view.findViewById(R.id.myL);
        result = (TextView) view.findViewById(R.id.text_view_result);

        carouselView.setPageCount(mImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImages[position]);
            }
        });

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyLocation.class);
                startActivity(intent);
            }
        });

        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        String url = "http://20.114.208.185/api/produto";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Success", response.toString());
                        tratarResposta(response);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error", error.toString());
                result.setText(error.getMessage());
            }
        });
        queue.add(stringRequest);

        return view;

    }

    public void tratarResposta(String response) {
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

                StringBuilder sb=new StringBuilder(result.getText());
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
                result.setText(sb);

            }
            //result.setText(nome);*/
        }
    }
}
