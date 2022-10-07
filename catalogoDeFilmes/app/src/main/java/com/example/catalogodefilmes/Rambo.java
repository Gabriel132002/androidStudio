package com.example.catalogodefilmes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class Rambo extends AppCompatActivity {

    Button btnInicio, btnCatalogo;
    ImageView imgRandom;
    int gerar [] = {
            R.drawable.rambo1,
            R.drawable.rambo2,
            R.drawable.rambo3,
            R.drawable.rambo4,
            R.drawable.rambo5,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rambo);

        btnCatalogo = findViewById(R.id.btnRamboCatalogo);
        btnInicio = findViewById(R.id.btnRamboInicio);
        imgRandom = findViewById(R.id.imgRambo);

        int index = new Random().nextInt(gerar.length);
        imgRandom.setImageResource(gerar[index]);

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ri = new Intent(Rambo.this, MainActivity.class);
                startActivity(ri);
                finish();
            }
        });

        btnCatalogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rc = new Intent(Rambo.this, MainActivity2.class);
                startActivity(rc);
                finish();
            }
        });

    }
}