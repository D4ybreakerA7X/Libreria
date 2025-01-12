package org.example.libreria.controller;

import org.example.libreria.model.Editorial;
import org.example.libreria.repository.EditorialRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/editoriales")
public class EditorialController {
    private final EditorialRepository editorialRepository;

    public EditorialController(EditorialRepository editorialRepository) {
        this.editorialRepository = editorialRepository;
    }

    @GetMapping
    public List<Editorial> getAllEditoriales() {
        return editorialRepository.findAll();
    }

    @GetMapping("/{id}")
    public Editorial getEditorialById(@PathVariable int id) {
        return editorialRepository.findById(id);
    }

    @PostMapping
    public String createEditorial(@RequestBody Editorial editorial) {
        editorialRepository.save(editorial);
        return "Editorial creada con éxito";
    }

    @PutMapping("/{id}")
    public String updateEditorial(@PathVariable int id, @RequestBody Editorial editorial) {
        editorial.setId(id);
        editorialRepository.update(editorial);
        return "Editorial actualizada con éxito";
    }

    @DeleteMapping("/{id}")
    public String deleteEditorial(@PathVariable int id) {
        editorialRepository.delete(id);
        return "Editorial eliminada con éxito";
    }
}