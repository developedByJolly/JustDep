package com.example.gioele.depone.activities.datamodel;

public class Portata {

    private String nome;
    private String image;

    public double getPrezzo() {
        return prezzo;
    }

    private double prezzo;



    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
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

    public String getNome() {
        return nome;
    }


    public Portata(String nome, String image,double prezzo) {
        this.image = image;
        this.nome = nome;
        this.prezzo=prezzo;
    }
}
