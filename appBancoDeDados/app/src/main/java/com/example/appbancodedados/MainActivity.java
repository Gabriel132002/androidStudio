package com.example.appbancodedados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    //CRUD
    //Create - Read - Update - Delete

    ListView lst;
    Button btnCriar, btnLimpar, btnDeletar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}