package com.example.aula5_busca_e_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SegudaActivity extends AppCompatActivity {

    TextView nome, telefone;
    Button voltar;
    String n, tel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguda);

        nome = findViewById(R.id.texto_nome);
        telefone = findViewById(R.id.texto_telefone);
        voltar = findViewById(R.id.button);

        //recebendo dados
        Intent dadosrecebidos = getIntent();
        n="Nome: "+  dadosrecebidos.getStringExtra("nome");
        tel = dadosrecebidos.getStringExtra("telefone");
        nome.setText(n);
        telefone.setText("Telefone: "+tel);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SegudaActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}