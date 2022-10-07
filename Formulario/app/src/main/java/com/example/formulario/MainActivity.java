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

        Calendar c = Calendar.getInstance();
        int dia = c.get(Calendar.DAY_OF_MONTH);
        int mes = c.get(Calendar.MONTH);
        int ano = c.get(Calendar.YEAR);



//        private void nascimento () {
//            Calendar c = Calendar.getInstance();
//            int dia = c.get(Calendar.DAY_OF_MONTH);
//            int mes = c.get(Calendar.MONTH);
//            int ano = c.get(Calendar.YEAR);
//
//            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
//                @Override
//                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
//                    edNascimento.setText(i+"/"+(i1+1)+"/"+i2);
//                }
//            }, ano, mes, dia);
//            datePickerDialog.show();
//        }

    }
}