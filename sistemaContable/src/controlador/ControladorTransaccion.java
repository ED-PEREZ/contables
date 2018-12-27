/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import modelo.*;
/**
 *
 * @author Pérez
 */
public class ControladorTransaccion {
    public Conexion conexion;

    public ControladorTransaccion() {
        conexion = new Conexion();
        PreparedStatement st = null;
    }
    
    public void AgregarTransaccion(Transaccion tr){
        try {
            conexion.abrirConexion();
            Statement st = conexion.abrirConexion().createStatement();
            String sql = "INSERT INTO transaccion(idtransaccion,monto, "
                    + "operacion, idcuenta, idpartida) VALUES "
                    + "("+null+",'"+tr.getMonto()+"','"+tr.getOperacion()+"','"+tr.getIdcuenta()+"','"+tr.getIdpartida()+"')";
            st.executeUpdate(sql);
            System.out.println("TRANSACCION HECHA");
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
