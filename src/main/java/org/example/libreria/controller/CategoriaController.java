package org.example.libreria.controller;

import org.example.libreria.model.Categoria;
import org.example.libreria.repository.CategoriaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping
    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Categoria getCategoriaById(@PathVariable int id) {
        return categoriaRepository.findById(id);
    }

    @PostMapping
    public String createCategoria(@RequestBody Categoria categoria) {
        categoriaRepository.save(categoria);
        return "Categoría creada con éxito";
    }

    @PutMapping("/{id}")
    public String updateCategoria(@PathVariable int id, @RequestBody Categoria categoria) {
        categoria.setId(id);
        categoriaRepository.update(categoria);
        return "Categoría actualizada con éxito";
    }

    @DeleteMapping("/{id}")
    public String deleteCategoria(@PathVariable int id) {
        categoriaRepository.delete(id);
        return "Categoría eliminada con éxito";
    }
}
