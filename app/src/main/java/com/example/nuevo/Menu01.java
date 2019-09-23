package com.example.nuevo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Menu01 extends AppCompatActivity implements View.OnClickListener {

    ImageButton btn_rutina;
    ImageButton btn_agenda;
    ImageButton btn_oraciones;
    ImageView img_corazon,img_reloj,img_lapiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu01);


        Animation anim_scale = AnimationUtils.loadAnimation(this, R.anim.grow_anim);
        Animation anim_shake = AnimationUtils.loadAnimation(this, R.anim.shake_anim);
        img_corazon = (ImageView) findViewById(R.id.corazon);
        img_reloj = (ImageView) findViewById(R.id.reloj);
        img_lapiz= (ImageView) findViewById(R.id.lapiz);
        btn_rutina = (ImageButton) (findViewById(R.id.btn_rutina));
        //btn_rutina.setOnClickListener(Menu01.this);
        //btn_rutina.startAnimation(anim_scale);
        img_corazon.startAnimation(anim_scale);
        img_reloj.startAnimation(anim_shake);
        img_lapiz.startAnimation(anim_scale);
        btn_agenda = (ImageButton) (findViewById(R.id.brn_agenda));
        //btn_agenda.startAnimation(anim_shake);

        btn_oraciones = (ImageButton) (findViewById(R.id.btn_oraciones));

        btn_rutina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu01.this, Menu02.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        btn_agenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu01.this, Menu03.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        btn_oraciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu01.this, Menu04.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }



    @Override
    public void onClick(View view) {


    }
}
