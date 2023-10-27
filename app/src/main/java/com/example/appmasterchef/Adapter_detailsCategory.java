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

public class Adapter_detailsCategory extends  RecyclerView.Adapter<Adapter_detailsCategory.ViewHolder>{
    private List<Mydata> dataList;
    private OnItemClickListener listener;
    public Adapter_detailsCategory(List<Mydata> dataList, OnItemClickListener listener) {

        this.dataList = dataList;
        this.listener = listener;
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



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.tv_ten);
            imageView = itemView.findViewById(R.id.imgview);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Mydata data = dataList.get(position);
                        listener.onItemClick(data);
                    }
                }
            });

        }
    }

    public interface OnItemClickListener {
        void onItemClick(Mydata data);
    }

    }
