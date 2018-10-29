/*
 * Javier Zudaire
 */
package interfaz;

import java.sql.SQLException;

public class Login1 {

    public static boolean authenticate(String username, String password) throws SQLException {

        int exists = DatabaseAccess.getInstance().comprobarUsuario(username);
        String pass = DatabaseAccess.getInstance().obtenerContraseña(username);

        if (password.equals(pass) && exists == 1) {

            return true;
        }
        return false;
    }

}
