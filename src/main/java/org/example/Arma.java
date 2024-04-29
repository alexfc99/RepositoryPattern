package org.example;

public class Arma {
    private int id;
    private String nombre;
    private String tier;
    private String tipo;

    public Arma(int id, String nombre, String tier, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tier = tier;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    @Override
    public String toString(){return "ID: " + this.id + "\nNombre: " + this.nombre + "\nTier: " + this.tier + "\nTipo: " + this.tipo + "\n";}
}
