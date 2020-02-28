package com.example.nuevo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Menu01 extends AppCompatActivity implements View.OnClickListener {

    ImageButton btn_rutina,btn_rutina_flecha;
    ImageButton btn_agenda,btn_agenda_flecha;
    ImageButton btn_oraciones,btn_oraciones_flecha;
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
        btn_agenda = (ImageButton) (findViewById(R.id.brn_agenda));
        btn_oraciones = (ImageButton) (findViewById(R.id.btn_oraciones));
        btn_agenda_flecha = findViewById(R.id.btn_flecha_agenda);
        btn_oraciones_flecha = findViewById(R.id.btn_flecha_oraciones);
        btn_rutina_flecha = findViewById(R.id.btn_flecha_rutina);

        btn_agenda.setOnClickListener(this);
        btn_agenda_flecha.setOnClickListener(this);
        btn_rutina.setOnClickListener(this);
        btn_rutina_flecha.setOnClickListener(this);
        btn_oraciones.setOnClickListener(this);
        btn_oraciones_flecha.setOnClickListener(this);



        img_corazon.startAnimation(anim_scale);
        img_reloj.startAnimation(anim_shake);
        img_lapiz.startAnimation(anim_scale);



    }



    @Override
    public void onClick(View view) {


        switch (view.getId())
        {

            case R.id.btn_rutina:
            {
                Intent intent = new Intent(Menu01.this, Menu02.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            }

            case  R.id.btn_flecha_rutina: {
                Intent intent = new Intent(Menu01.this, Menu02.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            }

            case R.id.brn_agenda: {
                Intent intent = new Intent(Menu01.this, Menu03.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            }
            case R.id.btn_flecha_agenda: {
                Intent intent = new Intent(Menu01.this, Menu03.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            }
            case R.id.btn_oraciones: {
                Intent intent = new Intent(Menu01.this, Oraciones.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            }
            case R.id.btn_flecha_oraciones: {
                Intent intent = new Intent(Menu01.this, Oraciones.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            }
            default: break;
        }

    }
}
