package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public enum AccountType {
    USER("User"),
    WORKER("Worker"),
    MANAGER("Manager"),
    ADMIN("Admin");

    /** String representation of account type
     */
    private String name;


    /** Enum constructor for account type
     *  @param name of account
     */
    AccountType(String name) {
        this.name = name;
    }

    /**
     *
     * @return   the account name
     */
    public String getName() { return name; }

    /**
     *
     * @return the display string representation of the course
     */
    public String toString() { return name; }

    /**
     *
     * @return Observable list of the enum values
     */
    public static ObservableList<AccountType> getAccountTypeList() {
        return FXCollections.observableArrayList(AccountType.values());
    }
}
