package com.example.gioele.depone.activities.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.gioele.depone.R;
import com.example.gioele.depone.activities.datamodel.Portata;

import java.util.ArrayList;

import me.angrybyte.numberpicker.listener.OnValueChangeListener;
import me.angrybyte.numberpicker.view.ActualNumberPicker;

import static com.example.gioele.depone.activities.Activity.PortataActivity.getMinimo;
import static com.example.gioele.depone.activities.Activity.PortataActivity.progressBar;


public class PortataAdapter extends RecyclerView.Adapter {
    Context context;
    private LayoutInflater inflater;
    double p;
    public  double priceCount ;

    private ArrayList<Portata> data;

    public PortataAdapter(Context context, ArrayList<Portata> data) {
        this.context=context;
        this.data=data;
        this.inflater= LayoutInflater.from(context);
    }
    public void setData(ArrayList<Portata>data){
        this.data=data;
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
        vh.price.setText(String.valueOf(data.get(position).getPrezzo()));
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
        TextView price;
        ActualNumberPicker mPicker;
    public rHolder (View view){
        super(view);
        p=0;
        progressBar.setProgress(0);
        name =  view.findViewById(R.id.recycleText);
        image = view.findViewById(R.id.recycleImage);
        price = view.findViewById(R.id.recyclePrice);
        mPicker = (ActualNumberPicker) view.findViewById(R.id.actual_picker);
        mPicker.setListener(new OnValueChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onValueChanged(int oldValue, int newValue) {
                p = ((Double.parseDouble(price.getText().toString())));
                if(oldValue>newValue){
                    priceCount -=p;
                    float x = getMinimo();
                    Toast.makeText(context, "item canceled", Toast.LENGTH_SHORT).show();
                    progressBar.setProgress((int)((priceCount)),true);
                }
                else {priceCount+=p;
                progressBar.setProgress((int)((priceCount)),true);
                Toast.makeText(context, "item added", Toast.LENGTH_SHORT).show();}

            }

        });

    }
}}

