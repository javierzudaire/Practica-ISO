/*
 * Javier Zudaire
 */
package interfaz;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseAccess {

    private Connection conexion;
    private Statement myStatement;
    private String mysqlURL;

    protected DatabaseAccess() {

        try {
            Class.forName("org.sqlite.JDBC");
            mysqlURL = "jdbc:sqlite:database.db";
            conexion = DriverManager.getConnection(mysqlURL);
            myStatement = conexion.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static DatabaseAccess instance = null;

    public static DatabaseAccess getInstance() {
        if (instance == null) {
            instance = new DatabaseAccess();

        }
        return instance;
    }

    public int comprobarUsuario(String user) throws SQLException {

        ResultSet result = myStatement.executeQuery("SELECT EXISTS(SELECT contra FROM usuarios WHERE usuario = '" + user + "')");
        int exists = result.getInt(1);

        return exists;

    }

    public String obtenerContraseña(String user) throws SQLException {

        ResultSet result = myStatement.executeQuery("SELECT contra FROM usuarios WHERE usuario = '" + user + "'");
        if (result.next() == false) {
            return "";
        }
        String password = result.getString("contra");
        return password;
    }

    public ArrayList obtenerCochesNuevos() {

        ArrayList list = new ArrayList();

        try {
            ResultSet result = myStatement.executeQuery("SELECT marca, tipo, precio, distribuidor, matr FROM coche, c_nuevo WHERE matr=matricula");

            String marca;
            int i = 0;
            String tipo;
            int precio;
            String matr;

            while (result.next()) {
                marca = result.getString("marca");
                tipo = result.getString("tipo");
                precio = result.getInt("precio");
                matr = result.getString("matr");
                list.add(i, "Marca: " + marca + " | Tipo: " + tipo + " | Precio: " + precio + "€" + " | Matrícula: " + matr);
                i++;
            }

            //conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

    public ArrayList obtenerCochesSegundaMano() {

        ArrayList list = new ArrayList();

        try {
            ResultSet result = myStatement.executeQuery("SELECT marca, tipo, precio, kilometraje, year_fabr, estado, matr FROM coche, c_mano WHERE matr=matricula");

            String marca;
            String year;
            int km;
            String tipo;
            int precio;
            String matr;
            int i = 0;
            while (result.next()) {
                marca = result.getString("marca");
                year = result.getString("year_fabr");
                tipo = result.getString("tipo");
                km = result.getInt("kilometraje");
                precio = result.getInt("precio");
                matr = result.getString("matr");
                list.add(i, "Marca: " + marca + " | Tipo: " + tipo + " | Año: " + year + " | Kilometraje: " + km + " | Precio: " + precio + "€" + " | Matrícula: " + matr);
                i++;
            }

            //conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

    public void addCocheNuevo(String matricula, String tipo, String marca, String color, int year_fabr) throws SQLException {

        ResultSet result = myStatement.executeQuery("INSERT INTO c_nuevo (matricula, tipo, marca, color, year_fabr) "
                + "VALUES ( '" + matricula + "', '" + tipo + "', '" + marca + "', '" + color + "', " + year_fabr + ")");
    }

    public ArrayList obtenerCochesDisponibles(String tipo1) throws IOException {

        ArrayList list = new ArrayList();
        tipo1 = tipo1.toLowerCase();

        try {
            ResultSet result = myStatement.executeQuery("SELECT alquiler_disponible.marca, alquiler_disponible.color, tipo, c_alquiler.precio, c_alquiler.matr FROM alquiler_disponible, coche, c_alquiler WHERE coche.matricula = alquiler_disponible.matricula AND alquiler_disponible.matricula = c_alquiler.matr AND tipo = '" + tipo1 + "'");

            String marca;
            String tipo;
            String color;
            int precio;
            String matr;
            int i = 0;
            while (result.next()) {
                marca = result.getString("marca");
                tipo = result.getString("tipo");
                color = result.getString("color");
                precio = result.getInt("precio");
                matr = result.getString("matr");
                list.add(i, "Marca: " + marca + " | Tipo: " + tipo + " | Color: " + color + " | Precio : " + precio + " €/día" + " | Matrícula : " + matr);
                i++;
            }

            //conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

    public void addAlquiler(String recogida, String devolucion, String user, String matr) throws SQLException {

        myStatement.execute("INSERT INTO alquiler (fecha_ini, fecha_fin, usu, matr) VALUES ('" + recogida + "', '" + devolucion + "', '" + user + "', '" + matr + "')");
        myStatement.execute("UPDATE c_alquiler SET estado = 0 WHERE matr = '" + matr + "'");
    }

    public void deleteCocheNuevo(String matr) throws SQLException {

        myStatement.execute("DELETE FROM c_nuevo WHERE matr = '" + matr + "'");
    }

    public void deleteCocheSegundaMano(String matr) throws SQLException {

        myStatement.execute("DELETE FROM c_mano WHERE matr = '" + matr + "'");
    }

}
