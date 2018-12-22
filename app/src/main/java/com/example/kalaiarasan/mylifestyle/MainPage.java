package com.example.kalaiarasan.mylifestyle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
public class MainPage extends AppCompatActivity {
    ImageButton q1,q2,q3,q4;
    Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        final DBHelper dbHelper = new DBHelper(getApplicationContext(), "LOG.db",null, 1);

        setContentView(R.layout.activity_main_page);
        q1=(ImageButton)findViewById(R.id.imgman);
        q2=(ImageButton)findViewById(R.id.imgwoman);
        q3=(ImageButton)findViewById(R.id.imgbmi);
        q4=(ImageButton)findViewById(R.id.imgdietplan);
        b1=(Button)findViewById(R.id.btnabout);
        b2=(Button)findViewById(R.id.btnevent);
        b3=(Button)findViewById(R.id.btnlogout);

        TextView t1=(TextView)findViewById(R.id.tvresult);
        final BMI bmi1 = new BMI();

        q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            long now = System.currentTimeMillis();
                            Date date1 = new Date(now);
                            SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                            String date = sdfNow.format(date1).toString();
                            String bmi = "";
                            String information = "Excercise For Man";
                            dbHelper.insert(bmi, information, date);
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

                Intent q = new Intent(MainPage.this,ExerciseForMan.class);
                startActivity(q);

            }
        });

        q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            long now = System.currentTimeMillis();
                            Date date1 = new Date(now);
                            SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                            String date = sdfNow.format(date1).toString();
                            String bmi = "";
                            String information = "Excercise For Woman";
                            dbHelper.insert(bmi, information, date);
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

                Intent r = new Intent(MainPage.this,ExerciseForWoman.class);
                startActivity(r);
            }
        });


        q3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            long now = System.currentTimeMillis();
                            Date date1 = new Date(now);
                            SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                            String date = sdfNow.format(date1).toString();
                            String bmi = "";
                            String information = "BMI";
                            dbHelper.insert(bmi, information, date);
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

                Intent i = new Intent(MainPage.this,BMI.class);
                startActivity(i);
            }
        });

        q4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            long now = System.currentTimeMillis();
                            Date date1 = new Date(now);
                            SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                            String date = sdfNow.format(date1).toString();
                            String bmi = "";
                            String information = "Meal Plans";
                            dbHelper.insert(bmi, information, date);
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

                Intent l = new Intent(MainPage.this,Dietplan.class);
                startActivity(l);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent w = new Intent(MainPage.this,About.class);
                startActivity(w);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent z = new Intent(MainPage.this,EventLog.class);
                startActivity(z);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent p = new Intent(MainPage.this,Login.class);
                startActivity(p);
            }
        });
    }
}