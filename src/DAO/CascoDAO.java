package DAO;

import DB.DBConnection;
import Modelado.Casco;
import Modelado.Moto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CascoDAO {
    public void insertarCasco(Casco c) {
        String sql = "INSERT INTO casco (marca, modelo, talla, certificacion, precio) VALUES (?,?,?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getMarca());
            ps.setString(2, c.getModelo());
            ps.setString(3, c.getTalla());
            ps.setString(4, c.getCertificacion());
            ps.setInt(5, c.getPrecio());

            ps.executeUpdate();
            System.out.println("Casco insertado con éxito");

        } catch (SQLException e) {
            System.err.println("Error al insertar casco: " + e.getMessage());
        }
    }
}
