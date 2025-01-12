package org.example.libreria.repository;

import org.example.libreria.model.UsuarioBiblioteca;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioBibliotecaRepository {
    private final JdbcTemplate jdbcTemplate;

    public UsuarioBibliotecaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<UsuarioBiblioteca> findAll() {
        String sql = "SELECT * FROM Usuario_Biblioteca";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new UsuarioBiblioteca(
                rs.getInt("ID_Usuario"),
                rs.getString("Nombre"),
                rs.getString("Correo_Electronico"),
                rs.getDate("Fecha_Registro").toLocalDate(),
                rs.getString("Tipo_Usuario")
        ));
    }

    public UsuarioBiblioteca findById(int id) {
        String sql = "SELECT * FROM Usuario_Biblioteca WHERE ID_Usuario = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> new UsuarioBiblioteca(
                rs.getInt("ID_Usuario"),
                rs.getString("Nombre"),
                rs.getString("Correo_Electronico"),
                rs.getDate("Fecha_Registro").toLocalDate(),
                rs.getString("Tipo_Usuario")
        ));
    }

    public int save(UsuarioBiblioteca usuario) {
        String sql = "INSERT INTO Usuario_Biblioteca (ID_Usuario, Nombre, Correo_Electronico, Fecha_Registro, Tipo_Usuario) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, usuario.getId(), usuario.getNombre(), usuario.getCorreoElectronico(), usuario.getFechaRegistro(), usuario.getTipoUsuario());
    }

    public int update(UsuarioBiblioteca usuario) {
        String sql = "UPDATE Usuario_Biblioteca SET Nombre = ?, Correo_Electronico = ?, Fecha_Registro = ?, Tipo_Usuario = ? WHERE ID_Usuario = ?";
        return jdbcTemplate.update(sql, usuario.getNombre(), usuario.getCorreoElectronico(), usuario.getFechaRegistro(), usuario.getTipoUsuario(), usuario.getId());
    }

    public int delete(int id) {
        String sql = "DELETE FROM Usuario_Biblioteca WHERE ID_Usuario = ?";
        return jdbcTemplate.update(sql, id);
    }
}
