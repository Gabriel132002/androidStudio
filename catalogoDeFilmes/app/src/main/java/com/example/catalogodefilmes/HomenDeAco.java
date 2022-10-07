package com.example.catalogodefilmes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class HomenDeAco extends AppCompatActivity {

    Button btnInicio, btnCatalogo;
    ImageView imgRandom;
    int gerar[] = {
            R.drawable.superelouis,
            R.drawable.supermolhado,
            R.drawable.superpose,
            R.drawable.supersoldados,
            R.drawable.supertribunal
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homen_de_aco);

        btnCatalogo = findViewById(R.id.btnSuperCatalogo);
        btnInicio = findViewById(R.id.btnSuperInicio);
        imgRandom = findViewById(R.id.imgSuperMan);

        int index = new Random().nextInt(gerar.length);
        imgRandom.setImageResource(gerar[index]);

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inicio = new Intent(HomenDeAco.this, MainActivity.class);
                startActivity(inicio);
                finish();
            }
        });

        btnCatalogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent catalogo = new Intent(HomenDeAco.this, MainActivity2.class);
                startActivity(catalogo);
                finish();
            }
        });

    }
}