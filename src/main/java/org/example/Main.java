package org.example;

import org.example.datos.pagoCrud;
import org.example.datos.propietarioCrud;
import org.example.datos.vehiculoCrud;
import org.example.modelo.pago;
import org.example.modelo.propietario;
import org.example.modelo.vehiculo;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
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
        pagoCrud opg = new pagoCrud();
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
                    System.out.println("3. Actualizar vehiculo");
                    System.out.println("4. Eliminar vehiculo");
                    System.out.println("5. Listar vehiculos");
                    System.out.println("6. Finalizar");
                    System.out.println("7. CRUD de propietario");
                    System.out.println("8. CRUD de pago");
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
                        case 7:
                            int opcionProp;
                            propietarioCrud pcrud = new propietarioCrud();

                            do {
                                System.out.println("\n CRUD de propietario \n");
                                System.out.println("1. Agregar propietario");
                                System.out.println("2. consultar propietarios");
                                System.out.println("3. Actualizar propietario");
                                System.out.println("4. Eliminar propietario");
                                System.out.println("5. Listar propietarios");
                                System.out.println("6. Volver al menú principal");
                                System.out.print("\n Seleccione una opción: ");
                                opcionProp = sc.nextInt();
                                sc.nextLine(); // limpiar buffer

                                switch (opcionProp) {
                                    case 1:
                                        System.out.print("Ingrese ID del propietario: ");
                                        String aidprop = sc.nextLine();
                                        System.out.print("Ingrese nombre del propietario: ");
                                        String anombre = sc.nextLine();
                                        System.out.print("Ingrese teléfono del propietario: ");
                                        String atelefono = sc.nextLine();
                                        propietario prop = new propietario(aidprop, anombre, atelefono);
                                        pcrud.agregarPropietario(prop);
                                        System.out.println("✔ Propietario agregado correctamente.");
                                        break;
                                    case 2:
                                        // Peticion de los datos del propietario
                                        System.out.println("Consultar propietario por ID");
                                        System.out.print("Ingrese el numero del ID: ");
                                        String cnpropietario = sc.nextLine();
                                        // Invocar al metodo para consultar propietario
                                        op.consultarPropietario(cnpropietario);
                                        break;
                                    case 3:
                                        // Peticion de los datos del propietario
                                        System.out.println("Actualizar propietario");
                                        System.out.print("Ingrese el ID del propietario: ");
                                        String uidprop = sc.nextLine();
                                        System.out.print("Ingrese el nuevo nombre: ");
                                        String unombre = sc.nextLine();
                                        System.out.print("Ingrese el nuevo telefono: ");
                                        String utelefono = sc.nextLine();
                                        // Invocar al metodo para actualizar propietario
                                        pcrud.actualizarPropietario(new propietario(uidprop, unombre, utelefono));
                                        System.out.println("Propietario actualizado correctamente...");
                                        break;
                                    case 4:
                                        // Peticion de los datos del propietario
                                        System.out.println("Eliminar propietario");
                                        System.out.print("Ingrese el ID del propietario: ");
                                        String dnpropietario = sc.nextLine();
                                        // Invocar al metodo para eliminar propietario
                                        pcrud.eliminarPropietario(dnpropietario);
                                        System.out.println("Propietario eliminado correctamente...");
                                        break;
                                    case 5:
                                        // Invocar al metodo para listar propietarios
                                        System.out.println("Listar propietarios");
                                        pcrud.consultarTodosPropietarios();
                                        break;
                                    case 6:
                                        System.out.println("Volviendo al menú principal...");
                                        break;
                                    default:
                                        System.out.println("Opción inválida.");
                                }

                            } while (opcionProp != 6);
                            break;
                        case 8:
                            int opcionpago;
                            pagoCrud pcr = new pagoCrud();
                            do {
                                System.out.println("\n CRUD de pago \n");
                                System.out.println("1. Agregar pago");
                                System.out.println("2. Consultar pago");
                                System.out.println("3. Eliminar pago");
                                System.out.println("4. Listar pagos");
                                System.out.println("5. Volver al menú principal");
                                System.out.print("\n Seleccione una opción: ");
                                opcionpago = sc.nextInt();
                                sc.nextLine(); // Limpiar buffer

                                switch (opcionpago) {
                                    case 1:
                                        System.out.print("Ingrese ID del pago: ");
                                        int pid = 0; // Inicializar a 0 para el caso de error
                                        try { // Manejo de InputMismatchException para pid
                                            pid = sc.nextInt();
                                        } catch (InputMismatchException e) {
                                            System.out.println("Error: Ingrese un número válido para el ID del pago.");
                                            sc.nextLine(); // Consumir la entrada incorrecta
                                            break; // Salir de este caso y volver al menú de pago
                                        }
                                        sc.nextLine(); // Consumir el salto de línea

                                        System.out.print("Ingrese nro de placa: ");
                                        String pnroplaca = sc.nextLine();
                                        System.out.print("Ingrese ID del propietario: ");
                                        String pidprop = sc.nextLine();

                                        LocalDate pfecha = null; // Inicializar fecha como null
                                        boolean fechaValida = false;
                                        while (!fechaValida) {
                                            System.out.print("Ingrese fecha (yyyy-MM-dd): ");
                                            String fechaStr = sc.nextLine(); // Leer como String

                                            try {
                                                pfecha = LocalDate.parse(fechaStr); // Intentar parsear
                                                fechaValida = true; // Si llega aquí, es válido
                                            } catch (DateTimeParseException e) {
                                                System.out.println("Formato de fecha incorrecto. Por favor, ingrese la fecha en formato YYYY-MM-DD (ej. 2024-05-28).");
                                                // El bucle seguirá pidiendo la fecha
                                            }
                                        }

                                        System.out.print("Ingrese valor del pago: ");
                                        int pvalor = 0; // Inicializar a 0 para el caso de error
                                        try { // Manejo de InputMismatchException para pvalor
                                            pvalor = sc.nextInt();
                                        } catch (InputMismatchException e) {
                                            System.out.println("Error: Ingrese un número válido para el valor del pago.");
                                            sc.nextLine(); // Consumir la entrada incorrecta
                                            break; // Salir de este caso y volver al menú de pago
                                        }
                                        sc.nextLine(); // Consumir el salto de línea

                                        pago pagoNuevo = new pago(pid, pnroplaca, pidprop, pfecha, pvalor);
                                        pcr.agregarPago(pagoNuevo);
                                        System.out.println("✔ Pago agregado correctamente.");
                                        break;
                                    case 2:
                                        // Peticion de los datos del pago
                                        System.out.println("Consultar pago por ID");
                                        System.out.print("Ingrese el ID del pago: ");
                                        int cpago = sc.nextInt();
                                        // Invocar al metodo para consultar pago
                                        pcr.consultarPago(cpago);
                                        break;
                                    case 3:
                                        // Peticion de los datos del pago
                                        System.out.println("Eliminar pago");
                                        System.out.print("Ingrese el ID del pago: ");
                                        int dpago = sc.nextInt();
                                        // Invocar al metodo para eliminar pago
                                        pcr.eliminarPago(dpago);
                                        System.out.println("Pago eliminado correctamente...");
                                        break;
                                    case 4:
                                        // Invocar al metodo para listar pagos
                                        System.out.println("Listar pagos");
                                        pcr.listarPagos();
                                        break;
                                    case 5:
                                        System.out.println(" Volviendo al menú principal...");
                                        break;
                                    default:
                                        System.out.println("Opción inválida.");
                                }

                            } while (opcionpago != 5);
                            break;
                    }
                }
                while (opcion !=8);
            }
        }
        catch (SQLException e){
            System.out.println("error de coneccion con MySQL");
        }
    }
}