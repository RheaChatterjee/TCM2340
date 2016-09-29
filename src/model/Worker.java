/**
 * Created by Amine on 9/28/2016.
 */

public class Worker extends User {

    private final StringProperty workerId = new SimpleStringProperty();

    public Worker(String username, String password, String id, String email,
                String address, String title, String workerId) {
        super(username, password, id, email, address, title);

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