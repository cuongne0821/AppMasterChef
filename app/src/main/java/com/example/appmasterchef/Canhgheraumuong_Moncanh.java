package com.example.appmasterchef;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Canhgheraumuong_Moncanh extends AppCompatActivity {
    ImageView imghd,btnback;
    TextView tvNl, tvHd,tvName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canhgheraumuong_moncanh);



        imghd  =(ImageView) findViewById(R.id.imgHD);
        tvNl=(TextView) findViewById(R.id.tvNL);
        tvHd=(TextView) findViewById(R.id.tvHD);
        tvName=(TextView) findViewById(R.id.textViewct) ;
        btnback=(ImageView) findViewById(R.id.btnBack);


        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("dulieu");
        if(bundle!=null){
            String Name=bundle.getString("ten");
            String HD=bundle.getString("huongdan");
            String image=bundle.getString("hinh");
            String NL=bundle.getString("nguyenlieu");

            Glide.with(imghd.getContext()).load(image).into(imghd);
            tvNl.setText(NL);
            tvName.setText(Name);
            tvHd.setText(HD);
        }
    }
}