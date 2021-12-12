package com.example.tomoesushi.activities;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tomoesushi.R;
import com.example.tomoesushi.models.Reserva;
import com.example.tomoesushi.services.ReservaService;

public class CadastroReservaActivity extends AppCompatActivity {
    private CalendarView calendarViewDataReserva;
    private EditText editTextQuantidadeAssentos;
    private String dataReserva = "";
    private String horaReserva = "";
    private TimePickerDialog timePickerDialog;
    private ReservaService reservaService;
    private String idCli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fazer_reserva);

        calendarViewDataReserva = findViewById(R.id.calendar);
        editTextQuantidadeAssentos = findViewById(R.id.numPs);

        Button btnSelecionarHorario = findViewById(R.id.selecionarHorario);
        btnSelecionarHorario.setOnClickListener(this::selecionarHorario);

        Button btnConfirmarReserva = findViewById(R.id.confirmarReserva);
        btnConfirmarReserva.setOnClickListener(this::confirmarReserva);

        calendarViewDataReserva.setOnDateChangeListener(this::obterData);

        timePickerDialog = new TimePickerDialog(this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, this::obterHorario, 12, 0, true);
        timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        reservaService = new ReservaService(this);

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        idCli = sharedPreferences.getString(LoginActivity.USER_ID_KEY, null);
    }

    private void obterData(CalendarView view, int i, int i1, int i2) {
        dataReserva = i + "-" + i1 + "-" + i2;
    }

    private void selecionarHorario(View view) {
        timePickerDialog.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void obterHorario(TimePicker view, int hourOfDay, int minute) {
        String horaFormatada = String.valueOf(hourOfDay);
        String minutoFormatado = String.valueOf(minute);
        if (hourOfDay < 10)
            horaFormatada = "0" + hourOfDay;
        if (minute < 10)
            minutoFormatado = "0" + minute;

        view.setHour(hourOfDay);
        view.setMinute(minute);

        horaReserva = horaFormatada + ":" + minutoFormatado + ":" + "00";
    }

    private int obterMesa(int numPessoas) {
        if (numPessoas >= 1 && numPessoas <= 2)
            return 2;
        else if (numPessoas >= 3 && numPessoas <= 4)
            return 1;
        else if (numPessoas >= 5 && numPessoas <= 6)
            return 3;
        else
            return 0;
    }

    private void confirmarReserva(View view) {
        String qtdAssentosString = editTextQuantidadeAssentos.getText().toString();
        if (dataReserva.isEmpty() || horaReserva.isEmpty())
            Toast.makeText(this, "Selecione uma data/horário", Toast.LENGTH_LONG).show();
        else if (qtdAssentosString.isEmpty() || Integer.parseInt(qtdAssentosString) <= 0) {
            Toast.makeText(this, "Informe uma quantidade valida de assentos", Toast.LENGTH_LONG).show();
        } else {
            Reserva reserva = new Reserva();
            reserva.numPessoas = Integer.parseInt(qtdAssentosString);
            reserva.dataHoraReserva = dataReserva + "T" + horaReserva;
            reserva.statusReserva = "Pendente";
            reserva.idCli = Integer.parseInt(idCli);
            reserva.idMesa = obterMesa(Integer.parseInt(qtdAssentosString));

            reservaService.fazerReserva(reserva, response -> {
                Toast.makeText(this, "Reserva realizada com sucesso", Toast.LENGTH_LONG).show();
                finish();
            }, error -> {
                Toast.makeText(this, "Ocorreu um erro ao realizar a reserva", Toast.LENGTH_LONG).show();
            });
        }
    }
}
