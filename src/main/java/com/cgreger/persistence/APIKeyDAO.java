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
    public int addAPIKey(APIKey apiKey) {

        Session session = factory.openSession();
        Transaction tr = null;
        Integer apiKeyId = null;
        String assocEmail = apiKey.getUser().getEmail();

        try {

            log.info("Adding new API key.");

            tr = session.beginTransaction();

            apiKeyId = (Integer) session.save(apiKey);

            tr.commit();
            log.info("Successfully added new APIKey (associated w/ email " + assocEmail + ").");

        } catch (HibernateException e) {

            if (tr != null) {

                tr.rollback();

            }

            log.error("Failed to add new APIKey (associated w/ email " + assocEmail + ").\n", e);

        } finally {

            session.close();

        }

        return apiKeyId;
    }

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
            log.info("Successfully upadated APIKey (associated w/ email " + assocEmail + ")");

        } catch (HibernateException e) {

            if (tr != null) {

                tr.rollback();

            }

            log.error("Failed to update APIKey (associated w/ email " + assocEmail + ") email.\n", e);

        } finally {

            session.close();

        }

    }

    // DELETE
    public void deleteAPIKey(int apiKeyId) {

        Session session = factory.openSession();
        Transaction tr = null;

        try {

            log.info("Deleting APIKey (id" + apiKeyId + ").");

            tr = session.beginTransaction();

            APIKey apiKey = (APIKey) session.get(APIKey.class, apiKeyId);
            session.delete(apiKey);

            tr.commit();
            log.info("Successfully deleted APIKey (id" + apiKeyId + ").");

        } catch (HibernateException e) {

            if (tr!=null) {

                tr.rollback();

            }

            log.error("Failed to delete APIKey (id" + apiKeyId + ")\n", e);

        } finally {

            session.close();

        }

    }
}
