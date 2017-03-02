package com.cgreger.persistence;

import com.cgreger.entity.db.APIKey;
import com.cgreger.entity.db.User;
import org.hibernate.*;
import org.junit.*;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by cgreger on 2/7/17.
 */
public class UserDAOTest {

    private UserDAO dao;
    private static SessionFactory factory = SessionFactoryProvider.getSessionFactory();

    @BeforeClass
    public static void runOnceBeforeClass() throws Exception {

        Session session = factory.openSession();
        Transaction tr = null;

        try {

            tr = session.beginTransaction();
            session.createSQLQuery("INSERT INTO user (email, password, salt) VALUES" +
                    "('username@gmail.com', 'passwordhash', 'salthash1')," +
                    "('sally@gmail.com', 'passwordhash', 'salthash2')," +
                    "('jdoe@gmail.com', 'passwordhash', 'salthash3')," +
                    "('smith@gmail.com', 'passwordhash', 'salthash4')," +
                    "('johnny@gmail.com', 'passwordhash', 'salthash5');").executeUpdate();
            session.createSQLQuery("INSERT INTO gw2_api_key (user_id, api_key) VALUES" +
                    "(1, 'APIKEY1')," +
                    "(2, 'APIKEY2')," +
                    "(3, 'APIKEY3')," +
                    "(4, 'APIKEY4')," +
                    "(5, 'APIKEY5')").executeUpdate();


        } catch (HibernateException e) {

            if (tr != null) {

                tr.rollback();

            }

        } finally {

            session.close();

        }


    }

    @Before
    public void setUp() {

        dao = new UserDAO();

    }

    @Test
    public void addUser() throws Exception {

        User user = new User("testuser@gmail.com", "passwordhash", "salthash");
        APIKey apiKey = new APIKey(user, "apikey");

        user.getApiKeys().add(apiKey);

        dao.addUser(user);

        assertEquals("Add User test failed: New id not created correctly.", 6, user.getId());
        assertEquals("Add User test failed: Id created but information added incorrect.",
                "testuser@gmail.com", user.getEmail());

    }

    @Test
    public void getAllUsers() throws Exception {

        List<User> users = dao.getAllUsers();
        assertTrue("Failed to create all Users list.", users.size() > 0);

    }


    @Test
    public void getUser() throws Exception {

        assertTrue("Failed to retrieve User (id6).", dao.getUser(5).getEmail().equals("johnny@gmail.com"));
        assertTrue("Failed to retrieve User (id6).", dao.getUser(5).getPassword().equals("passwordhash"));
        assertTrue("Failed to retrieve User (id6).", dao.getUser(5).getSalt().equals("salthash5"));

    }

    @Test
    public void updateUserEmail() throws Exception {

        User user = dao.getUser(1);
        user.setEmail("TESTUPDATE@gmail.com");

        dao.updateUser(user);

        assertEquals("Failed to update User's (id1) email to 'TESTUPDATE@gmail.com'.",
                "TESTUPDATE@gmail.com", user.getEmail());

    }

    @Test
    public void updateUserPassword() throws Exception {

        User user = dao.getUser(1);
        user.setPassword("TESTPASSWORD");
        user.setSalt("TESTSALT");

        dao.updateUser(user);

        assertEquals("Failed to update User's (id4) password to 'TESTPASSwORD' & 'TESTSALT'.",
                "TESTPASSWORD", user.getPassword());

        assertEquals("Failed to update User's (id4) password to 'TESTPASSwORD' & 'TESTSALT'.",
                "TESTSALT", user.getSalt());

    }

    @Test
    public void deleteUser() throws Exception {

        dao.deleteUser(3);

        assertEquals("Failed to delete User (id3).", null, dao.getUser(3));

    }

}