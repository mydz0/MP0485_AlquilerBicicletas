/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alquilerbicicletas;

import java.util.ArrayList;

/**
 *
 * @author steph
 */
public class Cliente {

    private String nombre;
    private String DNI;
    private ArrayList<Alquiler> alquileres = new ArrayList<>();

    public Cliente(String nombre, String DNI, ArrayList<Alquiler> alquileres) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.alquileres = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public ArrayList<Alquiler> getAlquileres() {
        return alquileres;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setAlquileres(ArrayList<Alquiler> alquileres) {
        this.alquileres = alquileres;
    }

    @Override
    public String toString() {
        for (Alquiler alquiler : alquileres) {
            if (alquileres != null) {
                alquileres.toString();
            }
        }
        return "\nCliente: " + nombre + "\nDNI: " + DNI + "\nAlqiuleres: " + alquileres;
    }

}
