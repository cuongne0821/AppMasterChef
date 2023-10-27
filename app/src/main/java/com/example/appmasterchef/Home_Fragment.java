package com.example.appmasterchef;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class Home_Fragment extends Fragment implements My_Adapter.OnItemClickListener{
    private RecyclerView recyclerView;
    private My_Adapter adapter;
    private List<Mydata> datalist;
    private SearchView searchView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        searchView=view.findViewById(R.id.searchView);

        searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        recyclerView = view.findViewById(R.id.recycler_view);
        datalist = new ArrayList<>(); // Tạo danh sách món ăn

        // Thêm dữ liệu mẫu vào danh sách món ăn
        datalist.add(new Mydata("Canh ghẹ rau muống", "https://img-global.cpcdn.com/recipes/c98e54bcba8436e2/680x482cq70/canh-gh%E1%BA%B9-n%E1%BA%A5u-rau-c%E1%BA%A3i-rau-ngot-recipe-main-photo.jpg"));
        datalist.add(new Mydata("Bún riêu cua", "https://cdnimg.vietnamplus.vn/t620/uploaded/hotnnz/2020_04_28/bun_rieu_2.jpg"));
        datalist.add(new Mydata("Trứng chiên hoàng gia", "https://bepxua.vn/wp-content/uploads/2021/07/trung-chien-thit-scaled.jpg"));
        datalist.add(new Mydata("Canh chua cá lóc", "https://i-giadinh.vnecdn.net/2023/04/25/Thanh-pham-1-1-7239-1682395675.jpg"));
        datalist.add(new Mydata("Tôm hùm hấp bia", "https://file.hstatic.net/200000441267/article/tom-hum-hap-1_2e9398b3ec3543cba90942048cbe64b2.jpg"));
        datalist.add(new Mydata("Soup bào ngư vi cá ", "https://vicaongduc.com/wp-content/uploads/2023/05/z4349574068459_511898e874ae8f510b763cf9fd8ccdf4.jpg"));
        datalist.add(new Mydata("Kingcrab nướng phô mai", "https://cdn.tgdd.vn/2021/06/CookProductThumb/Monantucuahoangde(1)-620x620.jpg"));

        adapter = new My_Adapter(datalist, this);
        recyclerView.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(requireContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }

    //tim kiem
    private void filterList(String Text) {
        List<Mydata> filteredList=new ArrayList<>();
        for(Mydata monan:datalist){
            if(monan.getTen().toLowerCase().contains(Text.toLowerCase())){
                filteredList.add(monan);
            }
        }
        if(filteredList.isEmpty()){
            Toast.makeText(getActivity(),"khong tim thay!", Toast.LENGTH_SHORT).show();
        }else{
            adapter.setFilteredList(filteredList);
        }
    }

    @Override
    public void onItemClick(Mydata data) {
        // Chuyển sang trang mới khi mục được nhấn vào
        Intent intent = new Intent(getActivity(), Canhgheraumuong_Moncanh.class);
        startActivity(intent);
    }
}