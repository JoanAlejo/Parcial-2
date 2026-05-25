package DAO;

import DB.DBConnection;
import Modelado.Moto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MotoDAO {
    public void insertarMoto(Moto m) {//metodo basado en el del repo del profe
        String sql = "INSERT INTO moto (marca, modelo, cilindraje, precio, tipo) VALUES (?,?,?,?,?)"; //defiminos el statement del sql para darle valores despues

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) { //para darle valores creamos un objeto PreparedStatement y le pasamos el string

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
    public List<Moto> consultarTodas() {

        List<Moto> lista = new ArrayList<>();
        String sql = "SELECT * FROM moto";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement(); //como no hay valores hay que crear un statement fijo
             ResultSet rs = st.executeQuery(sql)) { //Como se trata de de SELECT en SQL se usa executeQuery

            while (rs.next()) {

                Moto m = new Moto(
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("cilindraje"),
                        rs.getInt("precio"),
                        rs.getString("tipo")
                );

                lista.add(m);
            }

        } catch (SQLException e) {
            System.err.println("Error al consultar motos: " + e.getMessage());
        }

        return lista;
    }
}

