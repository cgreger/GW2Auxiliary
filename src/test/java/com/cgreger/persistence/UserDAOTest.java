package com.cgreger.persistence;

import com.cgreger.entity.User;
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

        int userId = dao.addUser("testuser@gmail.com", "passwordhash", "salthash");

        assertEquals("Add User test failed: New id not created correctly.", 6, userId);
        assertEquals("Add User test failed: Id created but information added incorrect.",
                "testuser@gmail.com", dao.getUser(userId).getEmail());

    }

    @Test
    public void getAllUsers() throws Exception {

        List<User> users = dao.getAllUsers();
        assertTrue("Failed to create all Users list.", users.size() > 0);

    }


    @Test
    public void getUser() throws Exception {

        int userId = dao.addUser("USERMAIL@gmail.com", "USERPASS", "USERSALT");

        assertTrue("Failed to retrieve User (id6).", dao.getUser(userId).getPassword().equals("USERPASS"));

    }

    @Test
    public void updateUserEmail() throws Exception {

        dao.updateUserEmail(1, "TESTUPDATE@gmail.com");

        assertEquals("Failed to update User's (id1) email to 'TESTUPDATE@gmail.com'.",
                "TESTUPDATE@gmail.com", dao.getUser(1).getEmail());

    }

    @Test
    public void updateUserPassword() throws Exception {

        dao.updateUserPassword(4, "TESTPASSWORD", "TESTSALT");

        assertEquals("Failed to update User's (id4) password to 'TESTPASSwORD' & 'TESTSALT'.",
                "TESTPASSWORD", dao.getUser(4).getPassword());

        assertEquals("Failed to update User's (id4) password to 'TESTPASSwORD' & 'TESTSALT'.",
                "TESTSALT", dao.getUser(4).getSalt());

    }

    @Test
    public void deleteUser() throws Exception {

        dao.deleteUser(3);

        assertEquals("Failed to delete User (id3).", null, dao.getUser(3));

    }

}