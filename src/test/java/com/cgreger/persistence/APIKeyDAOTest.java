package com.cgreger.persistence;

import com.cgreger.entity.APIKey;
import com.cgreger.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by katana on 2/13/17.
 */
public class APIKeyDAOTest {
    private static User user1;
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

            user1 = (User) session.get(User.class, 1);


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


    }

    @Test
    public void addAPIKey() throws Exception {



    }

    @Test
    public void getAPIKey() throws Exception {

    }

    @Test
    public void getAllAPIKeys() throws Exception {

    }

    @Test
    public void updateAPIKey() throws Exception {

    }

    @Test
    public void deleteAPIKey() throws Exception {

    }

}