package com.lasalle.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {

    private TextView correctes, incorrectes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        correctes = (TextView)findViewById(R.id.correctes);
        incorrectes = (TextView)findViewById(R.id.incorrectes);

        //Obtenim les respostes correctes i incorrectes i les mostrem per pantalla
        correctes.setText(Integer.toString(getIntent().getIntExtra("CORRECTES", 0)));
        incorrectes.setText(Integer.toString(getIntent().getIntExtra("INCORRECTES", 0)));
    }

    public void btn_submit(View v){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }
}
