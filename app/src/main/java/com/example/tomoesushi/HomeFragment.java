package com.example.tomoesushi;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class HomeFragment extends Fragment {

    Button button;
    Toolbar toolbar;

    private int[] mImages = new int[]{
            R.drawable.prato_apres_1,
            R.drawable.prato_apres_2,
            R.drawable.prato_apres_3,
            R.drawable.prato_apres_4
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /*return /*inflater.inflate(R.layout.fragment_home, container, false*/

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        CarouselView carouselView = (CarouselView) view.findViewById(R.id.carousel_view);

        carouselView.setPageCount(mImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImages[position]);
            }
        });

            /*button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), Profile.class);
                    startActivity(intent);
                }
            });*/

        return view;
    }

}
