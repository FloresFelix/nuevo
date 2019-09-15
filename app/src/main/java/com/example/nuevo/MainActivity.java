package com.example.nuevo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button comenzar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comenzar = (Button)(findViewById(R.id.play));
        comenzar.setOnClickListener(MainActivity.this);

    }
    @Override
    public void onClick(View v) {

        //Your Logic
        Intent intent = new Intent(MainActivity.this,Menu01.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
        finish();
        Log.i("tonio","APRETANDO EL BOTON");
    }


}
