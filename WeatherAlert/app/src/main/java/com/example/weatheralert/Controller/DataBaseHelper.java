package com.example.weatheralert.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.weatheralert.Model.Weather;

import java.sql.SQLInput;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final int version = 1;
    public static final String nameDB = "weather_db";
    public static Context contexto;
    public static final String tb_weather = "tb_weather";
    public static final String c_cod = "cod";
    public static final String c_weather = "weather";

    public DataBaseHelper(@Nullable Context context) {
        super(context, nameDB, null, version);
        contexto = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //CREATE TABLE weather
        String query = "CREATE TABLE " + tb_weather + "(" +
                c_cod + " INTEGER PRIMARY KEY, " +
                c_weather + " TEXT)";
        sqLiteDatabase.execSQL(query);
    }

    public Weather sellectWeather(int cod) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(tb_weather, new String[]{
                        c_cod, c_weather
                }, c_cod + " = ?", new String[]{String.valueOf(cod)},
                null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        } else {
            return null;
        }
        Weather wt = new Weather(Integer.parseInt(
                cursor.getString(0)),
                cursor.getString(1));
        return wt;
    }

    public void addWeather(Weather wt) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(c_weather, wt.getWeather());

        db.insert(tb_weather, null, values);
        db.close();
    }

//    public void deleteWeather(Weather wt) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        db.delete(tb_weather, c_cod + " = ?", new String[]{String.valueOf(wt.getCod())});
//        db.close();
//    }

    public List<Weather> listWeather() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Weather> wtlist = new ArrayList<>();

        String query = " SELECT * FROM " + tb_weather;
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                Weather wt = new Weather();
                wt.setCod(Integer.parseInt(cursor.getString(0)));
                wt.setWeather(Integer.parseInt(cursor.getString(1)));
                wtlist.add(wt);
            } while (cursor.moveToNext());
        }
        return wtlist;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
