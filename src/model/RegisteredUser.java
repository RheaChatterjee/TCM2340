package model;

import java.util.Map;

/**
 * Created by David on 9/28/2016.
 */
public class RegisteredUser extends User {

    private Map<String, String> registeredUsers;

    @Override
    public boolean authenticate(String username, String password) {
        return super.authenticate(username, password);
    }
}
