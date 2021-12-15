package com.example.tomoesushi.dialogToFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.tomoesushi.R;
import com.example.tomoesushi.services.ReservaService;

public class DialogDeleteReserva extends DialogFragment {

    private ReservaService reservaService;
    public static final String TAG = "DialogDeleteReserva";
    Button Apagar, NaoApagar;
    private int Id;
    TextView teset;
    int g;

    public DialogDeleteReserva(int Id){
        this.Id = Id;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.deletar_reserva, container, false);

        Apagar = view.findViewById(R.id.b);
        NaoApagar = view.findViewById(R.id.c);
        teset = view.findViewById(R.id.a);

        NaoApagar.setOnClickListener(this::Cancelar);
        Apagar.setOnClickListener(this::RemoverReserva);

       // teset.setText(String.valueOf(Id));

        return view;
    }

    private void RemoverReserva(View view) {
        reservaService.deletarReserva(Id, response -> {
            Toast.makeText(getActivity(), "Reserva apagada com sucesso", Toast.LENGTH_LONG).show();
        }, error -> {
            Toast.makeText(getActivity(), "Ocorreu um erro ao apagar a reserva", Toast.LENGTH_LONG).show();
        });
    }

    private void Cancelar(View view) {
        getDialog().dismiss();
    }
}
