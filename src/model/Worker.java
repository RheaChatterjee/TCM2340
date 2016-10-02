package model;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.User;

/**
 * Created by Amine on 9/28/2016.
 */

public class Worker extends User {

    private final StringProperty workerId = new SimpleStringProperty();
    private final ObjectProperty<AccountType> accountType = new SimpleObjectProperty();

    public Worker(String username, String password, String id, String email, AccountType accountType,
                String address, String title, String workerId) {
        super(username, password, id, email, accountType, address, title);

        setWorkerId(workerId);
    }

    /**
     * Sets workerId
     * @param workerId given workerId
     */
    public void setWorkerId(String workerId) {
        this.workerId.set(workerId);
    }

    /**
     * Gets workerId
     * @return workerId
     */
    public String getWorkerId() {
        return workerId.get();
    }
}