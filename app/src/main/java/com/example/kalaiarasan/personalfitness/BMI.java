package com.example.kalaiarasan.personalfitness;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BMI extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        final DBHelper dbHelper = new DBHelper(getApplicationContext(), "LOG.db",null, 1);

        final TextView text_log = (TextView)findViewById(R.id.text_log);

        e1= (EditText)findViewById(R.id.etheight);
        e2= (EditText)findViewById(R.id.etweight);
        b1=(Button)findViewById(R.id.btncalculate);
        t1=(TextView)findViewById(R.id.tvresult);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMI();
                ////DATABASE INPUT
                long now = System.currentTimeMillis();
                Date date1 = new Date(now);
                SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

                String date = sdfNow.format(date1).toString();
                String bmi = t1.getText().toString();
                String information = "";

                dbHelper.insert(bmi, information, date);
            }
        });
    }
    private void calculateBMI(){
        String heightStr = e1.getText().toString();
        String weightStr = e2.getText().toString();

        if(heightStr !=null && !"".equals(heightStr) && weightStr !=null && !"".equals(weightStr)){
            float heightValue = Float.parseFloat(heightStr) /100;
            float  weightValue = Float.parseFloat(weightStr);

            float bmi = weightValue / (heightValue * heightValue);

            displayBMI(bmi);

        }
    }

    private void displayBMI(float bmi){
        String bmiLabel ="";

        if(Float.compare(bmi, 15f) <=0){
            bmiLabel = "very severely underweight";
        } else if (Float.compare(bmi, 15f) >0 && Float.compare(bmi, 16f) <=0){
            bmiLabel = "severely underweight";
        } else if (Float.compare(bmi, 16f) >0 && Float.compare(bmi, 18.5f) <=0) {
            bmiLabel = "underweight";
        } else if (Float.compare(bmi, 18.5f) >0 && Float.compare (bmi, 25f) <=0){
            bmiLabel = "normal";
        } else if (Float.compare(bmi, 25f) >0 && Float.compare (bmi, 30f) <=0){
            bmiLabel = "overweight";
        } else if (Float.compare(bmi, 30f) >0 && Float.compare (bmi, 35f) <=0){
            bmiLabel = "obese class I";
        } else if (Float.compare(bmi, 35f) >0 && Float.compare (bmi, 40f) <=0) {
            bmiLabel = "obese class II";
        }else{
            bmiLabel = "obese class III";
        }
        bmiLabel = bmi + "\n" + bmiLabel;
        t1.setText(bmiLabel);
        //common.getInstance().m_log = bmiLabel;
    }
}