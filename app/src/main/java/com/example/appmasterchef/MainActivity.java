package com.example.appmasterchef;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Home_Fragment homefragment=new Home_Fragment();
    Category_Fragment categoryfragment=new Category_Fragment();
    Favorite_Fragment favoriteFragment= new Favorite_Fragment();
    Service_Fragment serviceFragment = new Service_Fragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhxa();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, homefragment).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {
                int itemId = item.getItemId(); // Lấy id của item được chọn

                // So sánh id với các giá trị hằng số
                if (itemId == R.id.home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, homefragment).commit();
                    return true;
                } else if (itemId == R.id.category) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, categoryfragment).commit();
                    return true;
                }else if (itemId == R.id.favorite) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, favoriteFragment).commit();
                    return true;
                }else if (itemId == R.id.service) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, serviceFragment).commit();
                    return true;
                }

                return false;
            }
        });
    }

    private void anhxa() {
        bottomNavigationView=(BottomNavigationView) findViewById(R.id.bottom_nav);


    }
}