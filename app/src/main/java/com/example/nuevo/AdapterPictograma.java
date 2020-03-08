package com.example.nuevo;

import android.content.Context;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class AdapterPictograma extends PagerAdapter {


    ArrayList<ItemPictograma> pictogramas;
    Context context;
    LayoutInflater layoutInflater;
    TextToSpeech textToSpeech;
    int opcion;

    public AdapterPictograma(ArrayList<ItemPictograma> pictogramas, Context context, int op) {
        this.pictogramas = pictogramas;
        this.context = context;
        this.opcion = op;
        layoutInflater = LayoutInflater.from(context);


        textToSpeech = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
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

        container.removeView((View) object);
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {


        if (opcion == 1) {
            View view = layoutInflater.inflate(R.layout.item_pictograma, container, false);
            ImageView imageView = view.findViewById(R.id.img_pictograma);
            TextView textView = view.findViewById(R.id.nombre_pictograma);

            CardView cardView = view.findViewById(R.id.card);
            ViewGroup.LayoutParams layoutParams2 = cardView.getLayoutParams();
            layoutParams2.height = 750;
            cardView.setLayoutParams(layoutParams2);
            int[] lista_de_clores = context.getResources().getIntArray(R.array.lista_de_colores);
            int randomAndroidColor = lista_de_clores[new Random().nextInt(lista_de_clores.length)];
            cardView.setCardBackgroundColor(randomAndroidColor);


            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.height = 600;
            layoutParams.height = 600;
            imageView.setLayoutParams(layoutParams);

            textView.setTextSize(20);


            imageView.setImageResource(pictogramas.get(position).getPictograma());
            textView.setText(pictogramas.get(position).getNombre_pictograma());
           // Toast.makeText(context, "Clickeand Pictograna", Toast.LENGTH_SHORT).show();
            container.addView(view);
            return view;




        } else {
            View view = layoutInflater.inflate(R.layout.item_pictograma, container, false);
            ImageView imageView = view.findViewById(R.id.img_pictograma);
            TextView textView = view.findViewById(R.id.nombre_pictograma);
            imageView.setImageResource(pictogramas.get(position).getPictograma());
            textView.setText(pictogramas.get(position).getNombre_pictograma());
            container.addView(view);

            CardView cardView = view.findViewById(R.id.card);
            int[] lista_de_clores = context.getResources().getIntArray(R.array.lista_de_colores);
            int randomAndroidColor = lista_de_clores[new Random().nextInt(lista_de_clores.length)];
            cardView.setCardBackgroundColor(randomAndroidColor);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SetTextoAVoz();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        textToSpeech.speak(pictogramas.get(position).nombre_pictograma, TextToSpeech.QUEUE_ADD, null, null);
                    } else {
                        textToSpeech.speak(pictogramas.get(position).getNombre_pictograma(), TextToSpeech.QUEUE_ADD, null);
                    }
                    //Toast.makeText(context,"Clickeand Pictograna"+pictogramas.get(position).getNombre_pictograma(),Toast.LENGTH_SHORT).show();
                }
            });
            return view;
        }
    }
    void SetTextoAVoz()
    {
        /*
        textToSpeech = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if (status == TextToSpeech.SUCCESS) {
                    int result = textToSpeech.setLanguage(Locale.getDefault());
                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        //Toast.makeText(context, "Lenguaje No Soportado", Toast.LENGTH_LONG).show();
                    } else {
                        textToSpeech.setPitch(0.6f);
                        textToSpeech.setSpeechRate(1.0f);
                    }

                }

            }
        });

        */

    }
}
