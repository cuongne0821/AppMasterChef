package com.example.appmasterchef;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;


public class Favorite_Fragment extends Fragment {


        private RecyclerView recyclerView;
        private My_Adapter adapter;


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.favorite_fragment, container, false);




            recyclerView = view.findViewById(R.id.recycler_view);
            recyclerView.setLayoutManager(new GridLayoutManager(requireActivity(),2));

            FirebaseRecyclerOptions<Mydata> options = new FirebaseRecyclerOptions.Builder<Mydata>()
                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Favorites"), Mydata.class)
                    .build();
            adapter = new My_Adapter(options);

            adapter.setOnItemClickListener(new My_Adapter.OnItemClickListener() {
                @Override
                public void onItemClick(Mydata data) {
                    Favorite_Fragment.this.onItemClick(data);
                }
            });
            recyclerView.setAdapter(adapter);

            return view;
        }






        public void onItemClick(Mydata data) {

            // Chuyển sang trang mới khi mục được nhấn vào
            Intent intent = new Intent(getActivity(), Details_Favorite.class);
            Bundle bd=new Bundle();
            bd.putString("ten",data.getName());
            bd.putString("huongdan",data.getHD());
            bd.putString("hinh",data.getImage());
            bd.putString("nguyenlieu",data.getNguyenlieu());

            intent.putExtra("dulieu",bd);
            startActivity(intent);
        }
        @Override
        public void onStart() {
            super.onStart();
            if (adapter != null) {
                adapter.startListening();
            }
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
            if (adapter != null) {
                adapter.stopListening();
            }
        }










}