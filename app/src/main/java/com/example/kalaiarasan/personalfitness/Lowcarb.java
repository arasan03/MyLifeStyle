package com.example.kalaiarasan.personalfitness;


import android.content.Intent;

import android.net.Uri;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.view.View;

import android.view.View.OnClickListener;

import android.widget.TextView;

public class Lowcarb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lowcarb);

        ((TextView) findViewById(R.id.tvlowcarb)).setOnClickListener(new OnClickListener() {

            public void onClick(View view) {

                Lowcarb.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.healthline.com/nutrition/low-carb-diet-meal-plan-and-menu")));

            }

        });

    }

}
