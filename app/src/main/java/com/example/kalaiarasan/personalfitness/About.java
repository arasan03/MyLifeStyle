package com.example.kalaiarasan.personalfitness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class About extends AppCompatActivity {
    Button q1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        q1=(Button)findViewById(R.id.button2);
        q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent w = new Intent(About.this,Contact.class);
                startActivity(w);
            }
        });
    }
}
