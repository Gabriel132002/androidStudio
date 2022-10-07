package com.example.catalogodefilmes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class UltimoHomem extends AppCompatActivity {

    ImageView imgrandom;
    int gerar [] = {
            R.drawable.ultmenolhar,
            R.drawable.dossoracao,
            R.drawable.ultmencorda,
            R.drawable.ultmennotas,
            R.drawable.ultmencurativos,
            R.drawable.ultmenpelotao
    };
    Button btnvoltar, btnInicio;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultimo_homem);

        imgrandom = findViewById(R.id.imageViewUltimoHomem);
        btnvoltar = findViewById(R.id.btnUltimoHomemVoltarCatalogo);
        btnInicio = findViewById(R.id.btnUltimoHomemVoltarInicio);

        int index = new Random().nextInt(gerar.length);
        imgrandom.setImageResource(gerar[index]);

        btnvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UltimoHomem.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UltimoHomem.this, MainActivity2.class);
                startActivity(i);
                finish();
            }
        });

    }
}