package com.example.appavaliativo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class segundaTela extends AppCompatActivity {

    Button btninv, btnPPT, btncdSecreto, btnrand, btnvoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        btninv = findViewById(R.id.btn1Inversor);
        btnPPT = findViewById(R.id.btnPPT);
        btncdSecreto = findViewById(R.id.btncdSecreto);
        btnrand = findViewById(R.id.btnRandom);
        btnvoltar = findViewById(R.id.btnvoltar);


        btninv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(segundaTela.this, invPalavras.class);
                startActivity(i);
                finish();

            }
        });
        btnPPT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(segundaTela.this, Jokenpo.class);
                startActivity(i);
                finish();

            }
        });
        btncdSecreto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnrand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(segundaTela.this, randomizadorDePalavras.class);
                startActivity(i);
                finish();

            }
        });
        btnvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(segundaTela.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}