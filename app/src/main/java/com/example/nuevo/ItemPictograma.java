package com.example.nuevo;

public class ItemPictograma {

    int pictograma;
    String nombre_pictograma;


    public ItemPictograma(int pictograma, String nombre_pictograma) {
        this.pictograma = pictograma;
        this.nombre_pictograma = nombre_pictograma;
    }


    public int getPictograma() {
        return pictograma;
    }

    public void setPictograma(int pictograma) {
        this.pictograma = pictograma;
    }

    public String getNombre_pictograma() {
        return nombre_pictograma;
    }

    public void setNombre_pictograma(String nombre_pictograma) {
        this.nombre_pictograma = nombre_pictograma;
    }
}
