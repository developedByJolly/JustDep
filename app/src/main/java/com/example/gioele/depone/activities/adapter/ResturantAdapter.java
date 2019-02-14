package com.example.gioele.depone.activities.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gioele.depone.R;
import com.example.gioele.depone.activities.Activity.PortataActivity;
import com.example.gioele.depone.activities.datamodel.Resturant;


import java.util.ArrayList;

public class ResturantAdapter extends RecyclerView.Adapter{

    private LayoutInflater inflater;

    public ArrayList<Resturant> getData() {
        return data;
    }

    public void setData(ArrayList<Resturant> data) {
        this.data = data;
    }

    public ArrayList<Resturant> data;
    Context context;

    public ResturantAdapter(Context context, ArrayList<Resturant> data ) {
        this.data = data;
        this.context=context;
        this.inflater= LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_ristorante,parent,false);
        return new rHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        rHolder vh = (rHolder) holder;
        Resturant item = data.get(position);
        vh.minimo.setText( String.valueOf(data.get(position).getMinimo()));
        vh.name.setText(data.get(position).getNome());
        Glide.with(context).
                load(data.get(position).getImage()).into(vh.image);

    }



    @Override
    public int getItemCount() {
        return data.size();
    }

    public class rHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView image;
        public TextView minimo;

        public rHolder(final View view) {
            super(view);
            minimo = view.findViewById(R.id.minimo);
            name =  view.findViewById(R.id.testo);
            image = view.findViewById(R.id.rimage);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                   Intent intent = new Intent(context, PortataActivity.class);
                    intent.putExtra("nome",name.getText());
                    intent.putExtra("id", data.get(getAdapterPosition()).getId());
                    intent.putExtra("minimo", minimo.getText().toString());
                    context.startActivity(intent);
                }
            });

        }


    }
}