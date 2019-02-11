package com.example.gioele.depone.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.gioele.depone.R;
import com.example.gioele.depone.activities.adapter.CheckoutAdapter;
import com.example.gioele.depone.activities.adapter.ResturantAdapter;
import com.example.gioele.depone.activities.datamodel.Portata;

import java.util.ArrayList;

public class CheckoutActivity extends AppCompatActivity {

    ArrayList<Portata> portata ;
    TextView nomeRistorante;
    Intent intent;
    RecyclerView checkoutRV;
    RecyclerView.LayoutManager manager;
    CheckoutAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout_activity);
        nomeRistorante = findViewById(R.id.nomeRistorante);
        intent= getIntent();
        String r = intent.getStringExtra("nome");
        nomeRistorante.setText(r);
        checkoutRV = findViewById(R.id.recycle);
        manager = new LinearLayoutManager(this);
        adapter = new CheckoutAdapter(CheckoutActivity.this, getData());
        checkoutRV.setAdapter(adapter);
        checkoutRV.setLayoutManager(manager);

    }

    private ArrayList<Portata> getData(){
        portata = new ArrayList<>();
        Portata uramaki = new Portata("uramaki","https://ips.plug.it/cips/buonissimo.org/cms/2018/10/Uramaki-4.jpg");
        Portata onighiri = new Portata("onighiri","https://www.manusmenu.com/wp-content/uploads/2017/08/Onigiri-3-1-of-1.jpg");
        Portata ravioli = new Portata("ravioli", "http://www.sushikami.it/wp-content/uploads/2014/02/Oriental-Restaurant-Cerreto-Castello-ravioli-di-carne-a-vapore-1.jpg");
        Portata sashimi = new Portata("sashimi","https://blue.kumparan.com/kumpar/image/upload/fl_progressive,fl_lossy,c_fill,q_auto:best,w_640/v1516520688/jscarkxafsfia8yqavjz.jpg");
        portata.add(uramaki);
        portata.add(onighiri);
        portata.add(sashimi);
        portata.add(ravioli);
        return portata;
    }

}
