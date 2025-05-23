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
}
