package com.example.nuevo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.Locale;

public class MenuEmociones extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private ViewFlipper viewFlipper;
    private ImageButton btn_back;
    private  ImageButton btn_next;
    private ImageButton btn_altavoz;
    private View decoreView;
    GestureDetector gestureDetector;
    TextToSpeech textToSpeech;
    ImageButton cuadro_next;
    ImageButton cuadro_back;
    int hijos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_menu_emociones);
        decoreView = getWindow().getDecorView();
        gestureDetector = new GestureDetector(this,this);

        focus();
        setUpBotones();
        setUpViewFliper();
        textAvoz();
    }

    void setUpBotones()
    {


        btn_back = (ImageButton) findViewById(R.id.btn_back);
        btn_next = (ImageButton) findViewById(R.id.btn_next);
        btn_altavoz =(ImageButton) findViewById(R.id.btn_altavoz);

        cuadro_back = (ImageButton) findViewById(R.id.pictograma_back);
        cuadro_next = (ImageButton) findViewById(R.id.pictograma_next);


        final Animation anim_translate = AnimationUtils.loadAnimation(this,R.anim.translate);
        Animation anim_translate2 = AnimationUtils.loadAnimation(this,R.anim.translate2);
        btn_next.setAnimation(anim_translate);
        btn_back.setAnimation(anim_translate2);


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cambiaBack();
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cambiaNext();

            }
        });

        btn_altavoz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ImageView auxPictograna = (ImageView) viewFlipper.getCurrentView();

                hablar(auxPictograna.getContentDescription().toString());
            }
        });
    }

    void setUpViewFliper()
    {
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFliper);
        final ImageButton pictograma_boton = (ImageButton) viewFlipper.getCurrentView();

        pictograma_boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hablar(pictograma_boton.getContentDescription().toString());
            }
        });

        viewFlipper.setDisplayedChild(3);
        ImageButton next = (ImageButton) viewFlipper.getChildAt(4);
        ImageButton back= (ImageButton) viewFlipper.getChildAt(2);
        cuadro_next.setImageDrawable(next.getDrawable());
        cuadro_back.setImageDrawable(back.getDrawable());
        hijos = viewFlipper.getChildCount();

    }

    void textAvoz()
    {
        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if(status == TextToSpeech.SUCCESS)
                {
                    int result = textToSpeech.setLanguage(Locale.getDefault());
                    if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED)
                    {
                        Toast.makeText(MenuEmociones.this,"Lenguaje No Soportado",Toast.LENGTH_LONG);
                    }
                    else
                    {
                        textToSpeech.setPitch(0.6f);
                        textToSpeech.setSpeechRate(1.0f);
                       // hablar();
                    }
                }

            }
        });
    }

    void hablar(String texto)
    {

        /* String frase= "tengo sueño"; */
        String frase= texto;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            textToSpeech.speak(frase,TextToSpeech.QUEUE_FLUSH,null,null);
        }
        else {
            textToSpeech.speak(frase, TextToSpeech.QUEUE_FLUSH, null);
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
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus)
        {
            decoreView.setSystemUiVisibility(hideSystemBars());

        }
    }

    void focus()
    {
        decoreView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int i) {
                if(i == 0)
                {
                    decoreView.setSystemUiVisibility(hideSystemBars());
                }
            }
        });
    }

    private  int hideSystemBars()
    {
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
    }


    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent a, MotionEvent b, float v, float v1) {

        float sensible = 50.0f;
        if(a.getX() - b.getX() > sensible)
        {
            //swipe izquierda
            cambiaBack();

        }
        else
        {
            if(b.getX() - a.getX() > sensible)
            {
                //swipe derecha
                cambiaNext();
            }
        }
        return true;

    }

    void cambiaNext()
    {
        viewFlipper.setInAnimation(getApplicationContext(),R.anim.slide_in_left);
        viewFlipper.setOutAnimation(getApplicationContext(),R.anim.slide_out_right);
        ImageButton contenedor = (ImageButton) viewFlipper.getCurrentView();
        cuadro_next.setImageDrawable(contenedor.getDrawable());
        viewFlipper.showPrevious();

        int actual = viewFlipper.getDisplayedChild();
        if (actual <= 0)
        {
            actual = viewFlipper.getChildCount();
        }
        ImageButton aux_atras =  (ImageButton) viewFlipper.getChildAt(actual-1);
        cuadro_back.setImageDrawable(aux_atras.getDrawable());





        final ImageButton pictograma_boton = (ImageButton)viewFlipper.getCurrentView();

        pictograma_boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hablar(pictograma_boton.getContentDescription().toString());
            }
        });

    }

    void cambiaBack()
    {
        viewFlipper.setInAnimation(getApplicationContext(),R.anim.view_flipper_slide_in_rigth);
        viewFlipper.setOutAnimation(getApplicationContext(),R.anim.view_flipper_slide_out_left);
        ImageButton aux = (ImageButton) viewFlipper.getCurrentView();
        cuadro_back.setImageDrawable(aux.getDrawable());
        viewFlipper.showNext();

        int actual = viewFlipper.getDisplayedChild();
        if (actual >= 6)
        {
            actual = -1;
        }
        ImageButton aux_siguiente = (ImageButton) viewFlipper.getChildAt(actual+1);
        cuadro_next.setImageDrawable(aux_siguiente.getDrawable());

        final ImageButton pictograma_boton = (ImageButton) viewFlipper.getCurrentView();

        pictograma_boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hablar(pictograma_boton.getContentDescription().toString());
            }
        });

    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
