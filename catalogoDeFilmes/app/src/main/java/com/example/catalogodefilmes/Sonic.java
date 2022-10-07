package com.example.catalogodefilmes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class Sonic extends AppCompatActivity {

    ImageView imgRandom;
    Button btnInicio, btnCatalogo;
    int gerar[]={
            R.drawable.sonicacidente,
            R.drawable.sonicaneis,
            R.drawable.sonicart,
            R.drawable.sonicluta,
            R.drawable.soniccorrendo,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonic);

        btnInicio = findViewById(R.id.btnSonicInicio);
        btnCatalogo = findViewById(R.id.btnSonicCatalogo);
        imgRandom = findViewById(R.id.imgSonic);

        int index = new Random().nextInt(gerar.length);
        imgRandom.setImageResource(gerar[index]);

        btnCatalogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sc = new Intent(Sonic.this, MainActivity2.class);
                startActivity(sc);
                finish();
            }
        });

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent si = new Intent(Sonic.this, MainActivity.class);
                startActivity(si);
                finish();
            }
        });

    }
}