package Debuggin;
public class DataStore {
    private static String user;
    private static String pass;
    private static String name;
    /*
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String address;
*/

    public static String getUser() {
        return user;
    }

    public static void setUser(String u) {
        user = u;
    }

    public static String getPass() {
        return pass;
    }

    public static void setPass(String p) {
        pass = p;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String n) {
        name = n;
    }
}