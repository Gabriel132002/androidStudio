package com.example.aula2_layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class SegundaAtividade extends AppCompatActivity {

    Button button001, button002;
    TextView txtv;
    int numero;

    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primeirolayout);
        button001 = findViewById(R.id.button001);
        button002 = findViewById(R.id.button002);
        txtv = findViewById(R.id.textView01);

        button001.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero = random.nextInt(101);
                txtv.setText("Número aletório: "+numero);
            }
        });

        button002.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (SegundaAtividade.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}