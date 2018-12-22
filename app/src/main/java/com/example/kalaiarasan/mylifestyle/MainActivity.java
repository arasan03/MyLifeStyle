package com.example.kalaiarasan.mylifestyle;



import android.content.Intent;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.view.View;

import android.view.View.OnClickListener;

import android.widget.Button;

import android.widget.EditText;

import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button b1;

    Button b2;

    EditText e1;

    EditText e2;

    EditText e3;

    DatabaseHelper sqLiteDatabase;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final DBHelper dbHelper = new DBHelper(getApplicationContext(), "LOG.db", null, 1);

        this.sqLiteDatabase = new DatabaseHelper(getApplicationContext(), "mylife.db", this, 1);

        this.e1 = (EditText) findViewById(R.id.etEmail);

        this.e2 = (EditText) findViewById(R.id.etPassword);

        this.e3 = (EditText) findViewById(R.id.etCPassword);

        this.b1 = (Button) findViewById(R.id.btnregister);

        this.b2 = (Button) findViewById(R.id.btn2);

        this.b2.setOnClickListener(new OnClickListener() {

            public void onClick(View view) {

                MainActivity.this.startActivity(new Intent(MainActivity.this, Login.class));

            }

        });

        this.b1.setOnClickListener(new OnClickListener() {

            public void onClick(View view) {

                String s1 = MainActivity.this.e1.getText().toString();

                String s2 = MainActivity.this.e2.getText().toString();

                String s3 = MainActivity.this.e3.getText().toString();

                if (!(s1.equals(BuildConfig.FLAVOR) || s2.equals(BuildConfig.FLAVOR))) {

                    if (!s3.equals(BuildConfig.FLAVOR)) {

                        if (!s2.equals(s3)) {

                            Toast.makeText(MainActivity.this.getApplicationContext(), "password do no match", 0).show();

                        } else if (!MainActivity.this.sqLiteDatabase.chkemail(s1).booleanValue()) {

                            Toast.makeText(MainActivity.this.getApplicationContext(), "Email already exists", 0).show();

                        } else if (MainActivity.this.sqLiteDatabase.insert(s1, s2).booleanValue()) {

                            Toast.makeText(MainActivity.this.getApplicationContext(), "registration successfully", 0).show();

                        }

                        new Thread(new Runnable() {

                            public void run() {

                                try {

                                    dbHelper.delete();

                                    Thread.sleep(4000);

                                } catch (InterruptedException e) {

                                    e.printStackTrace();

                                }

                            }

                        }).start();

                    }

                }

            }

        });

    }

}