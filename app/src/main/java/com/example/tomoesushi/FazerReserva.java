package com.example.tomoesushi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tomoesushi.models.Reserva;
import com.example.tomoesushi.models.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FazerReserva extends AppCompatActivity {

    CalendarView calendarView;
    Button confDia;
    EditText quuantA;

    RequestQueue requestQueue;

    private final ObjectMapper mapper = new ObjectMapper();

    int Hora, Minuto, Assentos, numMesa;
    int teste;

    String date;
     String TotalH, socorro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fazer_reserva);

        calendarView = findViewById(R.id.calendar);
        confDia = findViewById(R.id.confReserva);
        quuantA = findViewById(R.id.numPs);
        socorro = quuantA.getText().toString();

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int i, int i1, int i2) {
                date = i + "-" + i2 + "-" + (i1 + 1)+"T";
                Toast.makeText(FazerReserva.this, "" + date, Toast.LENGTH_SHORT).show();
            }
        });
        confDia.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(FazerReserva.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                Hora = hourOfDay;
                                Minuto = minute;
                                /*2021-09-10T20:00:09;

                                mes dia ano;
                                ano dia mes*/

                                String time = Hora + " : " + Minuto;
                                SimpleDateFormat f24hours = new SimpleDateFormat("HH:mm");
                                try {
                                    Date date = f24hours.parse(time);
                                    SimpleDateFormat f4hours = new SimpleDateFormat("HH:mm");
                                    //SimpleDateFormat f12hours = new SimpleDateFormat("HH:mm aa");

                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, 12, 0, true);
                TotalH = Hora+":"+Minuto+":00";
                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.updateTime(Hora, Minuto);
                timePickerDialog.show();

                teste = Integer.parseInt(quuantA.getText().toString());

                PickMesa(teste);

            }
        });
    }

    public void H(View c){
       passClass();

        //int teste = Integer.valueOf(socorro);

       // Assentos = Integer.parseInt(teste);
      //  Toast.makeText(FazerReserva.this, ""+teste, Toast.LENGTH_SHORT).show();

    }

    private void PickMesa(int numPessoas){
        if(numPessoas>=1 && numPessoas<=2){
            numMesa = 2;

        }
        else if(numPessoas>=3 && numPessoas<=4){
            numMesa = 1;

        }
        else if(numPessoas>=5 && numPessoas<=6){
            numMesa = 3;

        }
    }

    //-------------------------------------------POST-----------------------------------------------
    /*"idReserva": 1,
        "numPessoas": 4,
        "dataHoraReserva": "2021-09-10T20:00:09",
        "statusReserva": "Cliente compareceu",
        "idCli": 2,
        "idMesa": 1*/

    public void passClass(){
        int numAssentos = teste;
        String dataHoraReserva = date+TotalH;
        String statusReserva= "Pendente";
        int idCli = 1;
        int idMesa = numMesa;

        Reserva reserva = new Reserva();
        reserva.numPessoas = numAssentos;
        reserva.dataHoraReserva = dataHoraReserva;
        reserva.statusReserva = statusReserva;
        reserva.idCli = idCli;
        reserva.idMesa = idMesa;

        CadastraRes(reserva);
    }

    public void CadastraRes(Reserva reserva) {
        String uri = "http://20.114.208.185/api/reserva";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, uri,
                response -> Toast.makeText(FazerReserva.this, "Success", Toast.LENGTH_LONG).show(),
                error -> Toast.makeText(FazerReserva.this, "" + error.getMessage(), Toast.LENGTH_LONG).show()) {
            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    return mapper.writeValueAsBytes(reserva);
                } catch (JsonProcessingException e) {
                    throw new AuthFailureError("Ocorreu um erro ao deserializar o objeto");
                }
            }
            @Override
            public String getBodyContentType() {
                return "application/json";
            }
        };
        requestQueue = Volley.newRequestQueue(FazerReserva.this);
        requestQueue.add(stringRequest);
    }
}