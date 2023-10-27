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

        arrayprofile.add (new profile("Phạm Quốc Cường",R.drawable.img_12,"21115053120204"));
        arrayprofile.add (new profile("Phạm Hồng Sơn",R.drawable.img_12,"21115053120204"));
        arrayprofile.add (new profile("Nguyễn Quang Quý",R.drawable.img_12,"21115053120204"));
        arrayprofile.add (new profile("Mai Thanh Tùng",R.drawable.img_12,"21115053120204"));

        adapter = new profileAdapter(getActivity(),R.layout.profile,arrayprofile);
        lvprofile.setAdapter(adapter);

        return  view;
    }
}