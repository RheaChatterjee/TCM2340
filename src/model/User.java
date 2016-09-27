package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Elizabeth on 9/18/2016.
 */
public class User {

    private final StringProperty username = new SimpleStringProperty();
    private final StringProperty password = new SimpleStringProperty();

    /**
     * Constructs new User
     */
    public User() {}

    /**
     * Constructs new User
     * @param username User's username
     * @param password User's password
     */
    public User(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    /**
     * Sets username
     * @param username given username
     */
    public void setUsername(String username) {
        this.username.set(username);
    }

    /**
     * Gets username
     * @return username
     */
    public String getUsername() {
        return username.get();
    }

    /**
     * Sets password
     * @param password given password
     */
    public void setPassword(String password) {
        this.password.set(password);
    }

    /**
     * Gets password
     * @return password
     */
    public String getPassword() {
        return password.get();
    }

    /**
     * Authenticates current user
     * @param username given username
     * @param password given password
     * @return true if the credentials match and false otherwise
     */
    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}
