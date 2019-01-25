package com.example.kalaiarasan.personalfitness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExerciseForMan extends AppCompatActivity {
    Button q1,q2,q3,q4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_for_man);
        q1 = (Button)findViewById(R.id.btnpushup);
        q2 = (Button)findViewById(R.id.btnsitup);
        q3 = (Button)findViewById(R.id.btnflutter);
        q4 = (Button)findViewById(R.id.btnplank);

        q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ExerciseForMan.this,PushUp.class);
                startActivity(i);
            }
        });
        q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n = new Intent(ExerciseForMan.this,SitUp.class);
                startActivity(n);
            }
        });

        q3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p = new Intent(ExerciseForMan.this,FlutterKick.class);
                startActivity(p);
            }
        });
        q4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m = new Intent(ExerciseForMan.this,Plank.class);
                startActivity(m);
            }
        });



    }
}

