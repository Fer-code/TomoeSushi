package com.example.tomoesushi.dialogToFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.tomoesushi.R;
import com.example.tomoesushi.fragments.HomeFragment;

public class DialogProducts extends DialogFragment {

    public static final String TAG = "DialogProducts";
    TextView nome, desc, preco, cat;
    private String n, d, p, c;

    public DialogProducts(String n, String d, String p, String c){
        this.n = n;
        this.d = d;
        this.p = p;
        this.c = c;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.info_prod_selected, container, false);

        nome = view.findViewById(R.id.nomeProdutoD);
        desc = view.findViewById(R.id.descricaoProdutoD);
        preco = view.findViewById(R.id.precoProdutoD);
        cat = view.findViewById(R.id.categoriaProdutoD);

        nome.setText(n);
        desc.setText(d);
        preco.setText(p);
        cat.setText(c);

        return view;
    }
}
