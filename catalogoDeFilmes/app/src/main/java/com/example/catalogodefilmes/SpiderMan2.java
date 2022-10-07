
package com.example.catalogodefilmes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class SpiderMan2 extends AppCompatActivity {

    Button btnInicio, btnCatalogo;
    int gerar[]={
            R.drawable.bancoluta,
            R.drawable.cenaepica,
            R.drawable.peterbeco,
            R.drawable.trainluta,
            R.drawable.trainoctopus,
    };
    ImageView imgrandom;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spider_man2);

        btnInicio = findViewById(R.id.btnSpiderinicio);
        btnCatalogo = findViewById(R.id.btnSpiderCatalogo);
        imgrandom = findViewById(R.id.imgSpider);

        int index = new Random().nextInt(gerar.length);
        imgrandom.setImageResource(gerar[index]);

        btnCatalogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SpiderMan2.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SpiderMan2.this, MainActivity2.class);
                startActivity(i);
                finish();
            }
        });

    }
}