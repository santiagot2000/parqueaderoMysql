package org.example.datos;

import org.example.modelo.vehiculo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class vehiculoCrud {
    //credenciales para tener acceso a mysql y la BD dbparquea
    private final String url = "jdbc:mysql://localhost:3306/dbparquea";
    private final String user = "root";
    private final String password = "";
    // Metodo para realizar la conecceion a la base de datos
    public Connection conectar()throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    // Metodos para el CRUD de vehiculo
    // Agregar vehiculo
    public void agregarVehiculo(vehiculo vehiculo) {
        String sql = "INSERT INTO vehiculo (nroplaca, marca, precio) VALUES (?, ?, ?)";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, vehiculo.getNroplaca());
            stmt.setString(2, vehiculo.getMarca());
            stmt.setInt(3, vehiculo.getPrecio());
            stmt.executeUpdate();// Agrega el vehiculo
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void consultarVehiculo(String cnroplaca) {
        String sql = "SELECT * FROM vehiculo WHERE nroplaca = ?";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cnroplaca);
            var rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Vehiculo encontrado:");
                System.out.println("Numero de Placa: " + rs.getString("nroplaca"));
                System.out.println("Marca: " + rs.getString("marca"));
                System.out.println("Precio: " + rs.getInt("precio"));
            } else {
                System.out.println("Vehiculo no encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
    }
}
    // Actualizar vehiculo
    public void actualizarVehiculo(vehiculo vehiculo) {
        String sql = "UPDATE vehiculo SET marca = ?, precio = ? WHERE nroplaca = ?";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, vehiculo.getMarca());
            stmt.setInt(2, vehiculo.getPrecio());
            stmt.setString(3, vehiculo.getNroplaca());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Eliminar vehiculo
    public void eliminarVehiculo(String cnroplaca) {
        String sql = "DELETE FROM vehiculo WHERE nroplaca = ?";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cnroplaca);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Listar vehiculos
    public List<vehiculo> listarVehiculos() {
        List<vehiculo> vehiculos = new ArrayList<vehiculo>();
        String sql = "SELECT * FROM vehiculo";

        try (Connection conn = conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                vehiculo vehiculo = new vehiculo(
                        rs.getString("nroplaca"),
                        rs.getString("marca"),
                        rs.getInt("precio")
                );
                vehiculos.add(vehiculo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehiculos;
    }
}



