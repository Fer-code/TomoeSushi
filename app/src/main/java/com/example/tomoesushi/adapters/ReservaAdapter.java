package com.example.tomoesushi.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.tomoesushi.R;
import com.example.tomoesushi.models.Produto;
import com.example.tomoesushi.models.Reserva;

import java.util.List;

public class ReservaAdapter extends ArrayAdapter<Reserva> {

    public static TextView textViewApagar;
    private Activity activity;

    public ReservaAdapter(@NonNull Context context, int resource, @NonNull List<Reserva> objects, Activity activity) {
        super(context, resource, objects);
        this.activity = activity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(R.layout.lista_reserva, parent, false);
        Reserva reserva = getItem(position);

        TextView textViewDH = (TextView) view.findViewById(R.id.dataHoraReserva);
        TextView textViewStatus = (TextView) view.findViewById(R.id.statusReserva);

        textViewApagar = (TextView) view.findViewById(R.id.apagar);

        textViewDH.setText(reserva.dataHoraReserva);
        textViewStatus.setText(reserva.statusReserva);

        return view;
    }

}
