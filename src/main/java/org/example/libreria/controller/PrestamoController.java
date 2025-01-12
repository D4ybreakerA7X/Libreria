package org.example.libreria.controller;

import org.example.libreria.model.Prestamo;
import org.example.libreria.repository.PrestamoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {
    private final PrestamoRepository prestamoRepository;

    public PrestamoController(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    @GetMapping
    public List<Prestamo> getAllPrestamos() {
        return prestamoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Prestamo getPrestamoById(@PathVariable int id) {
        return prestamoRepository.findById(id);
    }

    @PostMapping
    public String createPrestamo(@RequestBody Prestamo prestamo) {
        prestamoRepository.save(prestamo);
        return "Préstamo creado con éxito";
    }

    @PutMapping("/{id}")
    public String updatePrestamo(@PathVariable int id, @RequestBody Prestamo prestamo) {
        prestamo.setId(id);
        prestamoRepository.update(prestamo);
        return "Préstamo actualizado con éxito";
    }

    @DeleteMapping("/{id}")
    public String deletePrestamo(@PathVariable int id) {
        prestamoRepository.delete(id);
        return "Préstamo eliminado con éxito";
    }
}