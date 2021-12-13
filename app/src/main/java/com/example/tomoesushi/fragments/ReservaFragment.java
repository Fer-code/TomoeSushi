package com.example.tomoesushi.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tomoesushi.R;
import com.example.tomoesushi.activities.CadastroReservaActivity;
import com.example.tomoesushi.adapters.ProdutoAdapter;
import com.example.tomoesushi.adapters.ReservaAdapter;
import com.example.tomoesushi.models.Produto;
import com.example.tomoesushi.models.Reserva;
import com.example.tomoesushi.services.ProdutoService;
import com.example.tomoesushi.services.ReservaService;

import java.util.LinkedList;
import java.util.List;

public class ReservaFragment extends Fragment {

    private ReservaService reservaService;
    private ListView listViewReservas;
    private ArrayAdapter<Reserva> arrayAdapterReserva;
    private List<Reserva> listReserva;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        reservaService = new ReservaService(getActivity());
        View view = inflater.inflate(R.layout.fragment_reserva, container, false);
        Button btnFazerReserva = view.findViewById(R.id.mais);

        listReserva = new LinkedList<>();
        arrayAdapterReserva = new ReservaAdapter(getContext(), android.R.layout.simple_list_item_1, listReserva, getActivity());
        listViewReservas = (ListView) view.findViewById(R.id.reservaList);
        listViewReservas.setAdapter(arrayAdapterReserva);

        btnFazerReserva.setOnClickListener(this::criarReserva);

        atualizarReservas();

        return view;
    }

    public void criarReserva(View view) {
        Intent intent = new Intent(getActivity(), CadastroReservaActivity.class);
        startActivity(intent);
    }

    private void atualizarReservas() {
        reservaService.listarReserva(response -> {
            this.listReserva.clear();
            this.listReserva.addAll(response);
            this.arrayAdapterReserva.notifyDataSetChanged();
        }, error -> {
            Toast.makeText(getActivity(), "Ocorreu um erro durante a listagem de produtos", Toast.LENGTH_SHORT).show();
        });
    }
}
