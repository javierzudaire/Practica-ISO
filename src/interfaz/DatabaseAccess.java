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
            ResultSet result = myStatement.executeQuery("SELECT id, start, end, time FROM trips");

            int id;
            String start;
            String end;
            String time;
            int i = 0;

            while (result.next()) {
                id = result.getInt("id");
                start = result.getString("start");
                end = result.getString("end");
                time = result.getString("time");
                list.add(i, id + " | Hora: " + time + " | De: " + start + " | A: " + end);
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
            ResultSet result = myStatement.executeQuery("SELECT usuario, email, phone, birthday FROM users WHERE usuario ='" + usuario + "'");

            String nombre;
            String email;
            String phone;
            String birthday;

            nombre = result.getString("usuario");
            email = result.getString("email");
            phone = result.getString("phone");
            birthday = result.getString("birthday");
            list.add(0, nombre);
            list.add(1, email);
            list.add(2, phone);
            list.add(3, birthday);

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

    public void addViaje(String start, String end, String hora) throws SQLException {

        myStatement.execute("INSERT INTO trips (start, end, time) "
                + "VALUES ( '" + start + "', '" + end + "', '" + hora + "')");
    }

    public ArrayList obtenerViajesFiltrados(String universidad) {

        ArrayList list = new ArrayList();

        try {
            ResultSet result = myStatement.executeQuery("SELECT id, start, end, time FROM trips WHERE start='" + universidad + "' OR end= '" + universidad + "'");

            int id;
            String start;
            String end;
            String time;
            int i = 0;

            while (result.next()) {
                id = result.getInt("id");
                start = result.getString("start");
                end = result.getString("end");
                time = result.getString("time");
                list.add(i, id + " | Hora: " + time + " | De: " + start + " | A: " + end);
                i++;
            }

            //conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

}
