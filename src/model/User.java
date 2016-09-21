package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Elizabeth on 9/18/2016.
 */
public class User {

    private final StringProperty username = new SimpleStringProperty();
    private final StringProperty password = new SimpleStringProperty();

    public User() {}
    public User(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    public void setUsername(String username) {
        this.username.set(username);
    }
    public String getUsername() {
        return username.get();
    }
    public void setPassword(String password) {
        this.password.set(password);
    }
    public String getPassword() {
        return password.get();
    }
    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}
