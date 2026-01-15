/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alquilerbicicletas;

/**
 *
 * @author steph
 */
public class Alquiler {
    
    private Bicicleta bicicleta;
    private int horas;
    private double precio = 20.00;

    public Alquiler(Bicicleta bicicleta, int horas, double precio) {
        this.bicicleta = bicicleta;
        this.horas = horas;
        this.precio = precio;
    }

    public Bicicleta getBicicleta() {
        return bicicleta;
    }

    public int getHoras() {
        return horas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setBicicleta(Bicicleta bicicleta) {
        this.bicicleta = bicicleta;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public void setPrecio(double precio) {
        this.precio = precio * horas;
    }

    @Override
    public String toString() {
        
        return "\nBicicleta: " + bicicleta + "\nHoras: " + horas + "\nPrecio: " + precio;
    }
    
    
    
    
}
