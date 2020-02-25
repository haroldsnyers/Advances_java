package controller;

public class LoginUser {

    public static boolean validate(String name, String pwd) {
        boolean valid = false;
        if (name.equals("test") && pwd.equals("test")) {
            valid = true;
        }
        return valid;
    }
}
