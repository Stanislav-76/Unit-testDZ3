package seminars.third.tdd;

//public class User {
//
//    String name;
//    String password;
//
//    boolean isAuthenticate = false;
//
//    public User(String name, String password, boolean isAdmin) {
//        this.name = name;
//        this.password = password;
//
//    }
//
//    //3.6.
//    public boolean authenticate(String name, String password) {
//        return false;
//    }
//
//}
public class User {
    String login;
    String password;
    boolean isAuthenticate;
    boolean admin;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        isAuthenticate = false;
        admin = false;
    }

    public boolean authenticate(String login, String pass) {
        if (this.login.equals(login) && password.equals(pass)) {
            return isAuthenticate = true;
        } else {
            return false;
        }
    }
}