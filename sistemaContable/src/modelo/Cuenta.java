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
public class Cuenta {
    private Integer id;
    private String codigo;
    private String nombre;
    private String tipoSaldo;
    private Double saldo;
    private Integer idOrden;
    private String Descripcion;
    private Integer nivel;
    private String tipoCuenta;
    private String movimiento;

    public Cuenta(String codigo, String nombre, String tipoSaldo, Double saldo, Integer idOrden, String Descripcion, Integer nivel, String tipoCuenta, String movimiento) {
        this.id = 0;
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipoSaldo = tipoSaldo;
        this.saldo = saldo;
        this.idOrden = idOrden;
        this.Descripcion = Descripcion;
        this.nivel = nivel;
        this.tipoCuenta = tipoCuenta;
        this.movimiento = movimiento;
    }



    public Cuenta() {
        this.id=id;
        this.codigo = "";
        this.nombre = "";
        this.tipoSaldo = "";
        this.saldo = 0.0;
        this.idOrden = 0;
        this.Descripcion = "";
        this.nivel=0;
        this.movimiento="";
        this.tipoCuenta="";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTipoSaldo() {
        return tipoSaldo;
    }

    public void setTipoSaldo(String tipoSaldo) {
        this.tipoSaldo = tipoSaldo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }
    
    
        
}
