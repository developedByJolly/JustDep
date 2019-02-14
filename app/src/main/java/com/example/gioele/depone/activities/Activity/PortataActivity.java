package com.example.gioele.depone.activities.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.gioele.depone.R;
import com.example.gioele.depone.activities.adapter.PortataAdapter;
import com.example.gioele.depone.activities.datamodel.Portata;
import com.example.gioele.depone.activities.datamodel.Resturant;
import com.example.gioele.depone.activities.services.RestController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PortataActivity extends AppCompatActivity implements Response.Listener<String>,Response.ErrorListener {

    ArrayList<Portata> portata ;
    TextView nomeRistorante;
    Intent intent;
    int prezzo;
    static float minimo;
    RecyclerView checkoutRV;
    RecyclerView.LayoutManager manager;
    PortataAdapter adapter;
    Button checkoutBtn;
    RestController restController;
    public static ProgressBar progressBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout_activity);
        nomeRistorante = findViewById(R.id.nomeRistorante);
        intent= getIntent();
        String id =intent.getStringExtra("id");
        String r = intent.getStringExtra("nome");
         minimo = Float.parseFloat((intent.getStringExtra("minimo")));
        Log.i("aiuto", String.valueOf(minimo));
        nomeRistorante.setText(r);
        //
        checkoutBtn = findViewById(R.id.checkoutbtn);
        checkoutRV = findViewById(R.id.recycle);
        progressBar= findViewById(R.id.progressBar);

        progressBar.setMax((int) minimo);

        manager = new LinearLayoutManager(this);
        adapter = new PortataAdapter(PortataActivity.this, getData());
        checkoutRV.setAdapter(adapter);
        checkoutRV.setLayoutManager(manager);

        restController = new RestController(this);
        restController.getRequest(Resturant.ENDPOINT.concat(id), this, this);

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

    public static  float getMinimo(){
        return minimo;
    }


    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e("errore",error.getMessage());
        Toast.makeText(this, "response error"+error.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(String response) {

        try {
            JSONObject object = new JSONObject(response);
            JSONArray jsonArray = object.getJSONArray("products");
            for(int i =0; i<jsonArray.length();i++){
                portata.add(new Portata(jsonArray.getJSONObject(i)));
            }
            adapter.setData(portata);


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
