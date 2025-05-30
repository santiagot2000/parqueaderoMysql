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
            ResultSet rs = stmt.executeQuery();
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
        List<vehiculo> buscarVehiculos = new ArrayList<vehiculo>();
        String query = "SELECT * FROM vehiculo";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Nro Placa: " + rs.getString("nroplaca"));
                System.out.println("Marca: " + rs.getString("marca"));
                System.out.println("precio: " + rs.getInt("precio"));
                System.out.println("---------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buscarVehiculos;
    }
    // Buscar vehiculo por placa
    public List<vehiculo> buscarVehiculoxplaca(String nroplaca) {
        List<vehiculo> lbuscarplaca = new ArrayList<>();
        //declara una loista para ser trtornada y contendra
        String query = "SELECT nroplaca, marca, precio FROM vehiculo WHERE nroplaca = ?";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nroplaca);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                vehiculo vh = new vehiculo(
                        rs.getString("nroplaca"),
                        rs.getString("marca"),
                        rs.getInt("precio")
                );
                //agregar el vehiculo a la lista
                lbuscarplaca.add(vh);
            }
        } catch (SQLException eror) {
            eror.printStackTrace();
        }
        return lbuscarplaca;
    }
}



