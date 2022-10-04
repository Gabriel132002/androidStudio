package com.example.appavaliativo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class randomizadorDePalavras extends AppCompatActivity {

    TextView txtMostrarNome;
    Button btnRandVoltar, btnSortear, btnInc;
    ListView lstNomes;
    EditText edTxtNome;
    String nome, texto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randomizador_de_palavras);

        txtMostrarNome = findViewById(R.id.txtMostrarNomeSorteado);
        btnRandVoltar = findViewById(R.id.btnrandVoltar);
        btnSortear = findViewById(R.id.btnGerarNome);
        lstNomes = findViewById(R.id.lstNomes);
        edTxtNome = findViewById(R.id.edTxtNome);
        btnInc = findViewById(R.id.btnAdicionar);

        Random random = new Random();

        ArrayList<String> nome = new ArrayList<>();

        ArrayAdapter adapter = new ArrayAdapter(randomizadorDePalavras.this, R.layout.customlist, nome);
        lstNomes.setAdapter(adapter);

        btnRandVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(randomizadorDePalavras.this, segundaTela.class);
                startActivity(i);
                finish();
            }
        });

        btnSortear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0; i<nome.size(); i++){
                    int mostar = random.nextInt(nome.size());
                    txtMostrarNome.setText(nome.get(mostar));
                }

            }
        });

        btnInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texto = edTxtNome.getText().toString();
                if(!texto.isEmpty()){
                    nome.add(texto);
                    adapter.notifyDataSetChanged();
                    lstNomes.setAdapter(adapter);
                    edTxtNome.setText("");

//                    Toast.makeText(randomizadorDePalavras.this, texto, Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}