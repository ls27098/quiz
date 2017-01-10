package com.lasalle.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class StartQuizActivity extends AppCompatActivity {

    private String[][] pregunta = null;

    private int quinaPregunta = 0;
    private int correctes, incorrectes, respostaMarcada;

    private int[] respostesCorrectes = new int[] {2,4,1,2,3};

    private RadioGroup radioGroup;
    private TextView question, howManyQuestions, firstQuestion, secondQuestion, thirdQuestion, forthQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_quiz);
        initVars();

        question.setText(pregunta[quinaPregunta][0]);
        howManyQuestions.setText("Question "+Integer.toString(quinaPregunta + 1)+"/5");
        firstQuestion.setText(pregunta[quinaPregunta][1]);
        secondQuestion.setText(pregunta[quinaPregunta][2]);
        thirdQuestion.setText(pregunta[quinaPregunta][3]);
        forthQuestion.setText(pregunta[quinaPregunta][4]);


    }

    //Inicialitzem les variables
    private void initVars() {
        respostaMarcada = 0;
        correctes = 0;
        incorrectes = 0;
        question = (TextView) findViewById(R.id.question);
        howManyQuestions = (TextView) findViewById(R.id.howManyQuestions);
        firstQuestion = (TextView) findViewById(R.id.firstQuestion);
        secondQuestion = (TextView) findViewById(R.id.secondQuestion);
        thirdQuestion = (TextView) findViewById(R.id.thirdQuestion);
        forthQuestion = (TextView) findViewById(R.id.forthQuestion);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);

        pregunta = new String[][] {
                new String[] {
                        "The actor with the most individual nominations of all time?",
                        "George Clooney",
                        "Meryl Streep",
                        "Sarah Jessica Parker",
                        "Orlando Bloom"},
                new String[] {
                        "The star who holds the record of most Globes (including honorary awards)?",
                        "Meryl Streep",
                        "George Clooney",
                        "Brad Pitt",
                        "Barbra Streisand"},
                new String[] {
                        "The oldest person to ever win a Golden Globe?",
                        "Jessica Tandy",
                        "Barbra Streisand",
                        "Meryl Streep",
                        "George Clooney",},
                new String[] {
                        "Which is the home to the Golden Globes since 1961?",
                        "French Quarter Inn in Charleston, South Carolina",
                        "The Beverly Hilton Hotel in Los Angeles",
                        "The Oxford Hotel in Bend, Oregon",
                        "The Talbott Hotel in Chicago, Illinois"},
                new String[] {
                        "Films with the most Golden Globes on 2017?",
                        "Love Story",
                        "Network",
                        "La La Land",
                        "Arthur"},
        };
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.firstQuestion:
                if (checked) {
                    respostaMarcada = 1;
                }
                break;
            case R.id.secondQuestion:
                if (checked) {
                    respostaMarcada = 2;
                }
                break;
            case R.id.thirdQuestion:
                if (checked) {
                    respostaMarcada = 3;
                }
                break;
            case R.id.forthQuestion:
                if (checked) {
                    respostaMarcada = 4;
                }
                break;
        }
    }

    private void canviaPregunta() {
        quinaPregunta ++;
        question.setText(pregunta[quinaPregunta][0]);
        howManyQuestions.setText("Question "+Integer.toString(quinaPregunta + 1)+"/5");
        firstQuestion.setText(pregunta[quinaPregunta][1]);
        secondQuestion.setText(pregunta[quinaPregunta][2]);
        thirdQuestion.setText(pregunta[quinaPregunta][3]);
        forthQuestion.setText(pregunta[quinaPregunta][4]);
        radioGroup.clearCheck();

    }

    private void validaResposta() {
        //En cas que la resposta marcada sigui correcta, es sumarà com a resposta correcta
        if (respostaMarcada == respostesCorrectes[quinaPregunta]) {
            Toast.makeText(getApplicationContext(), "Resposta correcta!", Toast.LENGTH_SHORT).show();
            correctes ++;
        } else {
            Toast.makeText(getApplicationContext(), "Ups! Resposta incorrecta", Toast.LENGTH_SHORT).show();
            incorrectes ++;
        }

    }


    public void btn_submit (View v){
        if ((quinaPregunta + 1) == 5) {
            //Validem la resposta i enviem les dades a la nova activitat
            validaResposta();
            Intent i = new Intent(getApplicationContext(), ResultActivity.class);
            i.putExtra("CORRECTES",correctes);
            i.putExtra("INCORRECTES",incorrectes);
            startActivity(i);
            finish();
        }
        else {
            validaResposta();
            canviaPregunta();
        }
    }
}
