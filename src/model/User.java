package model;

/**
 * Created by Elizabeth on 9/18/2016.
 */
public class User {

    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername(String username) {
        return username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public boolean authenicate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}
