package com.example.jogo_dos_botoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int qnt=0;
    TextView txtMostrar;
    Button btn[] = new Button[64];
    int nomebtn [] = {R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6,
                      R.id.btn7, R.id.btn8, R.id.btn9, R.id.btn10, R.id.btn11, R.id.btn12,
                      R.id.btn13, R.id.btn14, R.id.btn15, R.id.btn16, R.id.btn16, R.id.btn17,
                      R.id.btn18, R.id.btn19, R.id.btn20, R.id.btn21, R.id.btn22, R.id.btn23,
                      R.id.btn24, R.id.btn25, R.id.btn26, R.id.btn27, R.id.btn28, R.id.btn29, R.id.btn30,
                      R.id.btn31, R.id.btn32, R.id.btn33, R.id.btn34, R.id.btn35, R.id.btn36,
                      R.id.btn37, R.id.btn38, R.id.btn39, R.id.btn40, R.id.btn41, R.id.btn42,
                      R.id.btn43, R.id.btn44, R.id.btn45, R.id.btn46, R.id.btn47, R.id.btn48,
                      R.id.btn49, R.id.btn50, R.id.btn51, R.id.btn52, R.id.btn53, R.id.btn54,
                      R.id.btn55, R.id.btn56, R.id.btn57, R.id.btn57, R.id.btn58, R.id.btn59,
                      R.id.btn60, R.id.btn61, R.id.btn62, R.id.btn63, R.id.btn64};
    int v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random random = new Random();

        v = random.nextInt(64);

        txtMostrar = findViewById(R.id.txtmostrar);

        for(int valor=0; valor<64; valor++){
            btn[valor] = findViewById(nomebtn[valor]);

            int Valor = valor;
            btn[valor].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    qnt++;
                    txtMostrar.setText("Número de tentativas "+qnt);

                    if(Valor==v){
                        Intent i = new Intent(MainActivity.this, Tela2.class);
                        i.putExtra("quantidade", qnt);
                        startActivity(i);
                        finish();

                    }
                }
            });
        }

    }
}

/*





 */