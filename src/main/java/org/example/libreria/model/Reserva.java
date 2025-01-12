package org.example.libreria.model;

import java.time.LocalDate;

public class Reserva {
    private int id;
    private int idUsuario;
    private int idLibro;
    private LocalDate fechaReserva;

    // Constructor, Getters y Setters
    public Reserva() {}

    public Reserva(int id, int idUsuario, int idLibro, LocalDate fechaReserva) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idLibro = idLibro;
        this.fechaReserva = fechaReserva;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
}
