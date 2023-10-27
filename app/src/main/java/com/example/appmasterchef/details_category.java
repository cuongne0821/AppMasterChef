package com.example.appmasterchef;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class details_category extends AppCompatActivity implements Adapter_detailsCategory.OnItemClickListener{
    private RecyclerView recyclerView;
    private Adapter_detailsCategory adapter;
    private List<Mydata> datalist;
    private ImageView imgView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_category);

        recyclerView= findViewById(R.id.recycler_view);
        imgView=(ImageView) findViewById(R.id.back);
        datalist = new ArrayList<>();

        datalist.add(new Mydata("Canh ghẹ rau muống", "https://img-global.cpcdn.com/recipes/c98e54bcba8436e2/680x482cq70/canh-gh%E1%BA%B9-n%E1%BA%A5u-rau-c%E1%BA%A3i-rau-ngot-recipe-main-photo.jpg"));
        datalist.add(new Mydata("Canh chua cá lóc", "https://i-giadinh.vnecdn.net/2023/04/25/Thanh-pham-1-1-7239-1682395675.jpg"));


        adapter = new Adapter_detailsCategory(datalist, this);
        recyclerView.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    @Override
    public void onItemClick(Mydata data) {
        // Chuyển sang trang mới khi mục được nhấn vào
        Intent intent = new Intent(details_category.this, Canhgheraumuong_Moncanh.class);
        startActivity(intent);
    }
}
