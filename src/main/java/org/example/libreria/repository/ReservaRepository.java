package org.example.libreria.repository;

import org.example.libreria.model.Reserva;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservaRepository {
    private final JdbcTemplate jdbcTemplate;

    public ReservaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Reserva> findAll() {
        String sql = "SELECT * FROM Reserva";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Reserva(
                rs.getInt("ID_Reserva"),
                rs.getInt("ID_Usuario"),
                rs.getInt("ID_Libro"),
                rs.getDate("Fecha_Reserva").toLocalDate()
        ));
    }

    public Reserva findById(int id) {
        String sql = "SELECT * FROM Reserva WHERE ID_Reserva = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> new Reserva(
                rs.getInt("ID_Reserva"),
                rs.getInt("ID_Usuario"),
                rs.getInt("ID_Libro"),
                rs.getDate("Fecha_Reserva").toLocalDate()
        ));
    }

    public int save(Reserva reserva) {
        String sql = "INSERT INTO Reserva (ID_Reserva, ID_Usuario, ID_Libro, Fecha_Reserva) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, reserva.getId(), reserva.getIdUsuario(), reserva.getIdLibro(), reserva.getFechaReserva());
    }

    public int update(Reserva reserva) {
        String sql = "UPDATE Reserva SET ID_Usuario = ?, ID_Libro = ?, Fecha_Reserva = ? WHERE ID_Reserva = ?";
        return jdbcTemplate.update(sql, reserva.getIdUsuario(), reserva.getIdLibro(), reserva.getFechaReserva(), reserva.getId());
    }

    public int delete(int id) {
        String sql = "DELETE FROM Reserva WHERE ID_Reserva = ?";
        return jdbcTemplate.update(sql, id);
    }
}
