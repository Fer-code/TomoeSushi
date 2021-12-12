package com.example.tomoesushi.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tomoesushi.R;
import com.example.tomoesushi.activities.CadastroReservaActivity;

public class ReservaFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reserva, container, false);
        Button btnFazerReserva = view.findViewById(R.id.mais);

        btnFazerReserva.setOnClickListener(this::criarReserva);

        return view;
    }

    public void criarReserva(View view) {
        Intent intent = new Intent(getActivity(), CadastroReservaActivity.class);
        startActivity(intent);
    }
}
