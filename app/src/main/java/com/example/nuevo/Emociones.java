package com.example.nuevo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import java.util.ArrayList;

public class Emociones extends AppCompatActivity {


    ArrayList<ItemPictograma> pictogramas;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emociones);
        pictogramas = new ArrayList<>();
        LlenarDatos();
        HorizontalInfiniteCycleViewPager horizontalInfiniteCycleViewPager = findViewById(R.id.cards);
        AdapterPictograma adapterPictograma = new AdapterPictograma(pictogramas,getApplicationContext());
        horizontalInfiniteCycleViewPager.setAdapter(adapterPictograma);
    }


    void  LlenarDatos()
    {
        pictogramas.add(new ItemPictograma(R.drawable.carabonton1,"Felixz"));
        pictogramas.add(new ItemPictograma(R.drawable.caraboton2,"Triste"));
        pictogramas.add(new ItemPictograma(R.drawable.carafeliz,"Pensativo"));
        pictogramas.add(new ItemPictograma(R.drawable.caratranquilo,"Tranquilo"));


    }
}
