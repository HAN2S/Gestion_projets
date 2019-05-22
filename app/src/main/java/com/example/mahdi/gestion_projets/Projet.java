package com.example.mahdi.gestion_projets;

public class Projet {
    private int id;
    private String nom;

    public Projet(String nom){
        this.nom=nom;
    }
    public Projet(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
