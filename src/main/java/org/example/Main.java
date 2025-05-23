package org.example;

import org.example.datos.vehiculoCrud;

import java.sql.Connection;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Generar la coneccion al servidor y su base de datos
        vehiculoCrud ovh = new vehiculoCrud();
        // Definir variable de tipo connection
        Connection cnx = null;
        try {
            cnx = ovh.conectar();
            if (cnx != null && !cnx.isClosed()) {
                System.out.println("Coneccion a la base de datos, Exitosa");
            }
        }
        catch (SQLException e){
            System.out.println("error de coneccion con MySQL");
        }
    }
}