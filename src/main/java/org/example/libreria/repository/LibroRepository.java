package org.example.libreria.repository;

import org.example.libreria.model.Libro;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LibroRepository {
    private final JdbcTemplate jdbcTemplate;

    public LibroRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Libro> findAll() {
        String sql = "SELECT * FROM Libro";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Libro(
                rs.getInt("ID_Libro"),
                rs.getString("Titulo"),
                rs.getString("Autor"),
                rs.getString("ISBN"),
                rs.getInt("Ano_Publicacion"),
                rs.getString("Genero")
        ));
    }

    public Libro findById(int id) {
        String sql = "SELECT * FROM Libro WHERE ID_Libro = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> new Libro(
                rs.getInt("ID_Libro"),
                rs.getString("Titulo"),
                rs.getString("Autor"),
                rs.getString("ISBN"),
                rs.getInt("Ano_Publicacion"),
                rs.getString("Genero")
        ));
    }

    public int save(Libro libro) {
        String sql = "INSERT INTO Libro (ID_Libro, Titulo, Autor, ISBN, Ano_Publicacion, Genero) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, libro.getId(), libro.getTitulo(), libro.getAutor(), libro.getIsbn(), libro.getAnoPublicacion(), libro.getGenero());
    }

    public int update(Libro libro) {
        String sql = "UPDATE Libro SET Titulo = ?, Autor = ?, ISBN = ?, Ano_Publicacion = ?, Genero = ? WHERE ID_Libro = ?";
        return jdbcTemplate.update(sql, libro.getTitulo(), libro.getAutor(), libro.getIsbn(), libro.getAnoPublicacion(), libro.getGenero(), libro.getId());
    }

    public int delete(int id) {
        String sql = "DELETE FROM Libro WHERE ID_Libro = ?";
        return jdbcTemplate.update(sql, id);
    }
}
