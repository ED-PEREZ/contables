/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
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

    public boolean agregarPartida(Partida pda) {
        String estado = "FALLIDO";
        int ico = JOptionPane.ERROR_MESSAGE;
        try {
            conexion.abrirConexion();
            Statement st = conexion.abrirConexion().createStatement();
            String sql = "INSERT INTO partida(idpartida,numpartida, fecha, concepto) "
                    + "VALUES (" + null + "," + pda.getNumpartida() + ",'" + pda.getFecha() + "','" + pda.getConcepto() + "');";
            st.executeUpdate(sql);
            System.out.println("PDA AGREGADA");
            conexion.cerrarConexion();
            estado = "EXITOSO";
            ico = JOptionPane.INFORMATION_MESSAGE;
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        JOptionPane.showMessageDialog(null, "CREACION DE LA PARTIDA " + estado, estado, ico);
        return false;
    }

    public Partida numeroPartida() {
        Partida p = null;
        try {
            conexion.abrirConexion();
            Statement st = conexion.abrirConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT max(numpartida) FROM partida");
            while (rs.next()) {
                p = new Partida();
                p.setNumpartida(rs.getInt(1));
            }
            System.out.println("PDA" + p.getNumpartida());
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.out.println(e);
        }
        return p;
    }

    public int idpart(Partida pda) {
        int id = 0;
        try {
            conexion.abrirConexion();
            Statement st = conexion.abrirConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT idpartida FROM partida WHERE "
                    + "numpartida = '" + pda.getNumpartida() + "' AND fecha='" + pda.getFecha() + "' "
                    + "AND concepto = '" + pda.getConcepto() + "'");
            while (rs.next()) {
                id = rs.getInt(1);
            }
            System.out.println("PDA ID" + id);
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.out.println(e);
        }
        return id;
    }
}
