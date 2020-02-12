package com.example.nuevo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class AdapterPictograma extends PagerAdapter {

    ArrayList<ItemPictograma> pictogramas;
    Context context;
    LayoutInflater layoutInflater;

    public AdapterPictograma(ArrayList<ItemPictograma> pictogramas, Context context) {
        this.pictogramas = pictogramas;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return pictogramas.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View)object);
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = layoutInflater.inflate(R.layout.item_pictograma,container,false);
        ImageView imageView = view.findViewById(R.id.img_pictograma);
        TextView textView = view.findViewById(R.id.nombre_pictograma);
        imageView.setImageResource(pictogramas.get(position).getPictograma());
        textView.setText(pictogramas.get(position).getNombre_pictograma());
        container.addView(view);
        return view;
    }
}