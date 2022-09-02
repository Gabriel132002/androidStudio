package com.example.aula04_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    Button btn01;
    EditText ed01;
    String texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.lista);
        btn01 = findViewById(R.id.btn01);
        ed01 = findViewById(R.id.ed01);


        ArrayList<String> nomes = new ArrayList<>();
        nomes.add("Goku");
        nomes.add("Vegeta");
        nomes.add("Bulma");
        nomes.add("Kuririn");
        nomes.add("Gohan");
        nomes.add("Piccollo");
        nomes.add("Trunks");

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, R.layout.lista_customizada, nomes);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(
                        MainActivity.this,
                        "Clicou em: "+nomes.get(i),
                        Toast.LENGTH_SHORT
                ).show();

            }
        });
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texto = ed01.getText().toString();

                if(!texto.isEmpty()) {//!<- negação "se o texto não está vazio"
                    nomes.add(texto);
                    adapter.notifyDataSetChanged();
                    lista.setAdapter(adapter);
                    ed01.setText("");

                    Toast.makeText(
                            MainActivity.this,
                            "Nome "+texto+" foi adicionado",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });

    }
}