package com.example.appbancodedados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.appbancodedados.Controller.PokemonDataBase;
import com.example.appbancodedados.Module.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //CRUD
    //Create - Read - Update - Delete

    ListView pknLista;
    Button btnSalvar, btnLimpar, btnExcluir;
    EditText editcod, editNome, editTipo, editNumero;
    PokemonDataBase bdPokemon = new PokemonDataBase(this);
    ArrayAdapter <String> adapter;
    ArrayList <String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editcod = findViewById(R.id.edCodigo);
        editNome = findViewById(R.id.edNome);
        editNumero = findViewById(R.id.edNumero);
        editTipo = findViewById(R.id.edTipo);
        btnExcluir = findViewById(R.id.btnDeletar);
        btnSalvar = findViewById(R.id.btnCriar);
        btnLimpar = findViewById(R.id.btnLimpar);
        pknLista = findViewById(R.id.lista);

        listarPokemons();

        pknLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String clique = (String) pknLista.getItemAtPosition(i);
                String cod = clique.substring(0, clique.indexOf(" - "));
                Pokemon pkn = bdPokemon.selectPokemon(Integer.parseInt(cod));
                editcod.setText(String.valueOf(pkn.getCod()));
                editNome.setText(String.valueOf(pkn.getNome()));
                editNumero.setText(String.valueOf(pkn.getNumero()));
                editTipo.setText(String.valueOf(pkn.getTipo()));
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limparCampos();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cod = editcod.getText().toString();
                String nome = editNome.getText().toString();
                String tipo = editTipo.getText().toString();
                String numero = editNumero.getText().toString();

                if(nome.isEmpty()){
                    editNome.setError("Campo Obrigatório");
                }else{
                    if(cod.isEmpty()){
                        //insert
                        bdPokemon.addPokemon(new Pokemon(nome, tipo, numero));
                        Toast.makeText(MainActivity.this, "Inserido com sucesso", Toast.LENGTH_SHORT).show();
                        limparCampos();
                        listarPokemons();
                    }else{
                        //update
                        bdPokemon.updatePokemon(
                                new Pokemon(Integer.parseInt(cod), nome, tipo, numero)
                        );
                        Toast.makeText(MainActivity.this, "Atualizado com sucesso", Toast.LENGTH_SHORT).show();
                        limparCampos();
                        listarPokemons();
                    }
                }
            }
        });

        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cod = editcod.getText().toString();
                if(cod.isEmpty()){
                    Toast.makeText(MainActivity.this, "Impossível Deletar: Nada selecionado", Toast.LENGTH_SHORT).show();
                }else{
                    Pokemon pkn = new Pokemon();
                    pkn.setCod(Integer.parseInt(cod));
                    bdPokemon.excluirPokemon(pkn);
                    Toast.makeText(MainActivity.this, "Excluído com sucesso", Toast.LENGTH_SHORT).show();
                    limparCampos();
                    listarPokemons();
                }
            }
        });

    }
    private void limparCampos(){
        editcod.setText("");
        editTipo.setText("");
        editNumero.setText("");
        editNome.setText("");
        editNome.requestFocus();
    }

    private void listarPokemons() {
        List <Pokemon> pkn = bdPokemon.listarPokemons();
        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, arrayList);
        pknLista.setAdapter(adapter);
        for (Pokemon pkm: pkn) {
            arrayList.add(pkm.getCod() + " - " + pkm.getNome());
            adapter.notifyDataSetChanged();
        }

    }
}