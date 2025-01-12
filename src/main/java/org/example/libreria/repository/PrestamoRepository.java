package org.example.libreria.repository;

import org.example.libreria.model.Prestamo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PrestamoRepository {
    private final JdbcTemplate jdbcTemplate;

    public PrestamoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Prestamo> findAll() {
        String sql = "SELECT * FROM Prestamo";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Prestamo(
                rs.getInt("ID_Prestamo"),
                rs.getInt("ID_Usuario"),
                rs.getInt("ID_Libro"),
                rs.getDate("Fecha_Prestamo").toLocalDate(),
                rs.getDate("Fecha_Devolucion") != null ? rs.getDate("Fecha_Devolucion").toLocalDate() : null
        ));
    }

    public Prestamo findById(int id) {
        String sql = "SELECT * FROM Prestamo WHERE ID_Prestamo = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> new Prestamo(
                rs.getInt("ID_Prestamo"),
                rs.getInt("ID_Usuario"),
                rs.getInt("ID_Libro"),
                rs.getDate("Fecha_Prestamo").toLocalDate(),
                rs.getDate("Fecha_Devolucion") != null ? rs.getDate("Fecha_Devolucion").toLocalDate() : null
        ));
    }

    public int save(Prestamo prestamo) {
        String sql = "INSERT INTO Prestamo (ID_Prestamo, ID_Usuario, ID_Libro, Fecha_Prestamo, Fecha_Devolucion) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, prestamo.getId(), prestamo.getIdUsuario(), prestamo.getIdLibro(), prestamo.getFechaPrestamo(), prestamo.getFechaDevolucion());
    }

    public int update(Prestamo prestamo) {
        String sql = "UPDATE Prestamo SET ID_Usuario = ?, ID_Libro = ?, Fecha_Prestamo = ?, Fecha_Devolucion = ? WHERE ID_Prestamo = ?";
        return jdbcTemplate.update(sql, prestamo.getIdUsuario(), prestamo.getIdLibro(), prestamo.getFechaPrestamo(), prestamo.getFechaDevolucion(), prestamo.getId());
    }

    public int delete(int id) {
        String sql = "DELETE FROM Prestamo WHERE ID_Prestamo = ?";
        return jdbcTemplate.update(sql, id);
    }
}
