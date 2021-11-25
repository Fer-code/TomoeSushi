package com.example.tomoesushi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
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

public class HomeFragment extends Fragment {

    private RequestQueue mQueue;

    TextView result;
    CardView cardView;
    Toolbar toolbar;

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

        Gson gson = new Gson();
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        CarouselView carouselView = (CarouselView) view.findViewById(R.id.carousel_view);
        cardView = (CardView) view.findViewById(R.id.myL);
        result = (TextView) view.findViewById(R.id.text_view_result) ;

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

            /*
        String json = "{\"idProd\":1,\"nomeProd\":\"Proção pequena de sushi de salmão\",\"descProd\":\"50 sushis em que o arroz é enrrolado em alga marinha e recheado com salmão cru\",\"precoProd\":\"12.05\",\"categoriaProd\":\"prato\",\"statusProd\":\"indisponível\"}";
        Produto produto = gson.fromJson(json, Produto.class);
        */

        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        String url = "http://20.114.208.185/api/produto";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        result.setText("Response is: " + response);
                        //String json = response;
                        //Produto produto = gson.fromJson(json, Produto.class);
                        //JSONObject items = JSONObject.getJSONArray(json);
                        //new Gson().fromJson(response, Produto.class);

                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        JSONArray itemsArray = null;
                        try {
                            itemsArray = jsonObject.getJSONArray("");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        int i = 0;
                        String nome = null;

                        while (i < itemsArray.length() && (nome == null)) {
                            try {
                                JSONObject book = itemsArray.getJSONObject(i);
                                JSONObject volumeInfo = book.getJSONObject("");
                                nome = volumeInfo.getString("nomeProd");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            i++;
                        }
                        //result.setText(nome);*/
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                result.setText(error.getMessage());
            }
        });
        queue.add(stringRequest);

        return view;

    }

}
