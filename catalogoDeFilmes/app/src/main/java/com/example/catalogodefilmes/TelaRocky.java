package com.example.catalogodefilmes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class TelaRocky extends AppCompatActivity {

    ImageView imgrandom;
    int gerarimg[] = {
            R.drawable.rockychapeu,
            R.drawable.rockycsd,
            R.drawable.rockytreinandocomcarne,
            R.drawable.rockyvitoria,
            R.drawable.rockypose,
    };
    int index;
    Button btnvoltarInicio, btnVoltarCatalogo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_rocky);

        btnVoltarCatalogo = findViewById(R.id.btnRockyVoltarCatalogo);
        btnvoltarInicio = findViewById(R.id.btnRockyInicio);

        imgrandom = findViewById(R.id.imageViewRocky);

        index = new Random().nextInt(gerarimg.length);
        imgrandom.setImageResource(gerarimg[index]);

        btnvoltarInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TelaRocky.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnVoltarCatalogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TelaRocky.this, MainActivity2.class);
                startActivity(i);
                finish();
            }
        });

    }
}