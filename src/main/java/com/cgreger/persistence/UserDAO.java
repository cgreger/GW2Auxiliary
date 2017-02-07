package com.cgreger.persistence;

import com.cgreger.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

/**
 * Created by cgreger on 2/7/17.
 */
public class UserDAO {

    private final Logger logger = Logger.getLogger(this.getClass());
    private static SessionFactory factory;

    // CREATE
    public Integer addUser(String email, String password, String salt, LocalDate joinDate) {

        Session session = factory.openSession();
        Transaction tr = null;
        Integer userId = null;

        try {

            logger.info("Adding new User.");

            tr = session.beginTransaction();
            User user = new User(email, password, salt, joinDate);
            userId = (Integer) session.save(user);

            tr.commit();
            logger.info("Successfully added new User (id" + userId + ").");

        } catch (HibernateException e) {

            if (tr != null) {

                tr.rollback();

            }

            logger.error("Failed to add new User (id" + userId + ").\n", e);

        } finally {

            session.close();

        }

        return userId;
    }

    //TODO: method to get user by ID

    // READ ALL
    public void listUsers() {

        Session session = factory.openSession();
        Transaction tr = null;

        try {

            logger.info("----- Listing All Users -----");

            tr = session.beginTransaction();
            List users = session.createQuery("FROM User").list();

            for (Iterator iterator = users.iterator(); iterator.hasNext();) {

                User user = (User) iterator.next();

                logger.info("Id: " + user.getId());
                logger.info("Email: " + user.getEmail());
                logger.info("Password Hash: " + user.getPassword());
                logger.info("Password Salt: " + user.getSalt());
                logger.info("Join Date: " + user.getJoinDate());

            }

            tr.commit();
            logger.info("----- End Listing -----");

        } catch (HibernateException e) {

            if (tr != null) {

                tr.rollback();

            }

            logger.error("Failed to list all Users.\n", e);

        } finally {

            session.close();

        }

    }

    // UPDATE EMAIL
    public void updateUserEmail(Integer userId, String email) {

        Session session = factory.openSession();
        Transaction tr = null;

        try {

            logger.info("Updating User's (id" + userId + ") email to: " + email);

            tr = session.beginTransaction();
            User user = (User) session.get(User.class, userId);
            user.setEmail(email);
            session.update(user);

            tr.commit();
            logger.info("Successfully upadated User's (id" + userId + ") email to: " + email);

        } catch (HibernateException e) {

            if (tr != null) {

                tr.rollback();

            }

            logger.error("Failed to update User's (id" + userId + ") email.\n", e);

        } finally {

            session.close();

        }

    }

    //TODO: add method to update password & salt

    // DELETE
    public void deleteUser(Integer userId) {

        Session session = factory.openSession();
        Transaction tr = null;

        try {

            logger.info("Deleting User (id" + userId + ").");

            tr = session.beginTransaction();
            User employee =
                    (User)session.get(User.class, userId);
            session.delete(employee);

            tr.commit();
            logger.info("Successfully deleted User (id" + userId + ").");

        } catch (HibernateException e) {

            if (tr!=null) {

                tr.rollback();

            }

            logger.error("Failed to delete User(id" + userId + ")\n", e);

        } finally {

            session.close();

        }

    }



}
