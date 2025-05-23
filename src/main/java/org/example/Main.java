package org.example;

import org.example.datos.propietarioCrud;
import org.example.datos.vehiculoCrud;
import org.example.modelo.vehiculo;

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
        propietarioCrud op = new propietarioCrud();
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
                    sc.nextLine(); // se obliga a nexInt a hacer un salto de linea o enter
                    switch (opcion){
                        case 1:
                            // Peticion de los datos del vehiculo
                            System.out.println("Agregar vehiculo");
                            System.out.print("Ingrese el numero de placa: ");
                            String anroplaca = sc.nextLine();
                            System.out.print("Ingrese la marca: ");
                            String amarca = sc.nextLine();
                            System.out.print("Ingrese el precio: ");
                            int aprecio = sc.nextInt();
                            // Invocar al metodo para agregar vehiculo
                            ovh.agregarVehiculo(new vehiculo(anroplaca, amarca, aprecio));
                            System.out.println("Vehiculo agregado correctamente...");
                            break;
                        case  2:
                            // Peticion de los datos del vehiculo
                            System.out.println("Consultar vehiculo por placa");
                            System.out.print("Ingrese el numero de placa: ");
                            String cnroplaca = sc.nextLine();
                            // Invocar al metodo para consultar vehiculo
                            ovh.consultarVehiculo(cnroplaca);
                            break;
                        case 3:
                            // Peticion de los datos del vehiculo
                            System.out.println("Actualizar vehiculo");
                            System.out.print("Ingrese el numero de placa: ");
                            String unroplaca = sc.nextLine();
                            System.out.print("Ingrese la nueva marca: ");
                            String umarca = sc.nextLine();
                            System.out.print("Ingrese el nuevo precio: ");
                            int uprecio = sc.nextInt();
                            // Invocar al metodo para actualizar vehiculo
                            ovh.actualizarVehiculo(new vehiculo(unroplaca, umarca, uprecio));
                            System.out.println("Vehiculo actualizado correctamente...");
                            break;
                        case 4:
                            // Peticion de los datos del vehiculo
                            System.out.println("Eliminar vehiculo");
                            System.out.print("Ingrese el numero de placa: ");
                            String dnrplaca = sc.nextLine();
                            // Invocar al metodo para eliminar vehiculo
                            ovh.eliminarVehiculo(dnrplaca);
                            System.out.println("Vehiculo eliminado correctamente...");
                            break;
                        case 5:
                            // Invocar al metodo para listar vehiculos
                            System.out.println("Listar vehiculos");
                            ovh.listarVehiculos();
                            break;
                        case 6:
                            System.out.println("Saliendo del programa...");
                            break;
                    }
                }
                while (opcion !=6);
            }
        }
        catch (SQLException e){
            System.out.println("error de coneccion con MySQL");
        }
    }
}