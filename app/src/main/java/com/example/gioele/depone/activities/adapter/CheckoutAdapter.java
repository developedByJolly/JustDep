package com.example.gioele.depone.activities.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gioele.depone.R;
import com.example.gioele.depone.activities.datamodel.Portata;

import java.util.ArrayList;


public class CheckoutAdapter extends RecyclerView.Adapter {
    Context context;
    private LayoutInflater inflater;

    private ArrayList<Portata> data;

    public CheckoutAdapter(Context context,ArrayList<Portata> data) {
        this.context=context;
        this.data=data;
        this.inflater= LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_portata,parent,false);
        return new rHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        rHolder vh = (rHolder) holder;
        Portata item = data.get(position);
        vh.name.setText(data.get(position).getNome());
        Glide.with(context).
                load(data.get(position).getImage()).into(vh.image);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class rHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;
    public rHolder (View view){
        super(view);
        name = (TextView) view.findViewById(R.id.recycleText);
        image = view.findViewById(R.id.recycleImage);

    }
}}

