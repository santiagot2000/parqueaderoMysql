package org.example.datos;

import org.example.modelo.pago;
import org.example.modelo.propietario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class pagoCrud {
    //credenciales para tener acceso a mysql y la BD dbparquea
    private final String url = "jdbc:mysql://localhost:3306/dbparquea";
    private final String user = "root";
    private final String password = "";
    // Metodo para realizar la conecceion a la base de datos
    public Connection conectar()throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    // Metodos para el CRUD de pago
    // Agregar pago
    public void agregarPago(pago pago) {
        String sql = "INSERT INTO vehiculo (id, nroplaca, idprop, fecha, valor) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pago.getId());
            stmt.setString(2, pago.getNroplaca());
            stmt.setString(3, pago.getIdprop());
            stmt.setDate(4, java.sql.Date.valueOf(pago.getFecha()));
            stmt.setInt(5, pago.getValor());
            stmt.executeUpdate();// Agregar pago
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //consultar pago
    public void consultarPago(int id) {
        String sql = "SELECT * FROM pago WHERE id = ?";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            var rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Pago encontrado:");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nro Placa: " + rs.getString("nroplaca"));
                System.out.println("ID Propietario: " + rs.getString("idprop"));
                System.out.println("Fecha: " + rs.getDate("fecha"));
                System.out.println("Valor: " + rs.getInt("valor"));
            } else {
                System.out.println("Pago no encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Eliminar pago
    public void eliminarPago(int id) {
        String sql = "DELETE FROM pago WHERE id = ?";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Pago eliminado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // listar pagos
    public void listarPagos() {
        String sql = "SELECT * FROM pago";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            var rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nro Placa: " + rs.getString("nroplaca"));
                System.out.println("ID Propietario: " + rs.getString("idprop"));
                System.out.println("Fecha: " + rs.getDate("fecha"));
                System.out.println("Valor: " + rs.getInt("valor"));
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
