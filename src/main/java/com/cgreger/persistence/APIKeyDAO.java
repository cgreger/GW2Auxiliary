package com.cgreger.persistence;

import com.cgreger.entity.APIKey;
import com.cgreger.entity.TrackedItem;
import com.cgreger.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cgreger on 2/9/17.
 */
public class APIKeyDAO {

    private final Logger log = Logger.getLogger(this.getClass());
    private static SessionFactory factory = SessionFactoryProvider.getSessionFactory();

    // CREATE
    public int addAPIKey(User user, String apiKeyString) {

        Session session = factory.openSession();
        Transaction tr = null;
        Integer apiKeyId = null;

        try {

            log.info("Adding new API key.");

            tr = session.beginTransaction();

            APIKey apiKey = new APIKey(user, apiKeyString);

            apiKeyId = (Integer) session.save(apiKey);

            tr.commit();
            log.info("Successfully added new APIKey owned by (id" + user.getId() + ").");

        } catch (HibernateException e) {

            if (tr != null) {

                tr.rollback();

            }

            log.error("Failed to add new User (id" + user.getId() + ").\n", e);

        } finally {

            session.close();

        }

        return apiKeyId;
    }

//    // READ BY ID
//    public User getAPIKey(int userId) {
//
//        Session session = factory.openSession();
//        Transaction tr = null;
//        User user = null;
//
//        try {
//
//            log.info("Getting User (id" + userId + ").");
//
//            tr = session.beginTransaction();
//            user = (User) session.get(User.class, userId);
//
//            log.info("Successfully retrieved User (id" + userId + ")");
//
//        } catch (HibernateException e) {
//
//            if (tr != null) {
//
//                tr.rollback();
//
//            }
//
//            log.error("Failed to retrieve User (id" + userId + ")\n", e);
//
//        } finally {
//
//            session.close();
//
//        }
//
//        return user;
//
//    }
//
//    // READ ALL
//    public List<User> getAllAPIKeys() {
//
//        Session session = factory.openSession();
//        Transaction tr = null;
//        List<User> users = new ArrayList<User>();
//
//        try {
//
//            log.info("Getting and creating List of all users.");
//
//            tr = session.beginTransaction();
//            users = session.createCriteria(User.class).list();
//
//            log.info("Successfully created List of all Users.");
//
//        } catch (HibernateException e) {
//
//            if (tr != null) {
//
//                tr.rollback();
//
//            }
//
//            log.error("Failed to create List of all Users.\n", e);
//
//        } finally {
//
//            session.close();
//
//        }
//
//        return users;
//
//    }
//
//    // UPDATE EMAIL
//    public void updateAPIKey(int userId, String email) {
//
//        Session session = factory.openSession();
//        Transaction tr = null;
//
//        try {
//
//            log.info("Updating User's (id" + userId + ") email to: " + email);
//
//            tr = session.beginTransaction();
//            User user = (User) session.get(User.class, userId);
//            user.setEmail(email);
//            session.update(user);
//
//            tr.commit();
//            log.info("Successfully upadated User's (id" + userId + ") email to: " + email);
//
//        } catch (HibernateException e) {
//
//            if (tr != null) {
//
//                tr.rollback();
//
//            }
//
//            log.error("Failed to update User's (id" + userId + ") email.\n", e);
//
//        } finally {
//
//            session.close();
//
//        }
//
//    }
//
//    // DELETE
//    public void deleteAPIKey(int userId) {
//
//        Session session = factory.openSession();
//        Transaction tr = null;
//
//        try {
//
//            log.info("Deleting User (id" + userId + ").");
//
//            tr = session.beginTransaction();
//            User employee =
//                    (User)session.get(User.class, userId);
//            session.delete(employee);
//
//            tr.commit();
//            log.info("Successfully deleted User (id" + userId + ").");
//
//        } catch (HibernateException e) {
//
//            if (tr!=null) {
//
//                tr.rollback();
//
//            }
//
//            log.error("Failed to delete User(id" + userId + ")\n", e);
//
//        } finally {
//
//            session.close();
//
//        }
//
//    }
}
