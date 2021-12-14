package com.example.tomoesushi.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.tomoesushi.R;
import com.example.tomoesushi.models.Produto;

import java.util.List;

public class ProdutoAdapter extends ArrayAdapter<Produto> {
    private Activity activity;

    public ProdutoAdapter(@NonNull Context context, int resource, @NonNull List<Produto> objects, Activity activity) {
        super(context, resource, objects);
        this.activity = activity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(R.layout.item_lista_view, parent, false);
        Produto produto = getItem(position);

        TextView textViewNome = (TextView) view.findViewById(R.id.nomeProduto);
        TextView textViewDescricao = (TextView) view.findViewById(R.id.descricaoProduto);
        TextView textViewCategoria = (TextView) view.findViewById(R.id.categoriaProduto);
        TextView textViewPreco = (TextView) view.findViewById(R.id.precoProduto);

            textViewNome.setText(produto.NomeProd);
            textViewDescricao.setText(produto.DescProd);
            textViewCategoria.setText(produto.CategoriaProd);
            textViewPreco.setText(String.valueOf(produto.PrecoProd));

        return view;
    }
}
