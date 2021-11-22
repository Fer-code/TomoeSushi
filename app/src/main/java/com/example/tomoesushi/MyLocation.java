package com.example.tomoesushi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyLocation extends AppCompatActivity implements FetchAddressTask.OnTaskCompleted {


    private static final int REQUEST_LOCATION_PERMISSION = 1;
    private static final String FILE_NAME = "local";

    private TextView txtResultado, txtLoad;

    private String lastLatitude = "";
    private String lastLongitude = "";
    private String lastAdress = "";

    private String teste = "";


    private FusedLocationProviderClient mFusedLocationClient;
    private LocationCallback mLocationCallback;
    private boolean mTrackingLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_location);

        getSupportActionBar().hide();

        txtLoad = findViewById(R.id.txtInternal);
        txtResultado = findViewById(R.id.txtResult);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);


        mLocationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (mTrackingLocation) {
                    new FetchAddressTask(MyLocation.this, MyLocation.this)
                            .execute(locationResult.getLastLocation());
                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        vaiofvr();
        load();

        String result = txtResultado.getText().toString();
        String load = txtLoad.getText().toString();

        int la = 0;
        
        if (teste.contains(lastAdress)) {
            Toast.makeText(this, "IGUAL", Toast.LENGTH_LONG).show();
        } else{
            Toast.makeText(this, "CRONOOOO", Toast.LENGTH_LONG).show();
        }
        //canCallLoad();

       /* String results = txtLoad.getText().toString();
        for (int i = 0; i < results.length(); i++)
        {
            // Whatever the relevant log call is
            Log.d("Got character: ", "" + (int) results.charAt(i));
        }
*/
    }

   /* public void canCallLoad(){
        if(!txtResultado.getText().toString().equals(txtLoad.getText().toString())){
            load();
        }
        else{
            //txtLoad.setVisibility(false ? View.VISIBLE : View.GONE);
            Toast.makeText(this, "equal", Toast.LENGTH_LONG).show();
        }
    }*/

    public void vaiofvr(){
        if (!mTrackingLocation) {
            startTrackingLocation();
        } else {
            stopTrackingLocation();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_LOCATION_PERMISSION:
                // Permissão garantida
                if (grantResults.length > 0
                        && grantResults[0]
                        == PackageManager.PERMISSION_GRANTED) {
                    startTrackingLocation();
                } else {
                    Toast.makeText(this,
                            "Localização negada",
                            Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


    private void stopTrackingLocation() {
        if (mTrackingLocation) {
            mTrackingLocation = false;
            txtResultado.setText(R.string.iniciar);
        }
    }

    private void startTrackingLocation() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]
                            {Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION_PERMISSION);
        } else {
            mTrackingLocation = true;
            mFusedLocationClient.requestLocationUpdates
                    (getLocationRequest(),
                            mLocationCallback,
                            null);

        }
    }

    //Atualizacoes de localização
    private LocationRequest getLocationRequest() {
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setInterval(10000);
        locationRequest.setFastestInterval(5000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        return locationRequest;
    }

    @Override
    public void onTaskCompleted(String[] result) {
        if (mTrackingLocation) {
            // Update the UI
            lastLatitude = result[1];
            lastLongitude = result[2];
            lastAdress = result[0];
            txtResultado.setText(getString(R.string.address_text, lastAdress));

            save();
            //Esconder a progressBar

        }
    }

    //Armazenamento interno
    public void save(){
        String text = txtResultado.getText().toString();
        FileOutputStream fos = null;

        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(text.getBytes());

            // txtMLocation.getText().clear();
           // Toast.makeText(this, "Savo em " + getFilesDir()+ "/" + FILE_NAME, Toast.LENGTH_LONG).show();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fos != null){
                try {
                    fos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public void load(){
        FileInputStream fis = null;
        try{
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null){
                sb.append(text);
            }

            teste = sb.toString();

            txtLoad.setText(teste);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fis != null){
                try{
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

    }
}