package com.example.nuevo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        return 0;
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

        return super.instantiateItem(container, position);
    }
}
