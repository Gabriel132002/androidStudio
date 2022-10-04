package com.example.app_push_your_luck;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.rtp.AudioStream;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //Variáveis para sons e música
    Button btn01;
    ImageView img01;
    TextView txt01;
    SoundPool snd;
    MediaPlayer msc;
    boolean tocar = true;
    int click;
    String frases[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn01 = findViewById(R.id.btn01);
        img01 = findViewById(R.id.imageview01);
        txt01 = findViewById(R.id.txtview02);

        frases = new String[]
                {"A vida trará coisas boas se tiver paciência.\n",
                "Demonstre amor e alegria em todas as oportunidades e verá que a paz nasce dentro de si.\n",
                "Não compense na ira o que lhe falta na razão.\n"};

        //Efeitos sonoros
        snd = new SoundPool(4, AudioManager.STREAM_MUSIC, 8);
        click = snd.load(MainActivity.this, R.raw.click, 3);

        msc = MediaPlayer.create(MainActivity.this, R.raw.msc);
        msc.start();

        img01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tocar){
                    msc.pause();
                    img01.setImageResource(R.drawable.semsom);
                }else{
                    msc.start();
                    img01.setImageResource(R.drawable.som);
                }
                tocar = !tocar;
            }
        });

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int valor = random.nextInt(15);
                txt01.setText(frases[valor]);
                snd.play(click, 1, 1, 1, 0, 1);
            }
        });
    }
}