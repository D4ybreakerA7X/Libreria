package org.example.libreria.repository;

import org.example.libreria.model.Editorial;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EditorialRepository {
    private final JdbcTemplate jdbcTemplate;

    public EditorialRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Editorial> findAll() {
        String sql = "SELECT * FROM Editorial";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Editorial(
                rs.getInt("ID_Editorial"),
                rs.getString("Nombre_Editorial"),
                rs.getString("Direccion"),
                rs.getString("Telefono")
        ));
    }

    public Editorial findById(int id) {
        String sql = "SELECT * FROM Editorial WHERE ID_Editorial = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> new Editorial(
                rs.getInt("ID_Editorial"),
                rs.getString("Nombre_Editorial"),
                rs.getString("Direccion"),
                rs.getString("Telefono")
        ));
    }

    public int save(Editorial editorial) {
        String sql = "INSERT INTO Editorial (ID_Editorial, Nombre_Editorial, Direccion, Telefono) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, editorial.getId(), editorial.getNombreEditorial(), editorial.getDireccion(), editorial.getTelefono());
    }

    public int update(Editorial editorial) {
        String sql = "UPDATE Editorial SET Nombre_Editorial = ?, Direccion = ?, Telefono = ? WHERE ID_Editorial = ?";
        return jdbcTemplate.update(sql, editorial.getNombreEditorial(), editorial.getDireccion(), editorial.getTelefono(), editorial.getId());
    }

    public int delete(int id) {
        String sql = "DELETE FROM Editorial WHERE ID_Editorial = ?";
        return jdbcTemplate.update(sql, id);
    }
}
