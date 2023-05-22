package com.example.retrofit.adapter;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit.R;
import com.example.retrofit.model.CryptoModel;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RowHolder> {
    private ArrayList<CryptoModel> cryptoList;
    private String[] colors = {"#59cbe8","#9784ff","#4a646c","#fffff0","#005f66","#ffa300","#2dccd3","#eb6fbd","#ed2939","#4d1a2a"};

    public RecyclerViewAdapter(ArrayList<CryptoModel> cryptoList) {
        this.cryptoList = cryptoList;
    }

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new RowHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {
        holder.bind(cryptoList.get(position), colors, position);
    }

    @Override
    public int getItemCount() {
        return cryptoList.size();
    }

    public class RowHolder extends RecyclerView.ViewHolder {
        TextView nameTv, priceTv;

        public RowHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.tvName);
            priceTv = itemView.findViewById(R.id.tvPrice);
        }

        public void bind(CryptoModel cryptoModel, String[] colors, int position) {
            itemView.setBackgroundColor(Color.parseColor(colors[position % 10]));
            nameTv.setText(cryptoModel.getCurrency());
            priceTv.setText(cryptoModel.getPrice());
        }
    }
}
