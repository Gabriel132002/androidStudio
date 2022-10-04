package com.example.appavaliativo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class invPalavras extends AppCompatActivity {

    Button btnVoltar, btnInverter;
    EditText edtxt;
    TextView txtview;
    String texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inv_palavras);

        btnVoltar = findViewById(R.id.btnInvVoltar);
        edtxt = findViewById(R.id.editTxtInv);
        btnInverter = findViewById(R.id.btnInverter);
        txtview = findViewById(R.id.txtResultInverter);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(invPalavras.this, segundaTela.class);
                startActivity(i);
                finish();
            }
        });

        btnInverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texto = edtxt.getText().toString();
                texto = new StringBuilder(texto).reverse().toString();
                txtview.setText(texto);
            }
        });
    }
}