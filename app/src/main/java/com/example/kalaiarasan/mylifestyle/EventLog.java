package com.example.kalaiarasan.mylifestyle;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.text.method.ScrollingMovementMethod;

import android.view.View;

import android.view.View.OnClickListener;

import android.widget.Button;

import android.widget.TextView;

public class EventLog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_log);
        final DBHelper dbHelper = new DBHelper(getApplicationContext(), "LOG.db",null, 1);

        final TextView text_log = (TextView)findViewById(R.id.text_log);
        text_log.setMovementMethod(new ScrollingMovementMethod());


        Button start_log = (Button)findViewById(R.id.start_log);
        start_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            text_log.setText(dbHelper.getResult().toString());
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });

        Button clear_log = (Button)findViewById(R.id.clear_log);
        clear_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
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
        });

    }

    public class Exit {
    }
}
