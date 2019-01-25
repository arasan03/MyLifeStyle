package com.example.kalaiarasan.personalfitness;


import android.content.Intent;

import android.net.Uri;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.view.View;

import android.view.View.OnClickListener;

import android.widget.TextView;


public class Vegan extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_vegan);

        ((TextView) findViewById(R.id.tvvegan)).setOnClickListener(new OnClickListener() {

            public void onClick(View view) {

                Vegan.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.healthline.com/health/definitive-guide-to-being-vegan")));

            }

        });

    }

}