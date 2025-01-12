package org.example.libreria.model;

import java.time.LocalDate;

public class UsuarioBiblioteca {
    private int id;
    private String nombre;
    private String correoElectronico;
    private LocalDate fechaRegistro;
    private String tipoUsuario;

    // Constructor, Getters y Setters
    public UsuarioBiblioteca() {}

    public UsuarioBiblioteca(int id, String nombre, String correoElectronico, LocalDate fechaRegistro, String tipoUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.fechaRegistro = fechaRegistro;
        this.tipoUsuario = tipoUsuario;
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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
