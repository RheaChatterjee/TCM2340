package model;

import java.io.Serializable;


public class User implements Serializable{

    //Basic Information
    private String username = "";
    private String password = "";
    private String id = "";
    private AccountType accountType;


    //Advanced Information
    private String email = "";
    private String address = "";
    private String title = "";

    private static final long serialVersionUID = 1L;
    /**
     * Constructs new User
     */
    public User() {}

    /**
     * Constructs new User
     * @param username User's username
     * @param password User's password
     */
    public User(String username, String password, String id, String email, AccountType accountType,
                String address, String title) {
        setUsername(username);
        setPassword(password);
        setId(id);
        setAccountType(accountType);
        setEmail(email);
        setAddress(address);
        setTitle(title);
    }

    //BASIC INFORMATION --------------------------------------------------------
    /**
     * Sets username
     * @param username given username
     */
    private void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets username
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets password
     * @param password given password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets id
     * @param id given id
     */
    private void setId(String id) {
        this.id = id;
    }

    /**
     * Gets id
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the account type
     * @return AccountType the user account type
     */
    public AccountType getAccountType() {
        return accountType;
    }

    /**
     * Sets account type
     * @param accountType given title
     */
    private void setAccountType(AccountType accountType) {this.accountType = accountType;}

    //ADVANCED INFORMATION -----------------------------------------------------
    /**
     * Sets email
     * @param email given email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets address
     * @param address given address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets address
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets title
     * @param title given title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets title
     * @return title
     */
    public String getTitle() {
        return title;
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
