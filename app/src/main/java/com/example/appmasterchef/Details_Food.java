package com.example.appmasterchef;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Details_Food extends AppCompatActivity {
    ImageView imghd,btnback;
    TextView tvNl, tvHd,tvName;
    ToggleButton imgbtn;
    private DatabaseReference databaseRef;

    private boolean isFavorite = false; // Thêm biến để theo dõi trạng thái yêu thích

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailfood_activity);





        imghd  =(ImageView) findViewById(R.id.imgHD);
        imghd  =(ImageView) findViewById(R.id.imgHD);
        tvNl=(TextView) findViewById(R.id.tvNL);
        tvHd=(TextView) findViewById(R.id.tvHD);
        tvName=(TextView) findViewById(R.id.textViewct) ;
        btnback=(ImageView) findViewById(R.id.btnBack);

        imgbtn=(ToggleButton) findViewById(R.id.btnLove);



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

            imgbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked && !isFavorite) {


                            // Kiểm tra xem dữ liệu yêu thích đã tồn tại hay chưa
                            DatabaseReference favoritesRef = FirebaseDatabase.getInstance().getReference().child("Favorites");
                            favoritesRef.orderByChild("Name").equalTo(Name).addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    if (dataSnapshot.exists()) {
                                        // Dữ liệu yêu thích đã tồn tại

                                    } else {
                                        // Dữ liệu yêu thích không tồn tại
                                        databaseRef = favoritesRef.push();

                                        // Thêm dữ liệu yêu thích
                                        databaseRef.child("Name").setValue(Name);
                                        databaseRef.child("HD").setValue(HD);
                                        databaseRef.child("Image").setValue(image);
                                        databaseRef.child("Nguyenlieu").setValue(NL);



                                        imgbtn.setBackgroundResource(R.drawable.loveon);

                                         // Đánh dấu là đã yêu thích

                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                    // Xử lý lỗi nếu cần
                                }
                            });

                        isFavorite = true;

                    } else{



                        imgbtn.setBackgroundResource(R.drawable.love);

                        isFavorite = false; // Đánh dấu là không yêu thích
                    }
                }




            });


        }


    }

}