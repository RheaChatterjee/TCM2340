package model;

import org.junit.Before;
import org.junit.Test;

public class AmineBenLtaifaJUnitTests {

    private User user;
    private RegisteredUser regUserMap;

    @Before
    public void setUp() {
        regUserMap = new RegisteredUser();
        user = new User("King Of Speed", "kos123", "01", "kos@gmail.com", AccountType.MANAGER, "GT", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddUser() throws Exception {
        regUserMap.addUser(user);
        regUserMap.addUser(user);
    }

    @Test
    public void testAddUser2() throws Exception {
        regUserMap.addUser(new User("Bob", "kos123", "01", "kos@gmail.com", AccountType.MANAGER, "GT", ""));
    }
}