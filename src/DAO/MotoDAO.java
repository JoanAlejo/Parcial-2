package DAO;

import DB.DBConnection;
import Modelado.Moto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MotoDAO {
    public void insertarMoto(Moto m) {
        String sql = "INSERT INTO moto (marca, modelo, cilindraje, precio, tipo) VALUES (?,?,?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, m.getMarca());
            ps.setString(2, m.getModelo());
            ps.setInt(3, m.getCilindraje());
            ps.setInt(4, m.getPrecio());
            ps.setString(5, m.getTipo());

            ps.executeUpdate();
            System.out.println("Moto insertada con éxito");

        } catch (SQLException e) {
            System.err.println("Error al insertar moto: " + e.getMessage());
        }
    }
}
