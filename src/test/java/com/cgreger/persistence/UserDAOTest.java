package com.cgreger.persistence;

import com.cgreger.entity.User;
import org.hibernate.*;
import org.junit.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
            session.createSQLQuery("INSERT INTO user (email, password, salt, join_date) VALUES" +
                "('username@gmail.com', 'passwordhash', 'salthash1', NOW())," +
                "('sally@gmail.com', 'passwordhash', 'salthash2', NOW())," +
                "('jdoe@gmail.com', 'passwordhash', 'salthash3', NOW())," +
                "('smith@gmail.com', 'passwordhash', 'salthash4', NOW())," +
                "('johnny@gmail.com', 'passwordhash', 'salthash5', NOW());").executeUpdate();

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

    @AfterClass
    public static void runOnceAfterClass() throws Exception {



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


    //TODO: Add tests for getUser() and updatePassword()

    @Test
    public void updateUserEmail() throws Exception {



    }

    @Test
    public void deleteUser() throws Exception {

    }

}