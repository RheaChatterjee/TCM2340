package model;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by David on 9/28/2016.
 */
public class RegisteredUser {

    private HashMap<String, ArrayList> registeredUserMap;

    public RegisteredUser() {
        registeredUserMap = new HashMap<String, ArrayList>();
    }

    public HashMap getRegisteredUsers() {
        return this.registeredUserMap;
    }

    public boolean usernameExist(User user) {
        return registeredUserMap.containsKey(user.getUsername());
    }

    public void addUser(User user) {
        if (usernameExist(user)) {
            throw new IllegalArgumentException("Username already exists, please enter a different username!");
        } else {
            registeredUserMap.put(user.getUsername(), new ArrayList());
            ArrayList userInformation = registeredUserMap.get(user.getUsername());
            userInformation.add(user.getPassword());
            userInformation.add(user.getId());
            userInformation.add(user.getEmail());
            userInformation.add(user.getAccountType());
            userInformation.add(user.getAddress());
            userInformation.add(user.getTitle());
        }
    }


}

