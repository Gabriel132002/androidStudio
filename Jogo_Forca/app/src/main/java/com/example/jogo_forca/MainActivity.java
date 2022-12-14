package com.example.jogo_forca;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView txtTotalPerguntas;
    TextView txtPerguntas;
    Button btnA, btnB, btnC, btnD;
    Button enviar;

    int score=0;
    int totalQuestion = PerguntasResposta.perguntas.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTotalPerguntas = findViewById(R.id.totalQuestion);
        txtPerguntas = findViewById(R.id.question);
        btnA = findViewById(R.id.res_a);
        btnB = findViewById(R.id.res_b);
        btnC = findViewById(R.id.res_c);
        btnD = findViewById(R.id.res_d);
        enviar = findViewById(R.id.btn_enviar);

        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnD.setOnClickListener(this);
        enviar.setOnClickListener(this);

        txtTotalPerguntas.setText("Total Perguntas : "+totalQuestion);

        loadNewQuestion();

    }

    @Override
    public void onClick(View view) {

        btnA.setBackgroundColor(Color.WHITE);
        btnB.setBackgroundColor(Color.WHITE);
        btnC.setBackgroundColor(Color.WHITE);
        btnD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.btn_enviar){
            if(selectedAnswer.equals(PerguntasResposta.respostaCorretas[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();


        }else{
            //choices button clicked
            selectedAnswer  = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);

        }

    }

    void loadNewQuestion(){

        if(currentQuestionIndex == totalQuestion ){
            finishQuiz();
            return;
        }

        txtPerguntas.setText(PerguntasResposta.perguntas[currentQuestionIndex]);
        btnA.setText(PerguntasResposta.respostas[currentQuestionIndex][1]);
        btnB.setText(PerguntasResposta.respostas[currentQuestionIndex][0]);
        btnC.setText(PerguntasResposta.respostas[currentQuestionIndex][3]);
        btnD.setText(PerguntasResposta.respostas[currentQuestionIndex][2]);

    }

    void finishQuiz(){
        String passStatus = "";
        if(score > totalQuestion*0.60){
            passStatus = "Passed";
        }else{
            passStatus = "Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is "+ score+" out of "+ totalQuestion)
                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz() )
                .setCancelable(false)
                .show();


    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex =0;
        loadNewQuestion();
    }
}