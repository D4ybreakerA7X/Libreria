package org.example.libreria.controller;

import org.example.libreria.model.Reserva;
import org.example.libreria.repository.ReservaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {
    private final ReservaRepository reservaRepository;

    public ReservaController(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @GetMapping
    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Reserva getReservaById(@PathVariable int id) {
        return reservaRepository.findById(id);
    }

    @PostMapping
    public String createReserva(@RequestBody Reserva reserva) {
        reservaRepository.save(reserva);
        return "Reserva creada con éxito";
    }

    @PutMapping("/{id}")
    public String updateReserva(@PathVariable int id, @RequestBody Reserva reserva) {
        reserva.setId(id);
        reservaRepository.update(reserva);
        return "Reserva actualizada con éxito";
    }

    @DeleteMapping("/{id}")
    public String deleteReserva(@PathVariable int id) {
        reservaRepository.delete(id);
        return "Reserva eliminada con éxito";
    }
}
