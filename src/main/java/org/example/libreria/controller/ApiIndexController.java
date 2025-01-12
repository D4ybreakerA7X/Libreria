package org.example.libreria.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiIndexController {

    @GetMapping("/")
    public String apiIndex() {
        return """
                <h1>Bienvenido a la API de Libreria</h1>
                <p>Rutas disponibles:</p>
                <ul>
                    <li><a href="/api/libros">/api/libros</a> - Gestión de libros</li>
                    <li><a href="/api/usuarios">/api/usuarios</a> - Gestión de usuarios</li>
                    <li><a href="/api/reservas">/api/reservas</a> - Gestión de reservas</li>
                    <li><a href="/api/categorias">/api/categorias</a> - Gestión de categorías</li>
                    <li><a href="/api/autores">/api/autores</a> - Gestión de autores</li>
                    <li><a href="/api/editoriales">/api/editoriales</a> - Gestión de editoriales</li>
                </ul>
                <p>Consulta la <a href="/swagger-ui/index.html">documentación Swagger</a> para más detalles.</p>
                """;
    }
}
