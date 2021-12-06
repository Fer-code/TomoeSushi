package com.example.tomoesushi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tomoesushi.models.Produto;
import com.example.tomoesushi.models.User;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.http.Body;

public class Profile extends AppCompatActivity {

    private RequestQueue mQueue;
    TextView result;
    Gson gson;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        gson = new Gson();
        result = findViewById(R.id.text_view_result);
        final JSONArray[] itemsArray = new JSONArray[1];

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://20.114.208.185/api/cliente/user/gabi";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Success", response.toString());

                        try {
                            itemsArray[0] = new JSONArray(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        int i =1;
                        while (i < itemsArray[0].length()) {
                            try {
                                JSONObject jProd = itemsArray[0].getJSONObject(i);
                                User user = gson.fromJson(jProd.toString(), User.class);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                            result.setText(response);
                        }
                }}, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error", error.toString());
                result.setText(error.getMessage());
            }
        });
        queue.add(stringRequest);

    }
}


