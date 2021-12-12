package com.example.tomoesushi.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.tomoesushi.R;
import com.example.tomoesushi.activities.CadastroActivity;
import com.example.tomoesushi.activities.MyLocation;
import com.example.tomoesushi.adapters.ProdutoAdapter;
import com.example.tomoesushi.models.Produto;
import com.example.tomoesushi.services.ProdutoService;
import com.synnapps.carouselview.CarouselView;

import java.util.LinkedList;
import java.util.List;

public class HomeFragment extends Fragment {

    private final int[] mImages = new int[]{
            R.drawable.prato_apres_1,
            R.drawable.prato_apres_2,
            R.drawable.prato_apres_3,
            R.drawable.prato_apres_4
    };
    private ProdutoService produtoService;
    private ListView listViewProdutos;
    private ArrayAdapter<Produto> arrayAdapterProduto;
    private List<Produto> listProduto;

    @Nullable
    @Override
    @SuppressLint("WrongViewCast")
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        produtoService = new ProdutoService(getActivity());
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        CarouselView carouselView = (CarouselView) view.findViewById(R.id.carousel_view);
        carouselView.setPageCount(mImages.length);
        carouselView.setImageListener(this::carrouselImageChange);

        CardView cardView = (CardView) view.findViewById(R.id.myL);
        cardView.setOnClickListener(this::onCardClick);

        listProduto = new LinkedList<>();
        arrayAdapterProduto = new ProdutoAdapter(getContext(), android.R.layout.simple_list_item_1, listProduto, getActivity());
        listViewProdutos = (ListView) view.findViewById(R.id.productList);
        listViewProdutos.setAdapter(arrayAdapterProduto);
        listViewProdutos.setOnItemClickListener(this::selecionarProduto);

        atualizarProdutos();

        return view;
    }

    private void onCardClick(View view) {
        Intent intent = new Intent(getActivity(), MyLocation.class);
        startActivity(intent);
    }

    private void carrouselImageChange(int position, ImageView imageView) {
        imageView.setImageResource(mImages[position]);
    }

    private void atualizarProdutos() {
        produtoService.listarProdutos(response -> {
            this.listProduto.clear();
            this.listProduto.addAll(response);
            this.arrayAdapterProduto.notifyDataSetChanged();
        }, error -> {
            Toast.makeText(getActivity(), "Ocorreu um erro durante a listagem de produtos", Toast.LENGTH_SHORT).show();
        });
    }

    private void selecionarProduto(AdapterView<?> parent, View view,int position, long id) {
        System.out.println("Selecionado o produto: " + listProduto.get(position).mnomeProd);
    }
}
