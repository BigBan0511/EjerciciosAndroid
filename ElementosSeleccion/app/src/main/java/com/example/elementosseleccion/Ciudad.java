package com.example.elementosseleccion;

public class Ciudad {
    private String nombre;
    private String descripcion;
    private int imagenID;

    public Ciudad(String nombre, String descripcion, int imagenID){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenID = imagenID;
    }

    public int getImagenID() {
        return imagenID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setImagenID(int imagenID) {
        this.imagenID = imagenID;
    }

    public String getNombre() {
        return nombre;
    }
}
