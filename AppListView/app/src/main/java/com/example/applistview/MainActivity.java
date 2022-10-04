package com.example.applistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.viewmodel.CreationExtras;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {

    Button btnC, btnD, btnM, btninc;
    ListView lv;
    EditText ed1;
    String texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnC = findViewById(R.id.btn1);
        btnD = findViewById(R.id.btn2);
        btnM = findViewById(R.id.btn3);
        btninc = findViewById(R.id.btn_incluir);
        lv = findViewById(R.id.lstv);
        ed1 = findViewById(R.id.ed1);

        ArrayList<String> nome = new ArrayList<>();
        nome.add("Thomas");
        nome.add("Arthur");
        nome.add("John");
        nome.add("Finn");

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, R.layout.customlist, nome);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Clicou em "+nome.get(i), Toast.LENGTH_SHORT).show();
            }
        });

        btninc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texto = ed1.getText().toString();
                if(!texto.isEmpty()){
                    nome.add(texto);
                    adapter.notifyDataSetChanged();
                    lv.setAdapter(adapter);
                    ed1.setText("");

                    Toast.makeText(MainActivity.this, texto+" foi adicionado", Toast.LENGTH_SHORT).show();
                }

            }
        });

            btnM.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Collections.shuffle(nome);
                    lv.setAdapter(adapter);
                    Toast.makeText(MainActivity.this, "Lista embaralhada", Toast.LENGTH_SHORT).show();
                }
            });

            btnC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Collections.sort(nome);
                    lv.setAdapter(adapter);
                    Toast.makeText(MainActivity.this, "Ordem crescente", Toast.LENGTH_SHORT).show();
                }
            });

            btnD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Collections.sort(nome, Collections.reverseOrder());
                    lv.setAdapter(adapter);
                    Toast.makeText(MainActivity.this, "Ordem decrescente", Toast.LENGTH_SHORT).show();
                }
            });
    }
}