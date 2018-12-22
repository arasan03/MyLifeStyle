package com.example.kalaiarasan.mylifestyle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dietplan extends AppCompatActivity {
    Button a1,a2,a3,a4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietplan);

        this.a1 = (Button)this.findViewById(R.id.btnVegan);
        this.a2 = (Button)this.findViewById(R.id.btnLowCarb);
        this.a3 = (Button)this.findViewById(R.id.btnLowFat);
        this.a4 = (Button)this.findViewById(R.id.btnFasting);

        this.a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dietplan.this,Vegan.class);
                Dietplan.this.startActivity(intent);

            }
        });

        this.a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dietplan.this,Lowcarb.class);
                Dietplan.this.startActivity(intent);
            }
        });

        this.a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dietplan.this,ultralowfat.class);
                Dietplan.this.startActivity(intent);
            }
        });

        this.a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dietplan.this,Intermittentfasting.class);
                Dietplan.this.startActivity(intent);
            }
        });
    }
}
