
package interfaz;



import java.util.ArrayList;

public class User {

    private static User instance = null;

    public static User getInstance() {
        if (instance == null) {
            instance = new User();

        }
        return instance;
    }

    ArrayList list = new ArrayList();

    public void addUser(String user) {

        list.add(user);

    }

    public String getUser() {

        return list.get(0).toString();

    }

}
