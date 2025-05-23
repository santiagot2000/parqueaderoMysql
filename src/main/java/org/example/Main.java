package org.example;

import org.example.datos.vehiculoCrud;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Generar la coneccion al servidor y su base de datos
        vehiculoCrud ovh = new vehiculoCrud();
        // Definir variable de tipo connection
        Connection cnx = null;
        try {
            cnx = ovh.conectar();
            if (cnx != null && !cnx.isClosed()) {// credenciales correctas
                //System.out.println("Coneccion a la base de datos, Exitosa");
                // Menu para CRUD vehiculo
                Integer opcion = 0;
                do {
                    System.out.println("\n CRUD de vehiculo \n");
                    System.out.println("1. Agregar vehiculo");
                    System.out.println("2. Consultar por placa");
                    System.out.println("3. Actualizar");
                    System.out.println("4. Eliminar");
                    System.out.println("5. Listar vehiculos");
                    System.out.println("6. Finalizar");
                    System.out.print("\n opcion: ");
                    opcion = sc.nextInt();
                }
                while (opcion !=6);
            }
        }
        catch (SQLException e){
            System.out.println("error de coneccion con MySQL");
        }
    }
}