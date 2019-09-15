package com.example.nuevo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Menu01 extends AppCompatActivity implements View.OnClickListener {

    ImageButton btn_rutina;
    ImageButton btn_agenda;
    ImageButton btn_oraciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu01);

        btn_rutina = (ImageButton) (findViewById(R.id.imageButton7));
        //btn_rutina.setOnClickListener(Menu01.this);

        btn_agenda = (ImageButton) (findViewById(R.id.imageButton6));

        btn_oraciones = (ImageButton) (findViewById(R.id.imageButton5));

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
