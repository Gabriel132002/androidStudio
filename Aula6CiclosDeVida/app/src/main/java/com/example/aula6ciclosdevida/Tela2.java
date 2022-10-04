package com.example.aula6ciclosdevida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tela2 extends AppCompatActivity {

    Button btnTela2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        btnTela2 = findViewById(R.id.btnTela2);

        btnTela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Tela2.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}