package com.example.kalaiarasan.personalfitness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExerciseForWoman extends AppCompatActivity {
    Button q1,q2,q3,q4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_for_woman);
        q1 = (Button)findViewById(R.id.womanpushup);
        q2 = (Button)findViewById(R.id.womancrunches);
        q3 = (Button)findViewById(R.id.womanlunges);
        q4 = (Button)findViewById(R.id.womanplank);

        q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ExerciseForWoman.this,womanpushup.class);
                startActivity(i);
            }
        });
        q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n = new Intent(ExerciseForWoman.this,womancrunches.class);
                startActivity(n);
            }
        });

        q3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p = new Intent(ExerciseForWoman.this,womanlunges.class);
                startActivity(p);
            }
        });
        q4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m = new Intent(ExerciseForWoman.this,womanplanks.class);
                startActivity(m);
            }
        });



    }
}




