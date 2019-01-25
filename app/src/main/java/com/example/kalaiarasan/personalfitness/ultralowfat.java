package com.example.kalaiarasan.personalfitness;

import android.content.Intent;

import android.net.Uri;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.view.View;

import android.view.View.OnClickListener;

import android.widget.TextView;


public class ultralowfat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultralowfat);

        ((TextView) findViewById(R.id.tvultra)).setOnClickListener(new OnClickListener() {

            public void onClick(View view) {

                ultralowfat.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.healthline.com/nutrition/is-ultra-low-fat-healthy")));

            }

        });

    }

}
