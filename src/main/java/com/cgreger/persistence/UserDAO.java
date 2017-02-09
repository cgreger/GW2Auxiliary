package com.cgreger.persistence;

import com.cgreger.entity.APIKey;
import com.cgreger.entity.TrackedItem;
import com.cgreger.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;

import static com.cgreger.persistence.SessionFactoryProvider.getSessionFactory;

/**
 * Created by cgreger on 2/7/17.
 */
public class UserDAO {

    private final Logger log = Logger.getLogger(this.getClass());
    private static SessionFactory factory = SessionFactoryProvider.getSessionFactory();

    // CREATE
    public int addUser(String email, String password, String salt) {

        Session session = factory.openSession();
        Transaction tr = null;
        Integer userId = null;

        try {

            log.info("Adding new User.");

            tr = session.beginTransaction();

            APIKey apiKey = new APIKey();
            apiKey.setApiKey(Double.toString(Math.random()));

            ArrayList<APIKey> apiKeys = new ArrayList<APIKey>();
            apiKeys.add(apiKey);


            //todo: figure out this apikey stuff
            User user = new User(email, password, salt, apiKeys, new ArrayList<TrackedItem>());
            userId = (Integer) session.save(user);

            tr.commit();
            log.info("Successfully added new User (id" + userId + ").");

        } catch (HibernateException e) {

            if (tr != null) {

                tr.rollback();

            }

            log.error("Failed to add new User (id" + userId + ").\n", e);

        } finally {

            session.close();

        }

        return userId;
    }

    // READ BY ID
    public User getUser(int userId) {

        Session session = factory.openSession();
        Transaction tr = null;
        User user = null;

        try {

            log.info("Getting User (id" + userId + ").");

            tr = session.beginTransaction();
            user = (User) session.get(User.class, userId);

            log.info("Successfully retrieved User (id" + userId + ")");

        } catch (HibernateException e) {

            if (tr != null) {

                tr.rollback();

            }

            log.error("Failed to retrieve User (id" + userId + ")\n", e);

        } finally {

            session.close();

        }

        return user;

    }

    // READ ALL
    public List<User> getAllUsers() {

        Session session = factory.openSession();
        Transaction tr = null;
        List<User> users = new ArrayList<User>();

        try {

            log.info("Getting and creating List of all users.");

            tr = session.beginTransaction();
            users = session.createCriteria(User.class).list();

            log.info("Successfully created List of all Users.");

        } catch (HibernateException e) {

            if (tr != null) {

                tr.rollback();

            }

            log.error("Failed to create List of all Users.\n", e);

        } finally {

            session.close();

        }

        return users;

    }

    // UPDATE EMAIL
    public void updateUserEmail(int userId, String email) {

        Session session = factory.openSession();
        Transaction tr = null;

        try {

            log.info("Updating User's (id" + userId + ") email to: " + email);

            tr = session.beginTransaction();
            User user = (User) session.get(User.class, userId);
            user.setEmail(email);
            session.update(user);

            tr.commit();
            log.info("Successfully upadated User's (id" + userId + ") email to: " + email);

        } catch (HibernateException e) {

            if (tr != null) {

                tr.rollback();

            }

            log.error("Failed to update User's (id" + userId + ") email.\n", e);

        } finally {

            session.close();

        }

    }

    // UPDATE PASSWORD
    public void updateUserPassword(int userId, String password, String salt) {

        Session session = factory.openSession();
        Transaction tr = null;

        try {

            log.info("Updating User's (id" + userId + ") password.");

            tr = session.beginTransaction();
            User user = (User) session.get(User.class, userId);
            user.setPassword(password);
            user.setSalt(salt);
            session.update(user);

            tr.commit();
            log.info("Successfully upadated User's (id" + userId + ") password.");

        } catch (HibernateException e) {

            if (tr != null) {

                tr.rollback();

            }

            log.error("Failed to update User's (id" + userId + ") password.\n", e);

        } finally {

            session.close();

        }

    }


    // DELETE
    public void deleteUser(int userId) {

        Session session = factory.openSession();
        Transaction tr = null;

        try {

            log.info("Deleting User (id" + userId + ").");

            tr = session.beginTransaction();
            User employee =
                    (User)session.get(User.class, userId);
            session.delete(employee);

            tr.commit();
            log.info("Successfully deleted User (id" + userId + ").");

        } catch (HibernateException e) {

            if (tr!=null) {

                tr.rollback();

            }

            log.error("Failed to delete User(id" + userId + ")\n", e);

        } finally {

            session.close();

        }

    }



}
