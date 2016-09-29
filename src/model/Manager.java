/**
 * Created by Amine on 9/28/2016.
 */

public class Manager extends Worker {

    private final StringProperty managerId = new SimpleStringProperty();

    public Manager(String username, String password, String id, String email,
                String address, String title, String workerId, String adminId) {
        super(username, password, id, email, address, title, workerId);

        setManagerId(managerId);
    }

    /**
     * Sets managerId
     * @param managerId given managerId
     */
    public void setManagerId(String managerId) {
        this.managerId.set(managerId);
    }

    /**
     * Gets managerId
     * @return managerId
     */
    public String getManagerId() {
        return managerId.get();
    }
}