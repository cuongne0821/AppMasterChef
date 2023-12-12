package com.example.appmasterchef;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class Home_Fragment extends Fragment {
    private RecyclerView recyclerView;
    private My_Adapter adapter;

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
                txtSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                txtSearch(newText);
                return true;
            }
        });

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(requireActivity(),2));

        FirebaseRecyclerOptions<Mydata> options = new FirebaseRecyclerOptions.Builder<Mydata>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Food"), Mydata.class)
                .build();
        adapter = new My_Adapter(options);

        adapter.setOnItemClickListener(new My_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(Mydata data) {
                Home_Fragment.this.onItemClick(data);
            }
        });
        recyclerView.setAdapter(adapter);

        return view;
    }






    //tim kiem
    private void txtSearch(String text) {


        Query query = FirebaseDatabase.getInstance().getReference()
                .child("Food")
                .orderByChild("Name")
                .startAt(text)
                .endAt(text + "~");

        FirebaseRecyclerOptions<Mydata> options = new FirebaseRecyclerOptions.Builder<Mydata>()
                .setQuery(query, Mydata.class)
                .build();

        adapter.updateOptions(options);
        adapter.notifyDataSetChanged();

    }
    public void onItemClick(Mydata data) {
        // Chuyển sang trang mới khi mục được nhấn vào
        Intent intent = new Intent(getActivity(), Details_Food.class);
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