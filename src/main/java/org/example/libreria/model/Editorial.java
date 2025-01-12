package org.example.libreria.model;

public class Editorial {
    private int id;
    private String nombreEditorial;
    private String direccion;
    private String telefono;

    // Constructor, Getters y Setters
    public Editorial() {}

    public Editorial(int id, String nombreEditorial, String direccion, String telefono) {
        this.id = id;
        this.nombreEditorial = nombreEditorial;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEditorial() {
        return nombreEditorial;
    }

    public void setNombreEditorial(String nombreEditorial) {
        this.nombreEditorial = nombreEditorial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
