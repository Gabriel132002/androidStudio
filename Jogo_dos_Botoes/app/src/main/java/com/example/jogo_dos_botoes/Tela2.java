package com.example.jogo_dos_botoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Tela2 extends AppCompatActivity {

    MediaPlayer mp;
    Button btnVoltar;
    TextView txt;
    int qnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        mp = MediaPlayer.create(this,R.raw.final_fantasy7_victory);

        btnVoltar = findViewById(R.id.btnVoltarTela2);
        txt = findViewById(R.id.txtTela2Mostrar);

        mp.start();

        Intent dados = getIntent();
        qnt = dados.getIntExtra("quantidade", 0);

        txt.setText("Número de tentativas: "+ qnt);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Tela2.this, MainActivity.class);
                startActivity(i);
                mp.stop();
                finish();
            }
        });

    }
}