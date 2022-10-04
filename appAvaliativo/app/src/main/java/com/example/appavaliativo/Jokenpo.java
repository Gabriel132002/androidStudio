package com.example.appavaliativo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Jokenpo extends AppCompatActivity {

    Button btnVoltar;
    ImageView imgPedra, imgPapel, imgTesoura, imgSystem;
    TextView txtResultado;

    Integer [] images = {
            R.drawable.papel,
            R.drawable.pedra,
            R.drawable.tesoura,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokenpo);

        btnVoltar = findViewById(R.id.btnPPTVoltar);
        imgPapel = findViewById(R.id.imageViewPapel);
        imgPedra = findViewById(R.id.imageViewPedra);
        imgTesoura = findViewById(R.id.imageViewTesoura);
        imgSystem = findViewById(R.id.imageViewPadrao);
        txtResultado = findViewById(R.id.txtResultadoJokenpo);

        Random random = new Random();

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Jokenpo.this, segundaTela.class);
                startActivity(i);
                finish();
            }
        });

        imgPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgSystem.setImageResource(images[random.nextInt(images.length)]);
            }
        });

        imgPedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgSystem.setImageResource(images[random.nextInt(images.length)]);
            }
        });

        imgTesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgSystem.setImageResource(images[random.nextInt(images.length)]);
            }
        });

    }
}