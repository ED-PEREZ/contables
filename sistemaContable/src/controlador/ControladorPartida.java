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
public class ControladorPartida {
    public Conexion conexion;

    public ControladorPartida() {
        conexion = new Conexion();
        PreparedStatement st = null;
    }
    
    public void agregarPartida(Partida pda) {
        try {
            conexion.abrirConexion();
            Statement st = conexion.abrirConexion().createStatement();
            String sql = "INSERT INTO partida(numpartida, fecha, concepto) "
                    + "VALUES ("+pda.getNumpartida()+","+pda.getFecha()+","+pda.getConcepto()+")";
            st.executeUpdate(sql);
            System.out.println("PDA AGREGADA");
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Partida numeroPartida() {
        try {
            Partida p = null;
            conexion.abrirConexion();
            Statement st = conexion.abrirConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT max(numpartida) FROM partida");
            while (rs.next()) {
                p = new Partida();
                p.setNumpartida(rs.getInt(1));
            }
            System.out.println("PDA"+p.getNumpartida());
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
