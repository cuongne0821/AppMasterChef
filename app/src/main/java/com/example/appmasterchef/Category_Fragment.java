package com.example.appmasterchef;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Category_Fragment extends Fragment {
    RelativeLayout btnItem_canh,btnItem_nuong,btnItem_xao,btnItem_chay;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.category_fragment, container, false);

        btnItem_canh=(RelativeLayout) view.findViewById(R.id.btnCanh);
        btnItem_nuong=(RelativeLayout) view.findViewById(R.id.btnNuong);
        btnItem_xao=(RelativeLayout) view.findViewById(R.id.btnXao);
        btnItem_chay=(RelativeLayout) view.findViewById(R.id.btnChay);


        btnItem_canh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailsCategory_Activity.class);
                startActivity(intent);
            }
        });
        btnItem_nuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Category_Nuong.class);
                startActivity(intent);
            }
        });
        btnItem_xao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Category_Xao.class);
                startActivity(intent);
            }
        });
        btnItem_chay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Category_Chay.class);
                startActivity(intent);
            }
        });
        return view;
    }
}