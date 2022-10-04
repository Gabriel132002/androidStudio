package com.example.catalogodefilmes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MotoqueiroFantasma extends AppCompatActivity {

    Button btnVoltar;
    ImageView imgRandom;
    int gerar [] = {
            R.drawable.mfart,
            R.drawable.mffilme,
            R.drawable.mfcemiterio,
            R.drawable.mfmoto,
            R.drawable.mfluta,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motoqueiro_fantasma);

        btnVoltar = findViewById(R.id.btnMotoqueiroVoltarCatalogo);
        imgRandom = findViewById(R.id.imageViewMtFantasma);

        int index= new Random().nextInt(gerar.length);
        imgRandom.setImageResource(gerar[index]);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MotoqueiroFantasma.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}