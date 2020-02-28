package com.example.nuevo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Menu02 extends AppCompatActivity implements View.OnClickListener {

    ImageButton btn_emociones;
    ImageButton btn_alimentacion;
    ImageButton btn_higiene;
    ImageButton btn_recreatividad;
    ImageView   img_emociones;
    ImageView   img_alimentacion;
    ImageView   img_higiene;
    ImageView   img_recreatividad;

     final int   OPCION_EMOCIONES       = 1;
     final int   OPCION_ALIMENTACION    = 2;
     final int   OPCION_HIGIENE         = 3;
     final int   OPCION_RECREATIVIDAD   = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu02);

        btn_emociones       =  findViewById(R.id.btn_emociones);
        btn_alimentacion    = findViewById(R.id.btn_alimentacion);
        btn_higiene         = findViewById(R.id.btn_higiene);
        btn_recreatividad   = findViewById(R.id.btn_recreatividad);
        img_alimentacion    = findViewById(R.id.img_alimentacion);
        img_emociones       = findViewById(R.id.img_emociones);
        img_higiene         = findViewById(R.id.img_higiene);
        img_recreatividad   = findViewById(R.id.img_recreatividad);



        btn_recreatividad.setOnClickListener(this);
        btn_higiene.setOnClickListener(this);
        btn_alimentacion.setOnClickListener(this);
        btn_emociones.setOnClickListener(this);
        img_recreatividad.setOnClickListener(this);
        img_higiene.setOnClickListener(this);
        img_emociones.setOnClickListener(this);
        img_alimentacion.setOnClickListener(this);


    /*
        btn_emociones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu02.this,Emociones.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
     */
    }


    @Override
    public void finish()
    {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.btn_emociones: {
                Intent intent = new Intent(Menu02.this, Emociones.class);
                intent.putExtra("opcion",OPCION_EMOCIONES);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            }
            case R.id.btn_alimentacion:{

                Intent intent = new Intent(Menu02.this,Emociones.class);
                intent.putExtra("opcion",OPCION_ALIMENTACION);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            }
            case R.id.btn_higiene:{
                Intent intent = new Intent(Menu02.this,Emociones.class);
                intent.putExtra("opcion",OPCION_HIGIENE);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            }
            case R.id.btn_recreatividad:{
                Intent intent = new Intent(Menu02.this,Emociones.class);
                intent.putExtra("opcion",OPCION_RECREATIVIDAD);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            }
            case R.id.img_emociones: {
                Intent intent = new Intent(Menu02.this, Emociones.class);
                intent.putExtra("opcion",OPCION_EMOCIONES);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            }
            case R.id.img_alimentacion:{

                Intent intent = new Intent(Menu02.this,Emociones.class);
                intent.putExtra("opcion",OPCION_ALIMENTACION);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            }
            case R.id.img_higiene:{
                Intent intent = new Intent(Menu02.this,Emociones.class);
                intent.putExtra("opcion",OPCION_HIGIENE);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            }
            case R.id.img_recreatividad:{
                Intent intent = new Intent(Menu02.this,Emociones.class);
                intent.putExtra("opcion",OPCION_RECREATIVIDAD);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            }
            default: break;

        }

    }
}
