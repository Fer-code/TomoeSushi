package com.example.tomoesushi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Profile extends AppCompatActivity {

    private RequestQueue mQueue;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        final TextView result = findViewById(R.id.text_view_result);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://20.114.208.185/api/cliente/user/gabi";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        result.setText("Response is: "+ response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                result.setText("That didn't work!");
            }
        });

        queue.add(stringRequest);

        /*JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener() {
                    @Override
                    public void onResponse(Object response) {
                        String result = "Your IP Address is " + response.getString("ip");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        result.setText(error.getMessage());
                    }
                });
        mQueue.add(jsonArrayRequest);*/
       // fetchJsonResponse();
    }
        /*private void fetchJsonResponse() {
            // Pass second argument as "null" for GET requests
            JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, "http://20.114.208.185/api/produto", null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                String result = "Your name is " + response.getString("nomeProd");
                                Toast.makeText(Profile.this, result, Toast.LENGTH_SHORT).show();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.e("Error: ", error.getMessage());
                }
            });
            mQueue.add(req);
        }*/
/*
    private void jsonParse() {

            String url = "http://20.114.208.185/api/produto" + contador;

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                JSONArray jsonArray = response.getJSONArray("records");

                                for (int i = 0; i < 10; i++) {
                                    JSONObject exposicao = jsonArray.getJSONObject(i);

                                    String title = exposicao.getString("title");
                                    String begindate = exposicao.getString("begindate");
                                    String enddate = exposicao.getString("enddate");
                                    String description = exposicao.getString("description");
                                    String temporalorder = exposicao.getString("temporalorder");

                                    txtViewResult.append(title + "\n");

                                    progressBar.setVisibility(false ? View.VISIBLE : View.GONE);

                                    try {
                                        db.addExpo(new ExpoClass(title, begindate, enddate, description, temporalorder));
                                    } catch (Exception e) {

                                    }
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            });
            mQueue.add(request);
        } else {
            Toast.makeText(this, "Página não disponível", Toast.LENGTH_SHORT).show();
            contE.setText("");
            txtViewResult.setText("");
        }
    }*/
}