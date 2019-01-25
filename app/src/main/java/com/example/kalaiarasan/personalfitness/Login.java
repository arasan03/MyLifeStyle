package com.example.kalaiarasan.personalfitness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    DatabaseHelper sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sqLiteDatabase = new DatabaseHelper(getApplicationContext(), "mylife.db", this, 1);
        e1 =(EditText)findViewById(R.id.editText);
        e2 =(EditText)findViewById(R.id.editText2);
        b1 =(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = e1.getText().toString();
                String password = e2.getText().toString();
                Boolean Chkmailpass = sqLiteDatabase.emailpassword(email, password);

                Intent z = new Intent(Login.this,MainPage.class);

                if (Chkmailpass==true) {
                    Toast.makeText(getApplicationContext(), "Sucessfully login", Toast.LENGTH_SHORT).show();
                    startActivity(z);
                }else
                    Toast.makeText(getApplicationContext(),"wrong email or password",Toast.LENGTH_SHORT).show();

            }
        });

    }
}