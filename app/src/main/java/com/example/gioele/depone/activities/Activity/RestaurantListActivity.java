package com.example.gioele.depone.activities.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.gioele.depone.R;
import com.example.gioele.depone.activities.adapter.ResturantAdapter;
import com.example.gioele.depone.activities.datamodel.Resturant;
import com.example.gioele.depone.activities.services.RestController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RestaurantListActivity extends AppCompatActivity implements Response.Listener<String>,Response.ErrorListener {

    RecyclerView restourantRV;
    RecyclerView.LayoutManager manager;
    ResturantAdapter adapter;
    ArrayList<Resturant> data;
    RestController restController;
    private boolean x=true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logged_activity);
        restourantRV = findViewById(R.id.recycle);
        manager = new LinearLayoutManager(this);
        adapter = new ResturantAdapter(this, getData());
        restourantRV.setAdapter(adapter);
        restourantRV.setLayoutManager(manager);

        restController = new RestController(this);
        restController.getRequest(Resturant.ENDPOINT, this, this);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.grid_menu,menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.grid){
            if(x) {
                x=false;
                restourantRV.setLayoutManager(new GridLayoutManager(this, 2));
            }
            else if (!x){restourantRV.setLayoutManager(manager); x=true;}
        }
        return super.onOptionsItemSelected(item);
    }


    private ArrayList<Resturant> getData(){
        data = new ArrayList<>();
        Resturant sakura = new Resturant("Sakura",22,"data:image/png;base64,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");
        Resturant oyakoi = new Resturant("Sushi oyakoi",13,"https://media.licdn.com/dms/image/C4E0BAQGoSEU7oKqvRw/company-logo_200_200/0?e=2159024400&v=beta&t=kBwKttysGhUnl_o0fnc403YxNsKtgxmMOABnrOR72Dw");
        Resturant capitale = new Resturant("La capitale", 9,"https://static.sushilabroma.it/2018/03/sushi.lab-roma-logo-ufficiale.png");
        Resturant toastamore = new Resturant("Toast amore", 15,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRYS5CpY6kJcDXsEhLLC3XTe84FatsDT60T9Bo-wIy_KY-2XSKfgw");
        Resturant montaditos = new Resturant("100 montaditos", 25,"https://www.infofranchising.it/wp-content/uploads/2018/08/100Montaditos-franchising-logo-238x238.jpg");
        Resturant oldWW = new Resturant("old wild west", 12,"http://www.portoantico.it/wp-content/uploads/2014/04/logo-old-wild-west.jpg");
        data.add(sakura);
        data.add(oyakoi);
        data.add(capitale);
        data.add(toastamore);
        data.add(montaditos);
        data.add(oldWW);


        return data;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e("errore",error.getMessage());
        Toast.makeText(this, "response error"+error.getMessage(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onResponse(String response) {

        try {
            JSONArray jsonArray = new JSONArray(response);
            for(int i =0; i<jsonArray.length();i++){
                data.add(new Resturant(jsonArray.getJSONObject(i)));
            }
            adapter.setData(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
