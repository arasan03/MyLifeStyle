package com.example.kalaiarasan.personalfitness;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class womanlunges extends AppCompatActivity {
    private static final long START_TIME_IN_MILLIS = 120000;

    private TextView mTextViewCountdown;
    private Button mButtonStartpause;
    private Button mbuttonReset;

    private CountDownTimer mCounterTimer;
    private boolean mTimerRunning;

    private long mTimeLeftinMills = START_TIME_IN_MILLIS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_womanlunges);
        mTextViewCountdown = findViewById(R.id.tvlunges);
        mbuttonReset = findViewById(R.id.resetlunges);
        mButtonStartpause = findViewById(R.id.startlunges);

        mButtonStartpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mTimerRunning) {
                    pauseTimer();
                }else{
                    startTimer();

                }
            }
        });
        mbuttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();

            }
        });
        updateCountDownText();
    }
    private void startTimer(){
        mCounterTimer = new CountDownTimer(mTimeLeftinMills, 0200) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftinMills = millisUntilFinished;
                updateCountDownText();

            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                mButtonStartpause.setText("Start");
                mButtonStartpause.setVisibility(View.INVISIBLE);
                mbuttonReset.setVisibility(View.VISIBLE);

            }
        }.start();
        mTimerRunning = true;
        mButtonStartpause.setText("pause");
        mbuttonReset.setVisibility(View.INVISIBLE);

    }


    private void pauseTimer(){
        mCounterTimer.cancel();
        mTimerRunning = false;
        mButtonStartpause.setText("Start");
        mbuttonReset.setVisibility(View.VISIBLE);
    }
    private void resetTimer(){
        mTimeLeftinMills = START_TIME_IN_MILLIS;
        updateCountDownText();
        mbuttonReset.setVisibility(View.INVISIBLE);
        mButtonStartpause.setVisibility(View.VISIBLE);
    }

    private void updateCountDownText(){
        int minutes = (int) (mTimeLeftinMills /1000) /60;
        int seconds = (int) (mTimeLeftinMills /1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);

        mTextViewCountdown.setText(timeLeftFormatted);





    }

}
