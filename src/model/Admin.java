/**
 * Created by Amine on 9/28/2016.
 */

public class Admin extends Manager {

    private final StringProperty adminId = new SimpleStringProperty();

    public Admin(String username, String password, String id, String email,
                String address, String title, String workerId, String adminId) {
        super(username, password, id, email, address, title, workerId, managerId);

        setAdminId(adminId);
    }

    /**
     * Sets adminId
     * @param adminId given adminId
     */
    public void setAdminId(String adminId) {
        this.adminId.set(adminId);
    }

    /**
     * Gets adminId
     * @return adminId
     */
    public String getAdminId() {
        return adminId.get();
    }
}