/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author jose
 */
public class Datos {
    private String codigo;
    private String nombre;
    private Double debe;
    private Double haber;

    public Datos(String codigo, String nombre, Double debe, Double haber) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.debe = debe;
        this.haber = haber;
    }

    public Datos() {
    }
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getDebe() {
        return debe;
    }

    public void setDebe(Double debe) {
        this.debe = debe;
    }

    public Double getHaber() {
        return haber;
    }

    public void setHaber(Double haber) {
        this.haber = haber;
    }
    
    
    
}
