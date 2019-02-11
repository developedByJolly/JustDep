package com.example.gioele.depone.activities.datamodel;

public class Portata {

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

    public String getNome() {
        return nome;
    }


    public Portata(String nome, String image) {
        this.image = image;
        this.nome = nome;
    }
}
