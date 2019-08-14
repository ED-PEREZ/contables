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
public class Estado {
    private Double ventas;
    private Double devventas;
    private Double compras;
    private Double gastcompras;
    private Double devcompras;
    private Double inventarioinicial;
    private Double inventariofinal;
    private Double gastoadmini;
    private Double gastoventa;
    private Double gastofinanciero;
    private Double otrogasto;
    private Double otroingreso;

    public Estado(Double ventas, Double devventas, Double compras, Double gastcompras, Double devcompras, Double inventarioinicial, Double inventariofinal, Double gastoadmini, Double gastoventa, Double gastofinanciero, Double otrogasto, Double otroingreso) {
        this.ventas = ventas;
        this.devventas = devventas;
        this.compras = compras;
        this.gastcompras = gastcompras;
        this.devcompras = devcompras;
        this.inventarioinicial = inventarioinicial;
        this.inventariofinal = inventariofinal;
        this.gastoadmini = gastoadmini;
        this.gastoventa = gastoventa;
        this.gastofinanciero = gastofinanciero;
        this.otrogasto = otrogasto;
        this.otroingreso = otroingreso;
    }

    public Estado() {
        this.ventas = 0.0;
        this.devventas = 0.0;
        this.compras = 0.0;
        this.gastcompras = 0.0;
        this.devcompras = 0.0;
        this.inventarioinicial = 0.0;
        this.inventariofinal = 0.0;
        this.gastoadmini = 0.0;
        this.gastoventa = 0.0;
        this.gastofinanciero = 0.0;
        this.otrogasto = 0.0;
        this.otroingreso = 0.0;
        
        
    }

    public Double getVentas() {
        return ventas;
    }

    public void setVentas(Double ventas) {
        this.ventas = ventas;
    }

    public Double getDevventas() {
        return devventas;
    }

    public void setDevventas(Double devventas) {
        this.devventas = devventas;
    }

    public Double getCompras() {
        return compras;
    }

    public void setCompras(Double compras) {
        this.compras = compras;
    }

    public Double getGastcompras() {
        return gastcompras;
    }

    public void setGastcompras(Double gastcompras) {
        this.gastcompras = gastcompras;
    }

    public Double getDevcompras() {
        return devcompras;
    }

    public void setDevcompras(Double devcompras) {
        this.devcompras = devcompras;
    }

    public Double getInventarioinicial() {
        return inventarioinicial;
    }

    public void setInventarioinicial(Double inventarioinicial) {
        this.inventarioinicial = inventarioinicial;
    }

    public Double getInventariofinal() {
        return inventariofinal;
    }

    public void setInventariofinal(Double inventariofinal) {
        this.inventariofinal = inventariofinal;
    }

    public Double getGastoadmini() {
        return gastoadmini;
    }

    public void setGastoadmini(Double gastoadmini) {
        this.gastoadmini = gastoadmini;
    }

    public Double getGastoventa() {
        return gastoventa;
    }

    public void setGastoventa(Double gastoventa) {
        this.gastoventa = gastoventa;
    }

    public Double getGastofinanciero() {
        return gastofinanciero;
    }

    public void setGastofinanciero(Double gastofinanciero) {
        this.gastofinanciero = gastofinanciero;
    }

    public Double getOtrogasto() {
        return otrogasto;
    }

    public void setOtrogasto(Double otrogasto) {
        this.otrogasto = otrogasto;
    }

    public Double getOtroingreso() {
        return otroingreso;
    }

    public void setOtroingreso(Double otroingreso) {
        this.otroingreso = otroingreso;
    }
    
    
}
