/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informe;

import controlador.ControladorPartida;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;
import modelo.Conexion;
import modelo.Partida;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author jose
 */
public class MostrarReportes {

    public Conexion conexion;

    public MostrarReportes() {
        conexion = new Conexion();
        PreparedStatement st = null;
    }

    public void BalanzaDeComprobacion() {
        try {

            Connection cn = conexion.abrirConexion(); // aquí obtengo la conexión
            Map<String, Object> param = new HashMap<String, Object>(); //aquí construyo un HashMap para parámetros adicionales
//param.put("parametro 1", "el parametro" ); //ejemplo de parámetro de HashMap
            JasperReport jr = (JasperReport) JRLoader.loadObject("src/informe/BalanzaDeComprobacion.jasper");
            InputStream stream = this.getClass().getResourceAsStream("BalanzaDeComprobacion.jasper");//aquí le pones la ruta de tu reporte;

            JasperPrint print = print = JasperFillManager.fillReport(stream, param, cn); //aquí le envías el stream, tu HashMap y la conexión a la Base de datos
            JasperViewer n = new JasperViewer(print, false); //generas tu visor del reporte
            n.setVisible(true); //lo haces visible 
        } catch (JRException e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    public void BalanceGeneral() {
        try {
            ControladorPartida cp = new ControladorPartida();
            Partida num = cp.numeroPartida();
            int fi = 0;
            if (num.getNumpartida()>0) {
                num.setConcepto(new controlador.ControladorPartida().concepto(num.getNumpartida()).getConcepto());
                if (num.getConcepto().equals("V/por cierre del ejercicio")) {
                    fi = num.getNumpartida();
                }
            }
            Connection cn = conexion.abrirConexion(); // aquí obtengo la conexión
            Map<String, Object> param = new HashMap<String, Object>(); //aquí construyo un HashMap para parámetros adicionales
            param.put("ultimP", fi); //ejemplo de parámetro de HashMap
            JasperReport jr = (JasperReport) JRLoader.loadObject("src/informe/BalanzaDeComprobacion.jasper");
            InputStream stream = this.getClass().getResourceAsStream("BalanceG.jasper");//aquí le pones la ruta de tu reporte;

            JasperPrint print = print = JasperFillManager.fillReport(stream, param, cn); //aquí le envías el stream, tu HashMap y la conexión a la Base de datos
            JasperViewer n = new JasperViewer(print, false); //generas tu visor del reporte
            n.setVisible(true); //lo haces visible 
        } catch (JRException e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    public void LibroDiario() {
        try {

            Connection cn = conexion.abrirConexion(); // aquí obtengo la conexión
            Map<String, Object> param = new HashMap<String, Object>(); //aquí construyo un HashMap para parámetros adicionales
//param.put("parametro 1", "el parametro" ); //ejemplo de parámetro de HashMap
            InputStream stream = this.getClass().getResourceAsStream("LibroDiario.jasper");//aquí la ruta de tu reporte;

            JasperPrint print = print = JasperFillManager.fillReport(stream, param, cn); //aquí se envías el stream,  HashMap y la conexión a la Base de datos
            JasperViewer n = new JasperViewer(print, false); //generas tu visor del reporte
            n.setVisible(true); //se hace visible 
        } catch (JRException e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    public void LibroMayor() {
        try {

            Connection cn = conexion.abrirConexion(); // aquí obtengo la conexión
            Map<String, Object> param = new HashMap<String, Object>(); //aquí construyo un HashMap para parámetros adicionales
//param.put("parametro 1", "el parametro" ); //ejemplo de parámetro de HashMap
            InputStream stream = this.getClass().getResourceAsStream("LibroMayor.jasper");//aquí la ruta de tu reporte;

            JasperPrint print = print = JasperFillManager.fillReport(stream, param, cn); //aquí se envías el stream,  HashMap y la conexión a la Base de datos
            JasperViewer n = new JasperViewer(print, false); //generas tu visor del reporte
            n.setVisible(true); //se hace visible 
        } catch (JRException e) {
            System.out.println("error: " + e.getMessage());
        }
    }
    public void Catalogo() {
        try {

            Connection cn = conexion.abrirConexion(); // aquí obtengo la conexión
            Map<String, Object> param = new HashMap<String, Object>(); //aquí construyo un HashMap para parámetros adicionales
//param.put("parametro 1", "el parametro" ); //ejemplo de parámetro de HashMap
            JasperReport jr = (JasperReport) JRLoader.loadObject("src/informe/Catalogo.jasper");
            InputStream stream = this.getClass().getResourceAsStream("Catalogo.jasper");//aquí le pones la ruta de tu reporte;

            JasperPrint print = print = JasperFillManager.fillReport(stream, param, cn); //aquí le envías el stream, tu HashMap y la conexión a la Base de datos
            JasperViewer n = new JasperViewer(print, false); //generas tu visor del reporte
            n.setVisible(true); //lo haces visible 
        } catch (JRException e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    public void Estado() {
        try {

            Connection cn = conexion.abrirConexion(); // aquí obtengo la conexión
            Map<String, Object> param = new HashMap<String, Object>(); //aquí construyo un HashMap para parámetros adicionales
//param.put("parametro 1", "el parametro" ); //ejemplo de parámetro de HashMap
            JasperReport jr = (JasperReport) JRLoader.loadObject("src/informe/Estado.jasper");
            InputStream stream = this.getClass().getResourceAsStream("Estado.jasper");//aquí le pones la ruta de tu reporte;

            JasperPrint print = print = JasperFillManager.fillReport(stream, param, cn); //aquí le envías el stream, tu HashMap y la conexión a la Base de datos
            JasperViewer n = new JasperViewer(print, false); //generas tu visor del reporte
            n.setVisible(true); //lo haces visible 
        } catch (JRException e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}
