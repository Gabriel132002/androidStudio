package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText edNome, edCpf, edTelefone, edEmail;
    TextView edNascimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNome = findViewById(R.id.ednome);
        edCpf = findViewById(R.id.edcpf);
        edTelefone = findViewById(R.id.edtelefone);
        edNascimento = findViewById(R.id.ednascimento);
        edEmail = findViewById(R.id.edemail);

        edNascimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}