package com.example.catalogodefilmes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgTerminator, imgRocky, imgUltimo, imgDragao, imgMotoqueiro;
    Button btnCatalogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgTerminator = findViewById(R.id.imageViewTerminator2);
        imgRocky = findViewById(R.id.imageViewRockyBalboa);
        imgUltimo = findViewById(R.id.imageUltimoHomem);
        imgDragao = findViewById(R.id.imageViewDragaoBranco);
        imgMotoqueiro = findViewById(R.id.imageViewMotoqueiroFantasma);
        btnCatalogo = findViewById(R.id.btnAcessarCatalogo);

        imgTerminator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t = new Intent(MainActivity.this, Tela3.class);
                startActivity(t);
                finish();
            }
        });

        imgRocky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent r = new Intent(MainActivity.this, TelaRocky.class);
                startActivity(r);
                finish();
            }
        });

        imgUltimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent u = new Intent(MainActivity.this, UltimoHomem.class);
                startActivity(u);
                finish();
            }
        });

        imgDragao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d = new Intent(MainActivity.this, DragaoBranco.class);
                startActivity(d);
                finish();
            }
        });

        imgMotoqueiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m = new Intent(MainActivity.this, MotoqueiroFantasma.class);
                startActivity(m);
                finish();
            }
        });

        btnCatalogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(b);
                finish();
            }
        });

    }
}