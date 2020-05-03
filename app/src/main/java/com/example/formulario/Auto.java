package com.example.formulario;

import java.io.Serializable;

public class Auto implements Serializable {

    String id;
    String modelo;
    String marca;
    String precio;

    public Auto(String id, String modelo, String marca, String precio) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
