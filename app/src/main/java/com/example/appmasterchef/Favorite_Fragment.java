package com.example.appmasterchef;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class Favorite_Fragment extends Fragment {
    private RecyclerView recyclerView;
//    private Adapter_favorite adapter;
    private List<Mydata> listMonan;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.favorite_fragment, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        listMonan = new ArrayList<>(); // Tạo danh sách món ăn

        // Thêm dữ liệu mẫu vào danh sách món ăn
        listMonan.add(new Mydata("hello", "https://cdnimg.vietnamplus.vn/t620/uploaded/hotnnz/2020_04_28/bun_rieu_2.jpg","nce","haha","đá"));


//        adapter = new Adapter_favorite(listMonan);
//        recyclerView.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(requireContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
}