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
    public void consultarPropietario(String idprop) {
        String sql = "SELECT * FROM propietario WHERE idprop = ?";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idprop);
            var rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Propietario encontrado:");
                System.out.println("ID Propietario: " + rs.getString("idprop"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Telefono: " + rs.getString("telefono"));
            } else {
                System.out.println("Propietario no encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Actualizar propietario
    public void actualizarPropietario(propietario propetario) {
        String sql = "UPDATE propietario SET nombre = ?, telefono = ? WHERE idprop = ?";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, propetario.getNombre());
            stmt.setString(2, propetario.getTelefono());
            stmt.setString(3, propetario.getIdprop());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Eliminar propietario
    public void eliminarPropietario(String idprop) {
        String sql = "DELETE FROM propietario WHERE idprop = ?";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idprop);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Consultar todos los propietarios
    public void consultarTodosPropietarios() {
        String sql = "SELECT * FROM propietario";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            var rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID Propietario: " + rs.getString("idprop"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Telefono: " + rs.getString("telefono"));
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
