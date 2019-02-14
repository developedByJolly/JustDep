package com.example.gioele.depone.activities.datamodel;

import org.json.JSONException;
import org.json.JSONObject;

public class Resturant {


    private float minimo;
    private String nome;
    private String image;
    private String id;

    public static final String ENDPOINT="restaurants/";

    public Resturant(JSONObject jsonRestaurant) throws JSONException {
        nome = jsonRestaurant.getString("name");
        minimo = Float.valueOf(jsonRestaurant.getString("min_order"));
        image = jsonRestaurant.getString("image_url");
        id = jsonRestaurant.getString("id");

    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }




    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }




    public String getNome() {
        return nome;
    }

    public float getMinimo() {
        return minimo;
    }




    public Resturant(String nome, int minimo, String image) {
        this.image = image;
        this.nome = nome;
        this.minimo = minimo;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
