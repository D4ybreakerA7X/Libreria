package org.example.libreria.controller;

import org.example.libreria.model.Libro;
import org.example.libreria.repository.LibroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {
    private final LibroRepository libroRepository;

    public LibroController(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @GetMapping
    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }

    @GetMapping("/{id}")
    public Libro getLibroById(@PathVariable int id) {
        return libroRepository.findById(id);
    }

    @PostMapping
    public String createLibro(@RequestBody Libro libro) {
        libroRepository.save(libro);
        return "Libro creado con éxito";
    }

    @PutMapping("/{id}")
    public String updateLibro(@PathVariable int id, @RequestBody Libro libro) {
        libro.setId(id);
        libroRepository.update(libro);
        return "Libro actualizado con éxito";
    }

    @DeleteMapping("/{id}")
    public String deleteLibro(@PathVariable int id) {
        libroRepository.delete(id);
        return "Libro eliminado con éxito";
    }
}
