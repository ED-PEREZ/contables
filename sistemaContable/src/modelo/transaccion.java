/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Pérez
 */
public class Transaccion {
    private int idtransaccion;
    private int idpartida;
    private int idcuenta;
    private double monto;
    private int operacion;

    public Transaccion(int idpartida, int idcuenta, double monto, int operacion) {
        this.idtransaccion = 0;
        this.idpartida = idpartida;
        this.idcuenta = idcuenta;
        this.monto = monto;
        this.operacion = operacion;
    }

    public Transaccion() {
    }

    public int getIdtransaccion() {
        return idtransaccion;
    }

    public void setIdtransaccion(int idtransaccion) {
        this.idtransaccion = idtransaccion;
    }

    public int getIdpartida() {
        return idpartida;
    }

    public void setIdpartida(int idpartida) {
        this.idpartida = idpartida;
    }

    public int getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(int idcuenta) {
        this.idcuenta = idcuenta;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getOperacion() {
        return operacion;
    }

    public void setOperacion(int operacion) {
        this.operacion = operacion;
    }
    
}
