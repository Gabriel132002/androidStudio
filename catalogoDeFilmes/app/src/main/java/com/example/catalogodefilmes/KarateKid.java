package com.example.catalogodefilmes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class KarateKid extends AppCompatActivity {

    Button btnInicio, btnCatalogo;
    ImageView imgRandom;
    TextView txtTitulo;
    int gerar [] = {
            R.drawable.karatedaniel,
            R.drawable.karatefinal,
            R.drawable.karategarca,
            R.drawable.karatemiagi,
            R.drawable.karatetreino,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karate_kid);

        btnCatalogo = findViewById(R.id.btnKarateCatalogo);
        btnInicio = findViewById(R.id.btnKarateInicio);
        imgRandom = findViewById(R.id.imgKarate);
        txtTitulo = findViewById(R.id.txtTituloKid);

        int index = new Random().nextInt(gerar.length);
        imgRandom.setImageResource(gerar[index]);

        txtTitulo.setText(getIntent().getStringExtra("kid"));

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ki = new Intent(KarateKid.this, MainActivity.class);
                startActivity(ki);
                finish();
            }
        });

        btnCatalogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kc = new Intent(KarateKid.this, MainActivity2.class);
                startActivity(kc);
                finish();
            }
        });

    }
}