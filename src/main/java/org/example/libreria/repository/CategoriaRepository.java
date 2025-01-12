package org.example.libreria.repository;

import org.example.libreria.model.Categoria;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriaRepository {
    private final JdbcTemplate jdbcTemplate;

    public CategoriaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Categoria> findAll() {
        String sql = "SELECT * FROM Categoria";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Categoria(
                rs.getInt("ID_Categoria"),
                rs.getString("Nombre_Categoria"),
                rs.getString("Descripcion")
        ));
    }

    public Categoria findById(int id) {
        String sql = "SELECT * FROM Categoria WHERE ID_Categoria = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> new Categoria(
                rs.getInt("ID_Categoria"),
                rs.getString("Nombre_Categoria"),
                rs.getString("Descripcion")
        ));
    }

    public int save(Categoria categoria) {
        String sql = "INSERT INTO Categoria (ID_Categoria, Nombre_Categoria, Descripcion) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, categoria.getId(), categoria.getNombreCategoria(), categoria.getDescripcion());
    }

    public int update(Categoria categoria) {
        String sql = "UPDATE Categoria SET Nombre_Categoria = ?, Descripcion = ? WHERE ID_Categoria = ?";
        return jdbcTemplate.update(sql, categoria.getNombreCategoria(), categoria.getDescripcion(), categoria.getId());
    }

    public int delete(int id) {
        String sql = "DELETE FROM Categoria WHERE ID_Categoria = ?";
        return jdbcTemplate.update(sql, id);
    }
}
