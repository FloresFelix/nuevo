package com.example.nuevo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Locale;

public class Oraciones extends AppCompatActivity {


    HorizontalInfiniteCycleViewPager pager;
    HorizontalInfiniteCycleViewPager pager2;
    HorizontalInfiniteCycleViewPager pager3;
    AdapterPictograma adapterPictograma1;
    AdapterPictograma adapterPictograma2;
    AdapterPictograma adapterPictograma3;
    ArrayList<ItemPictograma> pictogramas_palabra1;
    ArrayList<ItemPictograma> pictogramas_palabra2;
    ArrayList<ItemPictograma> pictogramas_palabra3;
    FloatingActionButton floatingActionButton;
    TextToSpeech textToSpeech;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oraciones);

        floatingActionButton = findViewById(R.id.fab);
        pictogramas_palabra1 = new ArrayList<>();
        pictogramas_palabra2 = new ArrayList<>();
        pictogramas_palabra3 = new ArrayList<>();
        CargaBloque1();
        CargaBloque2();
        CargaBloque3();
        pager = findViewById(R.id.palabra1);
        pager2 = findViewById(R.id.palabra2);
        pager3 = findViewById(R.id.palabra3);
        adapterPictograma1 = new AdapterPictograma(pictogramas_palabra1,getApplicationContext(),1);
        adapterPictograma2 = new AdapterPictograma(pictogramas_palabra2,getApplicationContext(),1);
        adapterPictograma3 = new AdapterPictograma(pictogramas_palabra3,getApplicationContext(),1);
        pager.setAdapter(adapterPictograma1);
        pager2.setAdapter(adapterPictograma2);
        pager3.setAdapter(adapterPictograma3);

        SetTextTSpeach();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String palabra1 = pictogramas_palabra1.get(pager.getRealItem()).getNombre_pictograma();
                String palabra2 = pictogramas_palabra2.get(pager2.getRealItem()).getNombre_pictograma();
                String palabara3 = pictogramas_palabra3.get(pager3.getRealItem()).getNombre_pictograma();
                String oracion_cmpleta = palabra1+" "+palabra2+" "+palabara3;
                TextoVoz(oracion_cmpleta);

            }
        });

    }

    void  CargaBloque1()
    {
        pictogramas_palabra1.add(new ItemPictograma(R.drawable.carabonton1,"Feliz"));
        pictogramas_palabra1.add(new ItemPictograma(R.drawable.caraboton2,"Triste"));
        pictogramas_palabra1.add(new ItemPictograma(R.drawable.carafeliz,"Pensativo"));
        pictogramas_palabra1.add(new ItemPictograma(R.drawable.caratranquilo,"Tranquilo"));
    }
    void  CargaBloque2()
    {
        pictogramas_palabra2.add(new ItemPictograma(R.drawable.carabonton1,"Feliz"));
        pictogramas_palabra2.add(new ItemPictograma(R.drawable.caraboton2,"Triste"));
        pictogramas_palabra2.add(new ItemPictograma(R.drawable.carafeliz,"Pensativo"));
        pictogramas_palabra3.add(new ItemPictograma(R.drawable.caratranquilo,"Tranquilo"));
    }
    void  CargaBloque3()
    {
        pictogramas_palabra3.add(new ItemPictograma(R.drawable.carabonton1,"Feliz"));
        pictogramas_palabra3.add(new ItemPictograma(R.drawable.caraboton2,"Triste"));
        pictogramas_palabra3.add(new ItemPictograma(R.drawable.carafeliz,"Pensativo"));
        pictogramas_palabra3.add(new ItemPictograma(R.drawable.caratranquilo,"Tranquilo"));
    }



    void  SetTextTSpeach()
    {

        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if (status == TextToSpeech.SUCCESS) {
                    int result = textToSpeech.setLanguage(new Locale("spa", "ESP"));
                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        //Toast.makeText(context, "Lenguaje No Soportado", Toast.LENGTH_LONG).show();
                    } else {
                        textToSpeech.setPitch(0.6f);
                        textToSpeech.setSpeechRate(1.0f);
                    }

                }

            }
        });
    }

    void TextoVoz(String oracion)
    {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            textToSpeech.speak(oracion,TextToSpeech.QUEUE_ADD,null,null);
        }
        else {
            textToSpeech.speak(oracion, TextToSpeech.QUEUE_ADD, null);
        }
    }



    @Override
    protected void onDestroy() {
        if(textToSpeech != null)
        {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }


    @Override
    public void finish()
    {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }
}
