package com.example.kalaiarasan.personalfitness;

import android.content.Intent;

import android.net.Uri;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.view.View;

import android.view.View.OnClickListener;

import android.widget.TextView;

public class Intermittentfasting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermittentfasting);

        ((TextView) findViewById(R.id.tvintermittent)).setOnClickListener(new OnClickListener() {

            public void onClick(View view) {

                Intermittentfasting.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.healthline.com/nutrition/intermittent-fasting-guide")));

            }

        });

    }
}
