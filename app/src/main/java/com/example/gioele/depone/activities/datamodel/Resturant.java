package com.example.gioele.depone.activities.datamodel;

public class Resturant {


    private int minimo;
    private String nome;
    private String image;


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

    public int getMinimo() {
        return minimo;
    }




    public Resturant(String nome, int minimo, String image) {
        this.image = image;
        this.nome = nome;
        this.minimo = minimo;
    }

}
