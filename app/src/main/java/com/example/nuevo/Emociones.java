package com.example.nuevo;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import java.util.ArrayList;

public class Emociones extends AppCompatActivity {


    ArrayList<ItemPictograma> pictogramas;
    ImageView titulo;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emociones);
        titulo = findViewById(R.id.titulo);
        pictogramas = new ArrayList<>();
        LlenarDatos();
        HorizontalInfiniteCycleViewPager horizontalInfiniteCycleViewPager = findViewById(R.id.cards);
        AdapterPictograma adapterPictograma = new AdapterPictograma(pictogramas,getApplicationContext(),0);
        horizontalInfiniteCycleViewPager.setAdapter(adapterPictograma);
    }


    void  LlenarDatos()
    {
        switch (getIntent().getIntExtra("opcion",10)){

            case 1:{
                titulo.setImageResource(R.drawable.emociones);
                pictogramas.add(new ItemPictograma(R.drawable.carabonton1,"Feliz"));
                pictogramas.add(new ItemPictograma(R.drawable.caraboton2,"Triste"));
                pictogramas.add(new ItemPictograma(R.drawable.carafeliz,"Pensativo"));
                pictogramas.add(new ItemPictograma(R.drawable.caratranquilo,"Tranquilo"));
                pictogramas.add(new ItemPictograma(R.drawable.carafeliz,"Pensativo"));
                pictogramas.add(new ItemPictograma(R.drawable.caratranquilo,"Tranquilo"));

                break;
            }
            case 2:{
                titulo.setImageResource(R.drawable.alimentacion);
                pictogramas.add(new ItemPictograma(R.drawable.carabonton1,"Feliz"));
                pictogramas.add(new ItemPictograma(R.drawable.caraboton2,"Triste"));
                pictogramas.add(new ItemPictograma(R.drawable.carafeliz,"Pensativo"));
                pictogramas.add(new ItemPictograma(R.drawable.caratranquilo,"Tranquilo"));
                break;
            }
            case 3:{
                titulo.setImageResource(R.drawable.higiene);
                pictogramas.add(new ItemPictograma(R.drawable.carabonton1,"Feliz"));
                pictogramas.add(new ItemPictograma(R.drawable.caraboton2,"Triste"));
                pictogramas.add(new ItemPictograma(R.drawable.carafeliz,"Pensativo"));
                pictogramas.add(new ItemPictograma(R.drawable.caratranquilo,"Tranquilo"));
                break;
            }
            case 4:{
                titulo.setImageResource(R.drawable.recreatividad);
                pictogramas.add(new ItemPictograma(R.drawable.carabonton1,"Felixz"));
                pictogramas.add(new ItemPictograma(R.drawable.caraboton2,"Triste"));
                pictogramas.add(new ItemPictograma(R.drawable.carafeliz,"Pensativo"));
                pictogramas.add(new ItemPictograma(R.drawable.caratranquilo,"Tranquilo"));
            }
            default: break;
        }

    }

    @Override
    public void finish()
    {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);

    }
}
