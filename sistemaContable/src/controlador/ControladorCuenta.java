/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import modelo.Conexion;
import modelo.Cuenta;
import java.util.ArrayList;
import java.util.concurrent.locks.StampedLock;
import javax.swing.JOptionPane;

/**
 *
 * @author jose
 */
public class ControladorCuenta {

    public Conexion conexion;

    public ControladorCuenta() {
        conexion = new Conexion();
        PreparedStatement st = null;
    }

    public void AgregarCuenta(Cuenta cuentita) {
        try {
            conexion.abrirConexion();
            Statement st = conexion.abrirConexion().createStatement();
            String sql = "INSERT INTO cuenta (codigo,nombre,tiposaldo,idorden,nivel,movimiento,tipocuenta) VALUES"
                    + " ('" + cuentita.getCodigo() + "','" + cuentita.getNombre() + "','" + cuentita.getTipoSaldo() + "'," + cuentita.getIdOrden() + "," + cuentita.getNivel() + ",'"+cuentita.getMovimiento()+"','"+cuentita.getTipoCuenta()+"')";
            st.executeUpdate(sql);
            System.out.println("CTA AGREGADA");
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Boolean Verificar(Integer auxi) {
        Integer idCuenta = null, codigo = null;
        try {
            conexion.abrirConexion();
            Statement st = conexion.abrirConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT idcuenta,codigo FROM cuenta WHERE codigo="
                    + "" + auxi + "");

            while (rs.next()) {
                idCuenta = rs.getInt(1);
                codigo = rs.getInt(2);
            }
            System.out.println("VALOR: " + idCuenta);
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.out.println(e);
        }
        if (codigo == auxi) {
            return true;
        }
        return false;
    }

    public Integer obtenerId(Integer auxi) {
        Integer idCuenta = null, codigo = null;
        try {
            conexion.abrirConexion();
            Statement st = conexion.abrirConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT idcuenta,codigo FROM cuenta WHERE codigo="
                    + "" + auxi + "");

            while (rs.next()) {
                idCuenta = rs.getInt(1);
                codigo = rs.getInt(2);
            }
            System.out.println("VALOR: " + idCuenta);
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.out.println(e);
        }
        return idCuenta;
    }

    public ArrayList<Cuenta> obtenerCuentas() {
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.abrirConexion();
            String sql = "SELECT * FROM cuenta ORDER BY codigo ASC";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cuenta cuenta = new Cuenta();
                cuenta.setId(rs.getInt("idcuenta"));
                cuenta.setCodigo(rs.getString("codigo"));
                cuenta.setNombre(rs.getString("nombre"));
                cuenta.setTipoSaldo(rs.getString("tiposaldo"));
                cuenta.setNivel(rs.getInt("nivel"));
                cuenta.setTipoCuenta(rs.getString("tipocuenta"));
                cuenta.setMovimiento(rs.getString("movimiento"));
                cuentas.add(cuenta);
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return cuentas;
    }

    public void eliminar(String codigo) {
        try {
            this.conexion.abrirConexion();
            Statement st = this.conexion.abrirConexion().createStatement();
            String a="DELETE FROM estado ";
            st.executeUpdate("DELETE FROM cuenta WHERE codigo='" + codigo + "'");
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.out.println("ERROR AL ELIMINAR " + e);
        }
    }

    public Cuenta buscarCuenta(String codigo) {
        Cuenta cuenta = new Cuenta();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.abrirConexion();
            String sql = "SELECT * FROM cuenta WHERE codigo= '" + codigo + "'";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cuenta.setId(rs.getInt("idcuenta"));
                cuenta.setCodigo(rs.getString("codigo"));
                cuenta.setNombre(rs.getString("nombre"));
                cuenta.setTipoSaldo(rs.getString("tiposaldo"));
                cuenta.setNivel(rs.getInt("nivel"));
                cuenta.setTipoCuenta(rs.getString("tipocuenta"));
                cuenta.setMovimiento(rs.getString("movimiento"));
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return cuenta;
    }

    public void ModificarCuenta(Cuenta cuenta) {
        try {
            conexion.abrirConexion();
            Statement ps = conexion.abrirConexion().createStatement();
            String up = "UPDATE cuenta SET nombre='"+cuenta.getNombre()+"', tiposaldo='"+cuenta.getTipoSaldo()+"' WHERE codigo='" + cuenta.getCodigo()+ "'";
            ps.executeUpdate(up);
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.out.println("ERROR AL MODIFICAR LA CUENTA " + e);
        }
    }

    public Cuenta obtenerCuentaU(String codigo) {
        Cuenta cuenta = new Cuenta();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.abrirConexion();
            String sql = "SELECT * FROM cuenta Where codigo='" + codigo + "'";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cuenta.setId(rs.getInt("idcuenta"));
                cuenta.setCodigo(rs.getString("codigo"));
                cuenta.setNombre(rs.getString("nombre"));
                cuenta.setTipoSaldo(rs.getString("tiposaldo"));
                cuenta.setNivel(rs.getInt("nivel"));
                cuenta.setTipoCuenta(rs.getString("tipocuenta"));
                cuenta.setMovimiento(rs.getString("movimiento"));
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return cuenta;

    }

    public Boolean Existe(String codigo) {
        Cuenta cuenta = new Cuenta();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.abrirConexion();
            String sql = "SELECT * FROM cuenta WHERE codigo= '" + codigo + "'";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cuenta.setId(rs.getInt("idcuenta"));
                cuenta.setCodigo(rs.getString("codigo"));
                cuenta.setNombre(rs.getString("nombre"));
                cuenta.setTipoSaldo(rs.getString("tiposaldo"));
                cuenta.setNivel(rs.getInt("nivel"));
                cuenta.setTipoCuenta(rs.getString("tipocuenta"));
                cuenta.setMovimiento(rs.getString("movimiento"));
                if (cuenta.getCodigo().equals(codigo)) {
                    return true;
                }
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

}
