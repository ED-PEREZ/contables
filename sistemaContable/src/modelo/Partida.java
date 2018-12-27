/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Timestamp;

/**
 *
 * @author Pérez
 */
public class Partida {
    private int idpartida;
    private int numpartida;
    private Timestamp fecha;
    private String concepto;

    public Partida(int numpartida, Timestamp fecha, String concepto) {
        this.idpartida = 0;
        this.numpartida = numpartida;
        this.fecha = fecha;
        this.concepto = concepto;
    }

    public Partida() {
    }

    public int getIdpartida() {
        return idpartida;
    }

    public void setIdpartida(int idpartida) {
        this.idpartida = idpartida;
    }

    public int getNumpartida() {
        return numpartida;
    }

    public void setNumpartida(int numpartida) {
        this.numpartida = numpartida;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
    
}
