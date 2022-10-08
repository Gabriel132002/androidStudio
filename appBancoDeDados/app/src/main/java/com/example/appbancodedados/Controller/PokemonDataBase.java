package com.example.appbancodedados.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appbancodedados.Module.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class PokemonDataBase extends SQLiteOpenHelper {

    private static final int versao = 1;
    private static final String nomeDB = "BD_Pokemon";
    private static final String c_cod = "cod";
    private static final String c_nome = "nome";
    private static final String c_tipo = "tipo";
    private static final String c_numero = "numero";
    private static final String tb_pokemon = "pokedex";
    public static Context contexto;

    public PokemonDataBase(@Nullable Context context) {
        super(context, nomeDB, null, versao);
        contexto = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //CREATE TABLE pokemon (cod INTEGER PRIMARY_KEY, ...)
        String query = "CREATE TABLE " + tb_pokemon + "(" +
                c_cod + " INTEGER PRIMARY KEY, " +
                c_nome + " TEXT, " +
                c_tipo + " TEXT, " +
                c_numero + " TEXT)";

        sqLiteDatabase.execSQL(query);
    }

    public Pokemon selectPokemon(int cod){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(tb_pokemon, new String[]{
                c_cod, c_nome, c_tipo, c_numero
        }, c_cod + " = ?", new String[]{String.valueOf(cod)},
           null, null, null );

        if(cursor != null){
            cursor.moveToFirst();
        }else{
            return null;
        }
        Pokemon pkn = new Pokemon(Integer.parseInt(
                cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3));
        return pkn;
    }

    public void addPokemon (Pokemon pkn){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(c_nome, pkn.getNome());
        values.put(c_numero, pkn.getNumero());
        values.put(c_tipo, pkn.getTipo());

        db.insert(tb_pokemon, null, values);
        db.close();
    }

    public void excluirPokemon (Pokemon pkn){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_pokemon, c_cod+" = ?", new String[]{String.valueOf(pkn.getCod())});
        db.close();
    }

    public List <Pokemon> listarPokemons(){
        SQLiteDatabase db = this.getReadableDatabase();
        List <Pokemon> pknLista = new ArrayList<>();

        String query = "SELECT * FROM "+tb_pokemon;
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do {
                Pokemon pkn = new Pokemon();
                pkn.setCod(Integer.parseInt(cursor.getString(0)));
                pkn.setNome(cursor.getString(1));
                pkn.setTipo(cursor.getString(2));
                pkn.setNumero(cursor.getString(3));
                pknLista.add(pkn);
            }while (cursor.moveToNext());
        }

        return pknLista;
    }

    public void updatePokemon(Pokemon pkn){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(c_nome, pkn.getNome());
        values.put(c_numero, pkn.getNumero());
        values.put(c_tipo, pkn.getTipo());
        db.update(tb_pokemon, values, c_cod + " = ?", new String[]{String.valueOf(pkn.getCod())});
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
