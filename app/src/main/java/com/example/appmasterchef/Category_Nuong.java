package com.example.appmasterchef;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Category_Nuong extends AppCompatActivity {
    RecyclerView rcv;
    My_Adapter mainAdapter;
    ImageView btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_category);
        rcv=(RecyclerView) findViewById(R.id.recycler_view);
        rcv.setLayoutManager(new GridLayoutManager(this, 2));

        FirebaseRecyclerOptions<Mydata> options =
                new FirebaseRecyclerOptions.Builder<Mydata>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Food").orderByChild("Danhmuc").equalTo("Món nướng"), Mydata.class)
                        .build();

        mainAdapter=new My_Adapter(options);
        mainAdapter.setOnItemClickListener(new My_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(Mydata data) {
                Category_Nuong.this.onItemClick(data);
            }
        });
        rcv.setAdapter(mainAdapter);


        btnBack=(ImageView) findViewById(R.id.back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void onItemClick(Mydata data) {
        // Chuyển sang trang mới khi mục được nhấn vào
        Intent intent = new Intent(Category_Nuong.this, Canhgheraumuong_Moncanh.class);
        Bundle bd=new Bundle();
        bd.putString("ten",data.getName());
        bd.putString("huongdan",data.getHD());
        bd.putString("hinh",data.getImage());
        bd.putString("nguyenlieu",data.getNguyenlieu());

        intent.putExtra("dulieu",bd);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainAdapter.startListening();
    }


}