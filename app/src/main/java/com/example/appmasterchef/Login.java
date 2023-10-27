package com.example.appmasterchef;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    TextView dangky;
    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        dangky= findViewById(R.id.dangky);

        btn=(Button) findViewById(R.id.login1);
        tv=(TextView) findViewById(R.id.dangky);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Myintent = new Intent(Login.this, MainActivity.class);
                startActivity(Myintent);
                finish();
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(Login.this, register.class);
                startActivity(myintent);
            }
        });
    }
}
