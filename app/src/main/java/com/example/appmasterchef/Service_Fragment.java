package com.example.appmasterchef;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class Service_Fragment extends Fragment {

    ListView lvprofile;
    ArrayList<profile> arrayprofile;
    profileAdapter adapter;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.service_fragment, container, false);


        lvprofile =(ListView) view.findViewById(R.id.listviewprofile);
        arrayprofile = new ArrayList<>();

        arrayprofile.add (new profile("Món ăn đã xem",R.drawable.img_12));
        arrayprofile.add (new profile("Món ăn có ghi chú",R.drawable.img_13));
        arrayprofile.add (new profile("Đánh giá ứng dụng",R.drawable.img_17));
        arrayprofile.add (new profile("Chia sẻ ứng dụng",R.drawable.img15));
        arrayprofile.add (new profile("Thông tin ứng dụng",R.drawable.img_18));

        adapter = new profileAdapter(getActivity(),R.layout.profile,arrayprofile);
        lvprofile.setAdapter(adapter);

        return  view;
    }
}