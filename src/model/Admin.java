package model;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 * Created by Amine on 9/28/2016.
 */

public class Admin {

    //Basic Information
    private final StringProperty username = new SimpleStringProperty();
    private final StringProperty password = new SimpleStringProperty();
    private final StringProperty id = new SimpleStringProperty();
    private final ObjectProperty<AccountType> accountType = new SimpleObjectProperty();


    //Advanced Information
    private final StringProperty email = new SimpleStringProperty();
    private final StringProperty address = new SimpleStringProperty();
    private final StringProperty title = new SimpleStringProperty();
    private final StringProperty adminId = new SimpleStringProperty();

    public Admin(String username, String password, String id, String email,
                String address, String title, String workerId, StringProperty adminId) {
        setUsername(username);
        setPassword(password);
        setId(id);
        accountType.set(AccountType.USER);

        setEmail(email);
        setAddress(address);
        setTitle(title);
        setAdminId(adminId);
        accountType.set(AccountType.ADMIN);
    }

    //BASIC INFORMATION --------------------------------------------------------
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
     * Sets id
     * @param id given id
     */
    public void setId(String id) {
        this.id.set(id);
    }

    /**
     * Gets id
     * @return id
     */
    public String getId() {
        return id.get();
    }

    /**
     * Gets the account type
     * @return AccountType the user account type
     */
    public AccountType getAccountType() {
        return accountType.get();
    }

    //ADVANCED INFORMATION -----------------------------------------------------
    /**
     * Sets email
     * @param email given email
     */
    public void setEmail(String email) {
        this.email.set(email);
    }

    /**
     * Gets email
     * @return email
     */
    public String getEmail() {
        return email.get();
    }

    /**
     * Sets address
     * @param address given address
     */
    public void setAddress(String address) {
        this.address.set(address);
    }

    /**
     * Gets address
     * @return address
     */
    public String getAddress() {
        return address.get();
    }

    /**
     * Sets title
     * @param title given title
     */
    public void setTitle(String title) {
        this.title.set(title);
    }

    /**
     * Gets title
     * @return title
     */
    public String getTitle() {
        return title.get();
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

    /**
     * Sets adminId
     * @param adminId given adminId
     */
    public void setAdminId(StringProperty adminId) {
        this.adminId.set(String.valueOf(adminId));
    }

    /**
     * Gets adminId
     * @return adminId
     */
    public String getAdminId() {
        return adminId.get();
    }
}