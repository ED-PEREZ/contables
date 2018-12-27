/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author jose
 */
public class Conexion {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String RUTA = "jdbc:mysql://localhost:3306/sistemacontable";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    public Connection conexion;
    public Statement stament;
    public ResultSet resultado;

    public Connection abrirConexion() {
        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(RUTA, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión a la Base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return conexion;
    }

    public void cerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en cerrar la Base de Datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
