package com.example.tomoesushi.http;


import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpUser {

    Gson gson = new Gson();
    OkHttpClient client = new OkHttpClient();

    public String doRequest(String url, String method) {
        return doRequest(url, method, new HashMap<>());
    }

    public String doRequest(String url, String method, Map<String, String> headers) {
        return doRequest(url, method, headers, null);
    }

    public String doRequest(String url, String method, Map<String, String> headers, Object body) {

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String responseBody = null;
        try {

            if(method.equals("POST"))
                return this.post(url,headers,body);

            URL requestURL = new URL(url);
            // Abre a conexão de rede
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod(method);

            for(Map.Entry<String, String> entry : headers.entrySet()) {
                urlConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }

            urlConnection.connect();

            // Busca o InputStream.
            InputStream inputStream = urlConnection.getInputStream();

            // Cria o buffer para o input stream
            reader = new BufferedReader(new InputStreamReader(inputStream));

            // Usa o StringBuilder para receber a resposta.
            StringBuilder builder = new StringBuilder();
            String linha;
            while ((linha = reader.readLine()) != null) {
                // Adiciona a linha a string.
                builder.append(linha);
                builder.append("\n");
            }
            if (builder.length() == 0) {
                // se o stream estiver vazio não faz nada
                return null;
            }

            responseBody = builder.toString();

        } catch (IOException e) {
            e.printStackTrace();

        } catch(Exception ex) {
            ex.printStackTrace();
        }
        finally {
            // fecha a conexão e o buffer.
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return responseBody;
    }

    private String post(String url, Map<String, String> headers, Object bodyObj) throws IOException {
        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, gson.toJson(bodyObj));
        Request.Builder requestBuilder = new Request.Builder()
                .url(url)
                .post(body);

        for(Map.Entry<String, String> entry : headers.entrySet()) {
            requestBuilder.addHeader(entry.getKey(), entry.getValue());
        }

        Request request = requestBuilder.build();

        Response response = client.newCall(request).execute();

        return response.body().string();
    }
}