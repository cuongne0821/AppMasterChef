package com.example.appmasterchef;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter_favorite extends  RecyclerView.Adapter<Adapter_favorite.ViewHolder>{
    private List<Mydata> dataList;

    public Adapter_favorite(List<Mydata> dataList) {

        this.dataList = dataList;

    }

    public void setFilteredList(List<Mydata> filteredList){
        this.dataList=filteredList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mydata data = dataList.get(position);
        holder.nameTextView.setText(data.getTen());
        // Sử dụng Glide để tải và hiển thị hình ảnh
        Glide.with(holder.itemView.getContext())
                .load(data.getImage())
                .into(holder.imageView);
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.tv_ten);
            imageView = itemView.findViewById(R.id.imgview);
        }
    }




}
