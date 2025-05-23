package org.example.datos;

import java.sql.Connection;
import java.sql.DriverManager;
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
}
