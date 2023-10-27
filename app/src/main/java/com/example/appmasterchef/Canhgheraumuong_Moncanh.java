package com.example.appmasterchef;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Canhgheraumuong_Moncanh extends AppCompatActivity {
    ImageView imgview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canhgheraumuong_moncanh);
        imgview  =(ImageView) findViewById(R.id.btnBack);
        imgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}