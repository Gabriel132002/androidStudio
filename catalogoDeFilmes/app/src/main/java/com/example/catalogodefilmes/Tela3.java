package com.example.catalogodefilmes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class Tela3 extends AppCompatActivity {

    ImageView imgRandom;
    int []gerar = {
            R.drawable.exfutjoinha,
            R.drawable.extfutmoto,
            R.drawable.motoexterminador,
            R.drawable.armaexterminador,
            R.drawable.oculosexterminador,
    };
    int index;
    Button voltarInicio, voltarCatalogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);

        imgRandom = findViewById(R.id.imageViewRandom);
        voltarInicio = findViewById(R.id.btnVoltarCatalogo);
        voltarCatalogo = findViewById(R.id.btnExterminadorVoltarTelaInicial);

        index = new Random().nextInt(gerar.length);
        imgRandom.setImageResource(gerar[index]);

        voltarInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Tela3.this, MainActivity2.class);
                startActivity(i);
                finish();
            }
        });

        voltarCatalogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Tela3.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}