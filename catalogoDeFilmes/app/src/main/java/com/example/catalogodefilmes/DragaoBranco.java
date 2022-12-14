package com.example.catalogodefilmes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class DragaoBranco extends AppCompatActivity {

    ImageView imgrandom;
    int gerar []={
        R.drawable.drgbrcvilao,
        R.drawable.vandammepose,
        R.drawable.drgbrcchute,
        R.drawable.drgbrctreino,
        R.drawable.drgbrcfinal,
    };
    int index;
    Button btnInicio, btnCatalogo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dragao_branco);

        imgrandom = findViewById(R.id.imageViewDgBranco);
        btnInicio = findViewById(R.id.btnDragaoBrancoVoltarCatalogo);
        btnCatalogo = findViewById(R.id.btnDragaoBrancoVoltarInicio);

        index = new Random().nextInt(gerar.length);
        imgrandom.setImageResource(gerar[index]);

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DragaoBranco.this, MainActivity2.class);
                startActivity(i);
                finish();
            }
        });

        btnCatalogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DragaoBranco.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}