package com.example.aula2_layouts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //int valor;
    String txt;
    Button btn01, btn02;
    EditText ed1,ed2;
    TextView txtview;


    Random random = new Random();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn01 = findViewById(R.id.btn01);
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        btn02 = findViewById(R.id.btn2);
        txtview = findViewById(R.id.textView02);

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //valor = Integer.parseInt(ed1.getText().toString());
                //valor += Integer.parseInt((ed2.getText().toString()));
                //Toast.makeText(MainActivity.this, valor, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, SegundaAtividade.class); //Intent_serve_para_transição_de_tela_e_carregar_o_conceito_de_atividade_de_um_lugar_para_outro
                startActivity(i);
                finish();

            }
        });

        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt = String.valueOf(ed1.getText());
                txt += String.valueOf(ed2.getText());
                //Toast.makeText(MainActivity.this, "Resposta: "+txt, Toast.LENGTH_SHORT).show();
                txtview.setText(txt);
            }
        });
    }
}
