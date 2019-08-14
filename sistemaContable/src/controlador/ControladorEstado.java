/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.Cuenta;
import modelo.Datos;
import modelo.Estado;
import modelo.Partida;
import modelo.Transaccion;

/**
 *
 * @author jose
 */
public class ControladorEstado {

    public Conexion conexion;

    public ControladorEstado() {
        conexion = new Conexion();
        PreparedStatement st = null;
    }

    public void generarEstado() {
        Partida num = new controlador.ControladorPartida().buscarConcepto("V/por determinar el inventario final");
        Partida inicioAjuste = new controlador.ControladorPartida().buscarConcepto("V/por liquidar rebajas y dev s/ventas");
        if (new controlador.ControladorPartida().buscarConcepto("V/por liquidar rebajas y dev s/ventas") == null) {
            inicioAjuste = new controlador.ControladorPartida().buscarConcepto("V/por liquidar gastos sobre compras");
            if (new controlador.ControladorPartida().buscarConcepto("V/por liquidar gastos sobre compras") == null) {
                inicioAjuste = new controlador.ControladorPartida().buscarConcepto("V/por liquidar rebajas y dev s/compras");
                if (new controlador.ControladorPartida().buscarConcepto("V/por liquidar gastos sobre compras") == null) {
                    inicioAjuste = new controlador.ControladorPartida().buscarConcepto("V/por liquidar inventario inicial");
                }
            }
        }
        int fin = 0;
        int inicio = 0;
        if (num != null) {
            inicio = inicioAjuste.getNumpartida();
            fin = num.getNumpartida();
            Double invenFinal = new ControladorTransaccion().buscar(num.getIdpartida(), obtenerId("1108"));

            ArrayList<Datos> cuentas = lista(inicio);
            if (!cuentas.isEmpty()) {
                Estado estado = new Estado();
                for (Datos cuenta : cuentas) {
                    if (cuenta.getCodigo().equals("1108")) {
                        estado.setInventarioinicial(cuenta.getDebe());
                        estado.setInventariofinal(invenFinal);
                    } else if (cuenta.getCodigo().equals("4101")) {
                        estado.setVentas(cuenta.getHaber() - cuenta.getDebe());
                    } else if (cuenta.getCodigo().equals("4103R") || cuenta.getCodigo().equals("4104R")) {
                        estado.setDevventas(estado.getDevventas() + (cuenta.getDebe() - cuenta.getHaber()));
                    } else if (cuenta.getCodigo().equals("5102")) {
                        estado.setCompras(cuenta.getDebe() - cuenta.getHaber());
                    } else if (cuenta.getCodigo().equals("5103")) {
                        estado.setGastcompras(cuenta.getDebe() - cuenta.getHaber());
                    } else if (cuenta.getCodigo().equals("5104R") || cuenta.getCodigo().equals("5105R")) {
                        estado.setDevcompras(estado.getDevcompras() + (cuenta.getHaber() - cuenta.getDebe()));
                    } else if (cuenta.getCodigo().equals("6101")) {
                        estado.setGastoadmini(cuenta.getDebe() - cuenta.getHaber());
                    } else if (cuenta.getCodigo().equals("6102")) {
                        estado.setGastoventa(cuenta.getDebe() - cuenta.getHaber());
                    } else if (cuenta.getCodigo().equals("6201")) {
                        estado.setGastofinanciero(cuenta.getDebe() - cuenta.getHaber());
                    } else if (cuenta.getCodigo().equals("4105")) {
                        estado.setOtroingreso(cuenta.getHaber() - cuenta.getDebe());
                    } else if (cuenta.getCodigo().equals("6103")) {
                        estado.setOtrogasto(cuenta.getDebe() - cuenta.getHaber());
                    }

                }
                agregarEstado(estado);
            } else {
                agregarEstado(new Estado());
            }
        } else {
            ArrayList<Datos> cuentas = lista2();
            if (!cuentas.isEmpty()) {
                Estado estado = new Estado();
                for (Datos cuenta : cuentas) {
                    if (cuenta.getCodigo().equals("1108")) {
                        estado.setInventarioinicial(cuenta.getDebe());
                        try {
                            Double fi = Double.parseDouble(JOptionPane.showInputDialog(null, "Introduzca el valor del inventario final!"));
                            estado.setInventariofinal(fi);
                        } catch (Exception e) {
                        }
                    } else if (cuenta.getCodigo().equals("4101")) {
                        estado.setVentas(cuenta.getHaber() - cuenta.getDebe());
                    } else if (cuenta.getCodigo().equals("4103R") || cuenta.getCodigo().equals("4104R")) {
                        estado.setDevventas(estado.getDevventas() + (cuenta.getDebe() - cuenta.getHaber()));
                    } else if (cuenta.getCodigo().equals("5102")) {
                        estado.setCompras(cuenta.getDebe() - cuenta.getHaber());
                    } else if (cuenta.getCodigo().equals("5103")) {
                        estado.setGastcompras(cuenta.getDebe() - cuenta.getHaber());
                    } else if (cuenta.getCodigo().equals("5104R") || cuenta.getCodigo().equals("5105R")) {
                        estado.setDevcompras(estado.getDevcompras() + (cuenta.getHaber() - cuenta.getDebe()));
                    } else if (cuenta.getCodigo().equals("6101")) {
                        estado.setGastoadmini(cuenta.getDebe() - cuenta.getHaber());
                    } else if (cuenta.getCodigo().equals("6102")) {
                        estado.setGastoventa(cuenta.getDebe() - cuenta.getHaber());
                    } else if (cuenta.getCodigo().equals("6201")) {
                        estado.setGastofinanciero(cuenta.getDebe() - cuenta.getHaber());
                    } else if (cuenta.getCodigo().equals("4105")) {
                        estado.setOtroingreso(cuenta.getHaber() - cuenta.getDebe());
                    } else if (cuenta.getCodigo().equals("6103")) {
                        estado.setOtrogasto(cuenta.getDebe() - cuenta.getHaber());
                    }

                }
                agregarEstado(estado);
            } else {
                agregarEstado(new Estado());
            }
        }
    }

    public void partidasAjuste() {
        ControladorPartida cp = new ControladorPartida();
        ControladorTransaccion ct = new ControladorTransaccion();

        Partida pa = cp.numeroPartida();
        Date f = new Date();
        Timestamp fts = new Timestamp(f.getYear(), 11, 31, f.getHours(), f.getMinutes(), f.getSeconds(), f.getSeconds());

        if (pa != null) {
            int inicio = pa.getNumpartida();
            Estado estado = getEstado();
            if (estado.getVentas() != 0.0) {
                inicio++;
                if (estado.getDevventas() != 0.0) {
                    Partida v = new Partida(inicio, fts, "V/por liquidar rebajas y dev s/ventas");
                    cp.agregarPartida(v);
                    int numPartida = cp.idpart(v);
                    Transaccion t = new Transaccion(numPartida, obtenerId("4101"), estado.getDevventas(), 1);
                    ct.AgregarTransaccion(t);
                    if (getDevVentas() != 0.0) {
                        Transaccion deVen = new Transaccion(numPartida, obtenerId("4103R"), getDevVentas(), 2);
                        ct.AgregarTransaccion(deVen);
                    }
                    if (getRebVentas() != 0.0) {
                        Transaccion reVen = new Transaccion(numPartida, obtenerId("4104R"), getRebVentas(), 2);
                        ct.AgregarTransaccion(reVen);
                    }
                }
            }

            if (estado.getGastcompras() != 0) {
                inicio++;
                Partida gC = new Partida(inicio, fts, "V/por liquidar gastos sobre compras");
                cp.agregarPartida(gC);
                int numPartida = cp.idpart(gC);
                Transaccion t = new Transaccion(numPartida, obtenerId("5102"), estado.getGastcompras(), 1);
                ct.AgregarTransaccion(t);
                Transaccion gastoCo = new Transaccion(numPartida, obtenerId("5103"), estado.getGastcompras(), 2);
                ct.AgregarTransaccion(gastoCo);
            }

            if (estado.getDevcompras() != 0.0) {
                inicio++;

                Partida v = new Partida(inicio, fts, "V/por liquidar rebajas y dev s/compras");
                cp.agregarPartida(v);
                int numPartida = cp.idpart(v);
                Transaccion t = new Transaccion(numPartida, obtenerId("5102"), estado.getDevcompras(), 2);
                ct.AgregarTransaccion(t);
                if (getDevCompras() != 0.0) {
                    Transaccion deVen = new Transaccion(numPartida, obtenerId("5104R"), getDevCompras(), 1);
                    ct.AgregarTransaccion(deVen);
                }
                if (getRebCompras() != 0.0) {
                    Transaccion reVen = new Transaccion(numPartida, obtenerId("5105R"), getRebCompras(), 1);
                    ct.AgregarTransaccion(reVen);
                }
            }

            if (estado.getInventarioinicial() != 0.0) {
                inicio++;
                Partida invIni = new Partida(inicio, fts, "V/por liquidar inventario inicial");
                cp.agregarPartida(invIni);
                int numPartida = cp.idpart(invIni);
                Transaccion t = new Transaccion(numPartida, obtenerId("5102"), estado.getInventarioinicial(), 1);
                ct.AgregarTransaccion(t);
                Transaccion ini = new Transaccion(numPartida, obtenerId("1108"), estado.getInventarioinicial(), 2);
                ct.AgregarTransaccion(ini);
            }

            if (estado.getInventariofinal() != 0.0) {
                inicio++;
                Partida invFin = new Partida(inicio, fts, "V/por determinar el inventario final");
                cp.agregarPartida(invFin);
                int numPartida = cp.idpart(invFin);
                Transaccion t = new Transaccion(numPartida, obtenerId("1108"), estado.getInventariofinal(), 1);
                ct.AgregarTransaccion(t);
                Transaccion ini = new Transaccion(numPartida, obtenerId("5102"), estado.getInventariofinal(), 2);
                ct.AgregarTransaccion(ini);
            }

            if (costoVendido(estado) != 0.0) {
                inicio++;
                Partida c = new Partida(inicio, fts, "V/por liquidar compras");
                cp.agregarPartida(c);
                int numPartida = cp.idpart(c);
                Transaccion t = new Transaccion(numPartida, obtenerId("4101"), costoVendido(estado), 1);
                ct.AgregarTransaccion(t);
                Transaccion ini = new Transaccion(numPartida, obtenerId("5102"), costoVendido(estado), 2);
                ct.AgregarTransaccion(ini);
            }

            if (utilidaBruta(estado) != 0.0) {
                inicio++;
                Partida c = new Partida(inicio, fts, "V/por traspaso de la utilidad,impuesto y Reserva como provision");
                cp.agregarPartida(c);
                int numPartida = cp.idpart(c);
                Transaccion t = new Transaccion(numPartida, obtenerId("4101"), utilidaBruta(estado), 1);
                ct.AgregarTransaccion(t);
                if (impuesto(estado) != 0) {
                    Transaccion im = new Transaccion(numPartida, obtenerId("2101"), impuesto(estado), 2);
                    ct.AgregarTransaccion(im);
                }
                if (reservaLegal(estado) != 0) {
                    Transaccion im = new Transaccion(numPartida, obtenerId("3201"), reservaLegal(estado), 2);
                    ct.AgregarTransaccion(im);
                }

                Transaccion ini = new Transaccion(numPartida, obtenerId("7101"), utilidaBruta(estado) - impuesto(estado) - reservaLegal(estado), 2);
                ct.AgregarTransaccion(ini);
            }

            if (estado.getGastoadmini() + estado.getGastoventa() + estado.getGastofinanciero() != 0.0) {
                inicio++;
                Partida c = new Partida(inicio, fts, "V/por liquidar gastos de operacion");
                cp.agregarPartida(c);
                int numPartida = cp.idpart(c);
                Transaccion t = new Transaccion(numPartida, obtenerId("7101"), estado.getGastoadmini() + estado.getGastoventa() + estado.getGastofinanciero(), 1);
                ct.AgregarTransaccion(t);
                if (estado.getGastoadmini() != 0.0) {
                    Transaccion ini = new Transaccion(numPartida, obtenerId("6101"), estado.getGastoadmini(), 2);
                    ct.AgregarTransaccion(ini);
                }
                if (estado.getGastoventa() != 0.0) {
                    Transaccion ini = new Transaccion(numPartida, obtenerId("6102"), estado.getGastoventa(), 2);
                    ct.AgregarTransaccion(ini);
                }
                if (estado.getGastofinanciero() != 0.0) {
                    Transaccion ini = new Transaccion(numPartida, obtenerId("6201"), estado.getGastofinanciero(), 2);
                    ct.AgregarTransaccion(ini);
                }
            }

            if (estado.getOtrogasto() != 0.0) {
                inicio++;
                Partida c = new Partida(inicio, fts, "V/por liquidar otros gastos");
                cp.agregarPartida(c);
                int numPartida = cp.idpart(c);
                Transaccion t = new Transaccion(numPartida, obtenerId("7101"), estado.getOtrogasto(), 1);
                ct.AgregarTransaccion(t);
                Transaccion ini = new Transaccion(numPartida, obtenerId("6103"), estado.getOtrogasto(), 2);
                ct.AgregarTransaccion(ini);
            }
            if (estado.getOtroingreso() != 0.0) {
                inicio++;
                Partida c = new Partida(inicio, fts, "V/por liquidar otros ingresos");
                cp.agregarPartida(c);
                int numPartida = cp.idpart(c);
                Transaccion t = new Transaccion(numPartida, obtenerId("4105"), estado.getOtroingreso(), 1);
                ct.AgregarTransaccion(t);
                Transaccion ini = new Transaccion(numPartida, obtenerId("7101"), estado.getOtroingreso(), 2);
                ct.AgregarTransaccion(ini);
            }
            if (utilidadOperdida(estado) < 0) {
                inicio++;
                Partida c = new Partida(inicio, fts, "V/por saldar la perdida del ejercicio");
                cp.agregarPartida(c);
                int numPartida = cp.idpart(c);
                Transaccion t = new Transaccion(numPartida, obtenerId("3101"), utilidadOperdida(estado), 1);
                ct.AgregarTransaccion(t);
                Transaccion ini = new Transaccion(numPartida, obtenerId("7101"), utilidadOperdida(estado), 2);
                ct.AgregarTransaccion(ini);
            } else {
                inicio++;
                Partida c = new Partida(inicio, fts, "V/por trasladar la utilidad a capital");
                cp.agregarPartida(c);
                int numPartida = cp.idpart(c);
                Transaccion t = new Transaccion(numPartida, obtenerId("7101"), utilidadOperdida(estado), 1);
                ct.AgregarTransaccion(t);
                Transaccion ini = new Transaccion(numPartida, obtenerId("3101"), utilidadOperdida(estado), 2);
                ct.AgregarTransaccion(ini);
            }
        } else {
        }

    }

    public void partidaCierre() {

        ControladorPartida cp = new ControladorPartida();
        ControladorTransaccion ct = new ControladorTransaccion();
        generarEstado();
        partidasAjuste();
        Partida pa = cp.numeroPartida();
        Date f = new Date();
        Timestamp fts = new Timestamp(f.getYear(), 11, 31, f.getHours(), f.getMinutes(), f.getSeconds(), f.getSeconds());
        ArrayList<Datos> lista = lista2();

        Partida c = new Partida(pa.getNumpartida() + 1, fts, "V/por cierre del ejercicio");
        cp.agregarPartida(c);
        int numPartida = cp.idpart(c);
        for (Datos datos : lista) {
            if (datos.getDebe() - datos.getHaber() > 0) {
                Transaccion t = new Transaccion(numPartida, obtenerId(datos.getCodigo()), datos.getDebe() - datos.getHaber(), 2);
                ct.AgregarTransaccion(t);
            } else if (datos.getDebe() - datos.getHaber() < 0) {
                Transaccion t = new Transaccion(numPartida, obtenerId(datos.getCodigo()), datos.getHaber() - datos.getDebe(), 1);
                ct.AgregarTransaccion(t);
            }
        }

    }

    public Double costoVendido(Estado e) {
        return e.getCompras() + e.getGastcompras() - e.getDevcompras() + e.getInventarioinicial() - e.getInventariofinal();
    }

    public Double utilidaBruta(Estado e) {
        return e.getVentas() - e.getDevventas() - costoVendido(e);
    }

    public Double utilidadOperacion(Estado e) {
        return utilidaBruta(e) - e.getGastoadmini() - e.getGastoventa() - e.getGastofinanciero();
    }

    public Double utilidadAntesRyI(Estado e) {
        return utilidadOperacion(e) - e.getOtrogasto() + e.getOtroingreso();
    }

    public Double reservaLegal(Estado e) {
        if (utilidadAntesRyI(e) < 0) {
            return 0.0;
        } else {
            return utilidadAntesRyI(e) * 0.07;
        }
    }

    public Double utilidadAntesI(Estado e) {
        return utilidadAntesRyI(e) - reservaLegal(e);
    }

    public Double impuesto(Estado e) {
        if (utilidadAntesI(e) < 0) {
            return 0.0;
        } else {
            if (e.getVentas() < 150000) {
                return utilidadAntesI(e) * 0.25;
            } else {
                return utilidadAntesI(e) * 0.30;
            }
        }
    }

    public Double utilidadOperdida(Estado e) {
        return utilidadAntesI(e) - impuesto(e);
    }

    public Integer obtenerId(String auxi) {
        Integer idCuenta = null;
        try {
            conexion.abrirConexion();
            Statement st = conexion.abrirConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT idcuenta FROM cuenta WHERE codigo='" + auxi + "'");

            while (rs.next()) {
                idCuenta = rs.getInt(1);
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.out.println(e);
        }
        return idCuenta;
    }

    public Double getDevVentas() {
        ArrayList<Datos> cuentas = lista2();
        for (Datos cuenta : cuentas) {
            if (cuenta.getCodigo().equals("4103R")) {
                return cuenta.getDebe();
            }
        }
        return 0.0;
    }

    public Double getRebVentas() {
        ArrayList<Datos> cuentas = lista2();
        for (Datos cuenta : cuentas) {
            if (cuenta.getCodigo().equals("4104R")) {
                return cuenta.getDebe();
            }
        }
        return 0.0;
    }

    public Double getDevCompras() {
        ArrayList<Datos> cuentas = lista2();
        for (Datos cuenta : cuentas) {
            if (cuenta.getCodigo().equals("5104R")) {
                return cuenta.getHaber();
            }
        }
        return 0.0;
    }

    public Double getRebCompras() {
        ArrayList<Datos> cuentas = lista2();
        for (Datos cuenta : cuentas) {
            if (cuenta.getCodigo().equals("5105R")) {
                return cuenta.getHaber();
            }
        }
        return 0.0;
    }

    public void agregarEstado(Estado estado) {
        eliminar();
        try {
            conexion.abrirConexion();
            Statement st = conexion.abrirConexion().createStatement();
            String sql = "INSERT INTO estado(ventas, devventas, compras, gastcompras, devcompras, inventarioinicial, inventariofinal, gastoadmini, gastoventa, gastofinanciero, otrogasto, otroingreso) VALUES (" + estado.getVentas() + "," + estado.getDevventas() + "," + estado.getCompras() + "," + estado.getGastcompras() + "," + estado.getDevcompras() + "," + estado.getInventarioinicial() + "," + estado.getInventariofinal() + "," + estado.getGastoadmini() + "," + estado.getGastoventa() + "," + estado.getGastofinanciero() + "," + estado.getOtrogasto() + "," + estado.getOtroingreso() + ")";
            st.executeUpdate(sql);
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void eliminar() {
        try {
            this.conexion.abrirConexion();
            Statement st = this.conexion.abrirConexion().createStatement();
            st.executeUpdate("DELETE FROM estado ");
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.out.println("ERROR AL ELIMINAR " + e);
        }
    }

    public Estado getEstado() {
        Estado objeto = new Estado();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.abrirConexion();
            String sql = "SELECT\n"
                    + "*\n"
                    + "FROM\n"
                    + "estado";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                objeto.setVentas(rs.getDouble(2));
                objeto.setDevventas(rs.getDouble(3));
                objeto.setCompras(rs.getDouble(4));
                objeto.setGastcompras(rs.getDouble(5));
                objeto.setDevcompras(rs.getDouble(6));
                objeto.setInventarioinicial(rs.getDouble(7));
                objeto.setInventariofinal(rs.getDouble(8));
                objeto.setGastoadmini(rs.getDouble(9));
                objeto.setGastoventa(rs.getDouble(10));
                objeto.setGastofinanciero(rs.getDouble(11));
                objeto.setOtrogasto(rs.getDouble(12));
                objeto.setOtroingreso(rs.getDouble(13));

            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return objeto;
    }

    public ArrayList<Datos> lista(int nump) {
        ArrayList<Datos> lista = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.abrirConexion();
            String sql = "SELECT\n"
                    + "cuenta.idcuenta,\n"
                    + "cuenta.codigo,\n"
                    + "cuenta.nombre,\n"
                    + "CASE when \n"
                    + " (SELECT\n"
                    + "Sum(transaccion.monto) AS debe\n"
                    + "FROM\n"
                    + "transaccion\n"
                    + "INNER JOIN partida ON transaccion.idpartida = partida.idpartida\n"
                    + "WHERE\n"
                    + "transaccion.operacion = 1 AND partida.numpartida< " + nump + " AND\n"
                    + "transaccion.idcuenta = cuenta.idcuenta \n"
                    + ") is null   then 0  else (SELECT\n"
                    + "Sum(transaccion.monto) AS debe\n"
                    + "FROM\n"
                    + "transaccion\n"
                    + "INNER JOIN partida ON transaccion.idpartida = partida.idpartida\n"
                    + "WHERE\n"
                    + "transaccion.operacion = 1 AND partida.numpartida< " + nump + " AND\n"
                    + "transaccion.idcuenta = cuenta.idcuenta \n"
                    + ") end as debe\n"
                    + "\n"
                    + " ,\n"
                    + "CASE when \n"
                    + " (SELECT\n"
                    + "Sum(transaccion.monto) AS debe\n"
                    + "FROM\n"
                    + "transaccion\n"
                    + "INNER JOIN partida ON transaccion.idpartida = partida.idpartida\n"
                    + "WHERE\n"
                    + "transaccion.operacion = 2 AND partida.numpartida< " + nump + " AND\n"
                    + "transaccion.idcuenta = cuenta.idcuenta \n"
                    + ") is null   then 0  else (SELECT\n"
                    + "Sum(transaccion.monto) AS debe\n"
                    + "FROM\n"
                    + "transaccion\n"
                    + "INNER JOIN partida ON transaccion.idpartida = partida.idpartida\n"
                    + "WHERE\n"
                    + "transaccion.operacion = 2 AND partida.numpartida< " + nump + " AND\n"
                    + "transaccion.idcuenta = cuenta.idcuenta \n"
                    + ") end as haber\n"
                    + "\n"
                    + "\n"
                    + "FROM\n"
                    + "cuenta\n"
                    + "INNER JOIN transaccion ON transaccion.idcuenta = cuenta.idcuenta\n"
                    + "WHERE\n"
                    + "cuenta.nivel = 3 \n"
                    + "GROUP BY\n"
                    + "cuenta.idcuenta";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Datos da = new Datos();
                da.setCodigo(rs.getString(2));
                da.setNombre(rs.getString(3));
                da.setDebe(rs.getDouble(4));
                da.setHaber(rs.getDouble(5));
                lista.add(da);
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public ArrayList<Datos> lista2() {
        ArrayList<Datos> lista = new ArrayList<>();
        ResultSet rs = null;
        try {
            Connection accesoDB = conexion.abrirConexion();
            String sql = "SELECT\n"
                    + "cuenta.idcuenta,\n"
                    + "cuenta.codigo,\n"
                    + "cuenta.nombre,\n"
                    + "CASE when \n"
                    + " (SELECT\n"
                    + "Sum(transaccion.monto) AS debe\n"
                    + "FROM\n"
                    + "transaccion\n"
                    + "WHERE\n"
                    + "transaccion.operacion = 1 AND\n"
                    + "transaccion.idcuenta = cuenta.idcuenta\n"
                    + ") is null   then 0  else (SELECT\n"
                    + "Sum(transaccion.monto) AS debe\n"
                    + "FROM\n"
                    + "transaccion\n"
                    + "WHERE\n"
                    + "transaccion.operacion = 1 AND\n"
                    + "transaccion.idcuenta = cuenta.idcuenta\n"
                    + ") end as debe\n"
                    + "\n"
                    + " ,\n"
                    + "CASE when \n"
                    + " (SELECT\n"
                    + " Sum(transaccion.monto)  AS debe\n"
                    + "FROM\n"
                    + "transaccion\n"
                    + "WHERE\n"
                    + "transaccion.operacion = 2 AND\n"
                    + "transaccion.idcuenta = cuenta.idcuenta\n"
                    + ") is null   then 0  else (SELECT\n"
                    + " Sum(transaccion.monto)  AS debe\n"
                    + "FROM\n"
                    + "transaccion\n"
                    + "WHERE\n"
                    + "transaccion.operacion = 2 AND\n"
                    + "transaccion.idcuenta = cuenta.idcuenta\n"
                    + ") end as haber\n"
                    + "\n"
                    + "\n"
                    + "FROM\n"
                    + "cuenta\n"
                    + "INNER JOIN transaccion ON transaccion.idcuenta = cuenta.idcuenta\n"
                    + "WHERE\n"
                    + "cuenta.nivel = 3 \n"
                    + "GROUP BY\n"
                    + "cuenta.idcuenta";
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Datos da = new Datos();
                da.setCodigo(rs.getString(2));
                da.setNombre(rs.getString(3));
                da.setDebe(rs.getDouble(4));
                da.setHaber(rs.getDouble(5));
                lista.add(da);
            }
            conexion.cerrarConexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public void delete() {
        try {
            conexion.abrirConexion();
            Statement st = conexion.abrirConexion().createStatement();
            String sql = "DELETE FROM estado ";
            st.executeUpdate(sql);
            conexion.cerrarConexion();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
