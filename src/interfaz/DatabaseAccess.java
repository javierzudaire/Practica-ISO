/*
 * Javier Zudaire
 */
package interfaz;

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

        ResultSet result = myStatement.executeQuery("SELECT EXISTS(SELECT contra FROM users WHERE usuario = '" + user + "')");
        int exists = result.getInt(1);

        return exists;

    }

    public String obtenerContraseña(String user) throws SQLException {

        ResultSet result = myStatement.executeQuery("SELECT contra FROM users WHERE usuario = '" + user + "'");
        if (result.next() == false) {
            return "";
        }
        String password = result.getString("contra");
        return password;
    }

    public ArrayList obtenerViajes() {

        ArrayList list = new ArrayList();

        try {
            ResultSet result = myStatement.executeQuery("SELECT start, end, time FROM trips");

            String start;
            String end;
            String time;
            int i=0;

            while (result.next()) {
                start = result.getString("start");
                end = result.getString("end");
                time = result.getString("time");
                list.add(i, "Hora: " + time + " | De: " + start + " | A: " + end);
                i++;
            }

            //conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

    public ArrayList obtenerPerfil(String usuario) {

        ArrayList list = new ArrayList();

        try {
            ResultSet result = myStatement.executeQuery("SELECT usuario, email, phone, birthday FROM users WHERE usuario =" + usuario );

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

    public void addViaje(String start, String end, String hora) throws SQLException {

        myStatement.execute("INSERT INTO trips (start, end, time) "
                + "VALUES ( '" + start + "', '" + end + "', '" + hora + "')");
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
