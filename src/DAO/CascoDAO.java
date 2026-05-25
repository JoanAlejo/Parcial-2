package DAO;

import DB.DBConnection;
import Modelado.Casco;
import Modelado.Moto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CascoDAO {
    public void insertarCasco(Casco c) { //metodo basado en el del repo del profe
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
    public List<Casco> consultarTodas() {

        List<Casco> lista = new ArrayList<>();
        String sql = "SELECT * FROM casco";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                Casco c = new Casco(
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("talla"),
                        rs.getString("certificacion"),
                        rs.getInt("precio")
                );

                lista.add(c);
            }

        } catch (SQLException e) {
            System.err.println("Error al consultar cascos: " + e.getMessage());
        }

        return lista;
    }
    public Casco consultarUno(int id) {

        String sql = "SELECT * FROM casco WHERE id = ?";
        Casco c = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                c = new Casco(
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("talla"),
                        rs.getString("certificacion"),
                        rs.getInt("precio")
                );
            }

        } catch (SQLException e) {
            System.err.println("Error al consultar casco: " + e.getMessage());
        }

        return c;
    }
    public List<Casco> filtrarPorPresupuesto(int presupuesto) {

        List<Casco> lista = new ArrayList<>();
        String sql = "SELECT * FROM casco WHERE precio <= ?";//le pedimos al cliente su presupuesto maximo para mostrarle los otros cascos

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, presupuesto);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Casco c = new Casco(
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("talla"),
                        rs.getString("certificacion"),
                        rs.getInt("precio")
                );

                lista.add(c);
            }

        } catch (SQLException e) {
            System.err.println("Error al filtrar por presupuesto: " + e.getMessage());
        }

        return lista;
    }
}

