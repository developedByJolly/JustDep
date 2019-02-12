package com.example.gioele.depone.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
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
    int prezzo;
    static int minimo;
    RecyclerView checkoutRV;
    RecyclerView.LayoutManager manager;
    CheckoutAdapter adapter;
    Button checkoutBtn;
    public static ProgressBar progressBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout_activity);
        nomeRistorante = findViewById(R.id.nomeRistorante);
        intent= getIntent();
        String r = intent.getStringExtra("nome");
         minimo = Integer.parseInt(intent.getStringExtra("minimo"));
        Log.i("aiuto", String.valueOf(minimo));
        nomeRistorante.setText(r);
        checkoutBtn = findViewById(R.id.checkoutbtn);
        checkoutRV = findViewById(R.id.recycle);
        progressBar= findViewById(R.id.progressBar);
        progressBar.setMax(minimo);
        manager = new LinearLayoutManager(this);
        adapter = new CheckoutAdapter(CheckoutActivity.this, getData());
        checkoutRV.setAdapter(adapter);
        checkoutRV.setLayoutManager(manager);
    }

    private ArrayList<Portata> getData(){
        portata = new ArrayList<>();
        Portata uramaki = new Portata("uramaki","https://ips.plug.it/cips/buonissimo.org/cms/2018/10/Uramaki-4.jpg", 5.00);
        Portata onighiri = new Portata("onighiri","https://www.manusmenu.com/wp-content/uploads/2017/08/Onigiri-3-1-of-1.jpg",8.0);
        Portata ravioli = new Portata("ravioli", "http://www.sushikami.it/wp-content/uploads/2014/02/Oriental-Restaurant-Cerreto-Castello-ravioli-di-carne-a-vapore-1.jpg",3.50);
        Portata sashimi = new Portata("sashimi","https://blue.kumparan.com/kumpar/image/upload/fl_progressive,fl_lossy,c_fill,q_auto:best,w_640/v1516520688/jscarkxafsfia8yqavjz.jpg",8);
        portata.add(uramaki);
        portata.add(onighiri);
        portata.add(sashimi);
        portata.add(ravioli);
        return portata;
    }
    public static  int getMinimo(){
        return minimo;
    }


}
