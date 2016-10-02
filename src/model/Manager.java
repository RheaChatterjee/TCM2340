package model;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Worker;

/**
 * Created by Amine on 9/28/2016.
 */

public class Manager extends Worker {

    private final StringProperty managerId = new SimpleStringProperty();
    private final ObjectProperty<AccountType> accountType = new SimpleObjectProperty();

    public Manager(String username, String password, String id, String email, AccountType accountType,
                String address, String title, String workerId, StringProperty managerId) {
        super(username, password, id, email, accountType, address, title, workerId);

        setManagerId(managerId);

    }

    /**
     * Sets managerId
     * @param managerId given managerId
     */
    public void setManagerId(StringProperty managerId) {
        this.managerId.set(String.valueOf(managerId));
    }

    /**
     * Gets managerId
     * @return managerId
     */
    public String getManagerId() {
        return managerId.get();
    }
}