package com.cgreger.persistence;

import com.cgreger.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

    @Before
    public void setUp() throws Exception {

        dao = new UserDAO();

    }

    @After
    public void tearDown() throws Exception {

        Session session = factory.openSession();
        Transaction tr = null;

        try {

            tr = session.beginTransaction();

            tr.commit();

        } catch (HibernateException e) {

            if (tr != null) {

                tr.rollback();

            }

        } finally {

            session.close();

        }

    }

    @Test
    public void addUser() throws Exception {

        int userId = dao.addUser("testuser@gmail.com", "passwordhash", "salthash");

        assertEquals("Add User test failed: New id not created.", 6, userId);
        assertEquals("Add User test failed: Id created but information added incorrect.",
                "testuser@gmail.com", dao.getUser(userId).getEmail());

    }

    @Test
    public void getAllUsers() throws Exception {

        List<User> users = dao.getAllUsers();
        assertTrue("Failed to create all Users list.", users.size() > 0);

    }

    @Test
    public void updateUserEmail() throws Exception {

    }

    @Test
    public void deleteUser() throws Exception {

    }

}