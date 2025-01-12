package org.example.libreria.controller;

import org.example.libreria.model.UsuarioBiblioteca;
import org.example.libreria.repository.UsuarioBibliotecaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioBibliotecaController {
    private final UsuarioBibliotecaRepository usuarioRepository;

    public UsuarioBibliotecaController(UsuarioBibliotecaRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<UsuarioBiblioteca> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public UsuarioBiblioteca getUsuarioById(@PathVariable int id) {
        return usuarioRepository.findById(id);
    }

    @PostMapping
    public String createUsuario(@RequestBody UsuarioBiblioteca usuario) {
        usuarioRepository.save(usuario);
        return "Usuario creado con éxito";
    }

    @PutMapping("/{id}")
    public String updateUsuario(@PathVariable int id, @RequestBody UsuarioBiblioteca usuario) {
        usuario.setId(id);
        usuarioRepository.update(usuario);
        return "Usuario actualizado con éxito";
    }

    @DeleteMapping("/{id}")
    public String deleteUsuario(@PathVariable int id) {
        usuarioRepository.delete(id);
        return "Usuario eliminado con éxito";
    }
}
