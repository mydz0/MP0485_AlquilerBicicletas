/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package alquilerbicicletas;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author steph
 */
public class AlquilerBicicletas {

    private static Empleado empleado;
    private static final ArrayList<Cliente> clientes = new ArrayList<>();
    private static final ArrayList<Bicicleta> bicicletas = new ArrayList<>();    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //Solicitar los datos del empleado.
        Scanner sc = new Scanner(System.in);
        System.out.println("     Datos del empleado    ");
        System.out.println("===========================");
        System.out.println("Nombre: ");
        String nombreEmpleado = sc.nextLine();
        System.out.println("Apellido: ");
        String apellidoEmpleado = sc.nextLine();

        //Crear el objeto empleado.
        empleado = new Empleado(nombreEmpleado, apellidoEmpleado);

        //Mostrar el mensaje:
        System.out.println("Bienvenido/a " + empleado.toString());

        //Menú de gestión del alquiler 
        //El programa mostrará un menú repetitivo con las siguientes opciones:
        //Dar de alta bicicleta, Registrar cliente, Realizar alquiler, 
        //Mostrar datos de un cliente, Finalizar alquiler, Salir del programa.
        int opc;

        do {
            opc = menu();
            switch (opc) {
                case 1:
                    altaBicicleta();
                    break;
                case 2:
                    registrarCliente();
                    break;
                case 3:
                    realizarAlquiler();
                    break;
                case 4:
                    System.out.println("\n--- MOSTRAR DATOS CLIENTE ---");
                    System.out.println("Introduzca DNI de cliente");
                    String dni = sc.nextLine();
                    mostrarDatosCliente(dni);
                    break;
                case 5:
                    System.out.println("\n--- FINALIZAR ALQUILER ---");
                    System.out.println("Introduzca ID de la bicicleta alquilada");
                    String idBici = sc.nextLine();
                    finalizarAlquiler(idBici);
                    break;
                case 6:
                    salirPrograma();
                    break;

            }
        } while (opc != 6);

    }

    public static int menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- MENU ---");
        System.out.println("1. Dar de alta bicicleta");
        System.out.println("2. Registrar cliente");
        System.out.println("3. Realizar alquiler");
        System.out.println("4. Mostrar datos de un cliente");
        System.out.println("5. Finalizar alquiler");
        System.out.println("6. Salir del programa");
        System.out.println();
        System.out.print("Seleccione una opcion: ");
        int opc = sc.nextInt();
        System.out.println();
        return opc;
    }

    public static void altaBicicleta() {
        //Pedir los datos por consola.
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- DAR DE ALTA BICICLETA ---");
        System.out.println("ID de la bicicleta: ");
        String idBici = sc.nextLine();
        System.out.println("Tipo de bicicleta: ");
        String tipoBici = sc.nextLine();
        System.out.println("Bicicleta disponible (si | no) ");
        String libre = sc.nextLine();

        boolean disponible = false;
        if (libre.equalsIgnoreCase("si")) {
            disponible = true;
        } else if (libre.equalsIgnoreCase("no")) {
            disponible = false;
        }

        //Añadir la bicicleta al listado global.
        bicicletas.add(new Bicicleta(idBici, tipoBici, disponible));

    }

    public static void registrarCliente() {
        //Pedir los datos por consola.
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- REGISTRAR CLIENTE ---");
        System.out.println("Nombre cliente: ");
        String nombreCliente = sc.nextLine();
        System.out.println("DNI cliente: ");
        String dniCliente = sc.nextLine();

        ArrayList<Alquiler> alquileres = new ArrayList<>();
        boolean registrado = false;

        //comprueba si en la lista alquileres tiene hisorial
        for (Alquiler alquiler : alquileres) {
            if (alquiler != null) {
                System.err.println("Cliente ya esta registrado en el sistema");
                registrado = true;
                break;
            }
        }

        //si no tiene ninguna bici alquilada y es nuevo miembro, lo añade a la lista clientes
        if (!registrado) {
            System.out.println("Cliente registrado correctamente");
            clientes.add(new Cliente(nombreCliente, dniCliente, new ArrayList<>()));
            //alquileres es null, ya que solo estamos registrando el cliente
        }

    }

    public static void realizarAlquiler() {
        //Solicitar DNI del cliente.
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- REALIZAR ALQUILER ---");
        System.out.println("Introduzca DNI de cliente");
        String dniCliente = sc.nextLine();
        boolean registrado = false;
        for (Cliente cliente : clientes) {
            //si encuentra el dni, pregunta por el id de la bici
            if (cliente.getDNI().contentEquals(dniCliente)) {
                System.out.println("Introduzca ID de la bicicleta: ");
                String idBici = sc.nextLine();  
                registrado = true;

                boolean altaBici = false;
                for (Bicicleta bicicleta : bicicletas) {
                    //si encuentra el id de la bici, intro num horas para alquilar
                    if (bicicleta.getId().contentEquals(idBici)) {
                        System.out.println("Introduzca numero de horas: ");
                        int horas = sc.nextInt();
                        //intro horas, poner bici como no disponible
                        double precio = horas * 20.00;

                        if (bicicleta.isDisponible()) {
                            //añade nuevo alquiler
                            Alquiler alquiler = new Alquiler(bicicleta, horas, precio);
                            cliente.getAlquileres().add(alquiler);
                            bicicleta.setDisponible(false);

                            System.out.println("Bicicleta alquilada correctamente");
                            altaBici = true;
                            break;
                        }

                        if (!bicicleta.isDisponible()) {
                            System.err.println("La bicicleta no esta disponible");
                            altaBici = true;
                            break;
                        }
                    }
                }
                if (!altaBici) {
                    System.err.println("La bicicleta no esta dada de alta");
                }
            }
        }
        if (!registrado) {
            System.err.println("El cliente no esta registrado");
        }
    }

    public static void mostrarDatosCliente(String dni) {
        boolean registrado = false;

        for (Cliente cliente : clientes) {
            //si encuentra el dni, pregunta por el id de la bici
            if (cliente.getDNI().contentEquals(dni)) {
                System.out.println(cliente.toString());
                registrado = true;
                break;
            }
        }

        if (!registrado) {
            System.err.println("El cliente no esta registrado");
        }

    }

    public static void finalizarAlquiler(String idBici) {
        boolean altaBici = false;
        for (Bicicleta bicicleta : bicicletas) {
            if (bicicleta.getId().contentEquals(idBici)) {
                bicicleta.setDisponible(true);
                System.out.println("La bicicleta esta disponible");
                altaBici = true;
            }
        }

        if (!altaBici) {
            System.err.println("La bicicleta no esta dada de alta");
        }
    }

    public static void salirPrograma() {
        System.out.println("Sesion finalizada");

    }

}
