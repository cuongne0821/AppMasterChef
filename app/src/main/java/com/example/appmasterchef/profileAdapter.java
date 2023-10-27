package com.example.appmasterchef;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class profileAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<profile>profileList;

    public profileAdapter(Context context, int layout, List<profile> profileList) {
        this.context = context;
        this.layout = layout;
        this.profileList = profileList;
    }

    @Override
    public int getCount() {
        return profileList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);

        TextView txtTen = (TextView) view.findViewById(R.id.textviewTen);
        ImageView imgHinh = (ImageView) view.findViewById(R.id.imgviewhinh);
        TextView txtMsv=(TextView) view.findViewById(R.id.textviewmsv);
        profile profile=profileList.get(i);
        txtTen.setText(profile.getTen());
        txtMsv.setText(profile.getMsv());
        imgHinh.setImageResource(profile.getHinh());


        return view;
    }
}