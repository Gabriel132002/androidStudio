package com.example.catalogodefilmes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ListView lstFilmes;
    EditText edtxtBusca;
    String busca;
    ArrayAdapter adapter;
    Button btnVoltar;
    Boolean aperta=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lstFilmes = findViewById(R.id.lstFilmes);
        edtxtBusca = findViewById(R.id.edtxtPesquisar);
        btnVoltar = findViewById(R.id.btnVoltarInicio);

        ArrayList<String> filmes = new ArrayList<>();
        filmes.add("O Exterminador do Futuro 2");
        filmes.add("Rocky Balboa");
        filmes.add("Até o Último Homem");
        filmes.add("O Grande Dragão Branco");
        filmes.add("Motoqueiro Fantasma");
        filmes.add("Homem-Aranha 2");
        filmes.add("O Homem de Aço");
        filmes.add("Sônic");
        filmes.add("Rambo");
        filmes.add("Karatê Kid");


        lstFilmes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            if (i==0){
                Intent ext = new Intent(MainActivity2.this, Tela3.class);
                startActivity(ext);
                finish();
            }
            if (i==1){
                Intent rb = new Intent(MainActivity2.this, TelaRocky.class);
                startActivity(rb);
                finish();
            }
            if (i==2){
                Intent ath = new Intent(MainActivity2.this, UltimoHomem.class);
                startActivity(ath);
                finish();
            }
            if (i==3){
                Intent db = new Intent(MainActivity2.this, DragaoBranco.class);
                startActivity(db);
                finish();
            }
            if (i==4){
                Intent mf = new Intent(MainActivity2.this, MotoqueiroFantasma.class);
                startActivity(mf);
                finish();
            }
            if (i==5){
                Intent spm = new Intent(MainActivity2.this, SpiderMan2.class);
                startActivity(spm);
                finish();
            }
            if (i==6){
                Intent supm = new Intent(MainActivity2.this, HomenDeAco.class);
                startActivity(supm);
                finish();
            }
            if (i==7){
                Intent sonic = new Intent(MainActivity2.this, Sonic.class);
                startActivity(sonic);
                finish();
            }
            if (i==8){
                    Intent rambo = new Intent(MainActivity2.this, Rambo.class);
                    startActivity(rambo);
                    finish();
                }
            if (i==9){
                Intent kid = new Intent(MainActivity2.this, KarateKid.class);
                kid.putExtra("kid", "kid teste1 teste2");
                startActivity(kid);
                finish();
            }

            }
        });

        adapter = new ArrayAdapter(MainActivity2.this, android.R.layout.simple_list_item_1, filmes);
        lstFilmes.setAdapter(adapter);

        edtxtBusca.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                (MainActivity2.this).adapter.getFilter().filter(charSequence);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}