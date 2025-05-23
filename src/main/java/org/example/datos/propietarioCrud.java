package org.example.datos;

import org.example.modelo.propietario;
import org.example.modelo.vehiculo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class propietarioCrud {
    //credenciales para tener acceso a mysql y la BD dbparquea
    private final String url = "jdbc:mysql://localhost:3306/dbparquea";
    private final String user = "root";
    private final String password = "";
    // Metodo para realizar la conecceion a la base de datos
    public Connection conectar()throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    // Metodos para el CRUD de propietario
    // Agregar propietario
    public void agregarPropietario(propietario propetario) {
        String sql = "INSERT INTO vehiculo (idprop, nombre, telefono) VALUES (?, ?, ?)";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, propetario.getIdprop());
            stmt.setString(2, propetario.getNombre());
            stmt.setString(3, propetario.getTelefono());
            stmt.executeUpdate();// Agrega el propietario
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
