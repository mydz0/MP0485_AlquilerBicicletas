/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alquilerbicicletas;

/**
 *
 * @author steph
 */
class Bicicleta {

    private String id;
    private String tipo;
    private boolean disponible;

    public Bicicleta(String id, String tipo, boolean disponible) {
        this.id = id;
        this.tipo = tipo;
        this.disponible = disponible;
    }

    public String getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "\nid: " + id + "\nTipo: " + tipo + "\nDsponible: " + disponible;
    }
    
    

}
