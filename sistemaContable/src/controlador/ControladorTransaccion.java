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

    public void AgregarTransaccion(Transaccion tr) {
        try {
            conexion.abrirConexion();
            Statement st = conexion.abrirConexion().createStatement();
            String sql = "INSERT INTO transaccion(idtransaccion,monto, "
                    + "operacion, idcuenta, idpartida) VALUES "
                    + "(" + null + ",'" + tr.getMonto() + "','" + tr.getOperacion() + "','" + tr.getIdcuenta() + "','" + tr.getIdpartida() + "')";
            st.executeUpdate(sql);
            System.out.println("TRANSACCION HECHA");
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Double buscar(int idP, int idC) {
        Double p = 0.0;
        try {
            conexion.abrirConexion();
            Statement st = conexion.abrirConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT\n"
                    + "*\n"
                    + "FROM\n"
                    + "transaccion\n"
                    + "WHERE\n"
                    + "transaccion.idcuenta = " + idC + " AND\n"
                    + "transaccion.idpartida = " + idP + "");
            while (rs.next()) {
                p = rs.getDouble(2);

            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.out.println(e);
        }
        return p;
    }

    public void delete() {
        try {
            conexion.abrirConexion();
            Statement st = conexion.abrirConexion().createStatement();
            String sql = "DELETE FROM transaccion ";
            st.executeUpdate(sql);
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
