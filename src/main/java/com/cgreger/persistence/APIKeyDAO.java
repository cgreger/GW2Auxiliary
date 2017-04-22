package com.cgreger.persistence;

import com.cgreger.entity.db.APIKey;
import com.cgreger.entity.db.User;
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
    public int addAPIKey(User user, APIKey apiKey) {

        log.info("Adding APIKey for User (id=" + user.getId() + ")");
        user.getApiKeys().add(apiKey);

        return apiKey.getId();

    }

    // READ BY ID
    public APIKey getAPIKey(int apiKeyId) {

        Session session = factory.openSession();
        Transaction tr = null;
        APIKey apiKey = null;

        try {

            log.info("Getting APIKey (id" + apiKeyId + ").");

            tr = session.beginTransaction();
            apiKey = (APIKey) session.get(APIKey.class, apiKeyId);

            log.info("Successfully retrieved APIKey (id" + apiKey + ")");

        } catch (HibernateException e) {

            if (tr != null) {

                tr.rollback();

            }

            log.error("Failed to retrieve APIKey (id" + apiKey + ")\n", e);

        } finally {

            session.close();

        }

        return apiKey;

    }

    // READ ALL
    public List<APIKey> getAllAPIKeys() {

        Session session = factory.openSession();
        Transaction tr = null;
        List<APIKey> apiKeys = new ArrayList<APIKey>();

        try {

            log.info("Getting and creating List of all APIKeys.");

            tr = session.beginTransaction();
            apiKeys = session.createCriteria(APIKey.class).list();

            log.info("Successfully created List of all APIKeys.");

        } catch (HibernateException e) {

            if (tr != null) {

                tr.rollback();

            }

            log.error("Failed to create List of all APIKeys.\n", e);

        } finally {

            session.close();

        }

        return apiKeys;

    }

    // UPDATE APIKey
    public void updateAPIKey(APIKey apiKey) {

        Session session = factory.openSession();
        Transaction tr = null;
        String assocEmail = apiKey.getUser().getEmail();

        try {

            log.info("Updating APIKey (associated w/ email: " + assocEmail + ")");

            tr = session.beginTransaction();
            session.update(apiKey);

            tr.commit();
            log.info("Successfully updated APIKey (associated w/ email " + assocEmail + ")");

        } catch (HibernateException e) {

            if (tr != null) {

                tr.rollback();

            }

            log.error("Failed to update APIKey (associated w/ email " + assocEmail + ")\n", e);

        } finally {

            session.close();

        }

    }

    // DELETE
    public void deleteAPIKey(User user, APIKey apiKey) {

        log.info("Removing APIKey for User (id=" + user.getId() + ")");

        if (user.getApiKeys().size() != 1) {

            user.getApiKeys().remove(apiKey);
            log.info("Successfully removed APIKey.");

        } else {

            log.error("Cannot remove last APIKey, at least 1 APIKey required per User.");

        }

    }
}
