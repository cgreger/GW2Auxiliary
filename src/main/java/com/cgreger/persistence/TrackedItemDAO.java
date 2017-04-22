package com.cgreger.persistence;

import com.cgreger.entity.api.Item;
import com.cgreger.entity.api.Recipe;
import com.cgreger.entity.db.TrackedItem;
import com.cgreger.entity.db.TrackedItem;
import com.cgreger.entity.db.User;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by katana on 2/9/17.
 */
public class TrackedItemDAO {

    private final Logger log = Logger.getLogger(this.getClass());
    private static SessionFactory factory = SessionFactoryProvider.getSessionFactory();
    private GW2ServiceClient gw2Client = new GW2ServiceClient();

    //TODO: Double check class
    //TODO: Test this class

    //CREATE
    public int addTrackedItem(User user, TrackedItem trackedItem) {

        log.info("Adding TrackedItem for User (id=" + user.getId() + ")");
        user.getTrackedItems().add(trackedItem);

        return trackedItem.getId();

    }

    //READ BY ID
    public TrackedItem getTrackedItem(int trackedItemId) {

        Session session = factory.openSession();
        Transaction tr = null;
        TrackedItem trackedItem = null;

        try {

            log.info("Getting TrackedItem (id" + trackedItemId + ").");

            tr = session.beginTransaction();
            trackedItem = (TrackedItem) session.get(TrackedItem.class, trackedItemId);

            log.info("Successfully retrieved TrackedItem (id" + trackedItemId + ")");

        } catch (HibernateException e) {

            if (tr != null) {

                tr.rollback();

            }

            log.error("Failed to retrieve TrackedItem (id" + trackedItemId + ")\n", e);

        } finally {

            session.close();

        }

        return trackedItem;

    }

    // READ ALL
    public List<TrackedItem> getAllTrackedItems() {

        Session session = factory.openSession();
        Transaction tr = null;
        List<TrackedItem> trackedItems = new ArrayList<TrackedItem>();

        try {

            log.info("Getting and creating List of all TrackedItems.");

            tr = session.beginTransaction();
            trackedItems = session.createCriteria(TrackedItem.class).list();

            log.info("Successfully created List of all TrackedItems.");

        } catch (HibernateException e) {

            if (tr != null) {

                tr.rollback();

            }

            log.error("Failed to create List of all TrackedItems.\n", e);

        } finally {

            session.close();

        }

        return trackedItems;

    }

    // UPDATE TrackedItem
    public void updateTrackedItem(TrackedItem trackedItem) {

        Session session = factory.openSession();
        Transaction tr = null;
        String assocEmail = trackedItem.getUser().getEmail();

        try {

            log.info("Updating TrackedItem (associated w/ email: " + assocEmail + ")");

            tr = session.beginTransaction();
            session.update(trackedItem);

            tr.commit();
            log.info("Successfully updated TrackedItem (associated w/ email " + assocEmail + ")");

        } catch (HibernateException e) {

            if (tr != null) {

                tr.rollback();

            }

            log.error("Failed to update TrackedItem (associated w/ email " + assocEmail + ") email.\n", e);

        } finally {

            session.close();

        }

    }

    // DELETE
    public void deleteTrackedItem(User user, TrackedItem trackedItem) {

        log.info("Removing TrackedItem for User (id=" + user.getId() + ")");

        if (user.getTrackedItems().size() != 1) {

            user.getTrackedItems().remove(trackedItem);
            log.info("Successfully removed TrackedItem.");

        } else {

            log.error("Cannot remove last TrackedItem, at least 1 TrackedItem required per User.");

        }

    }

    //Get user inventory
    public List<Item> getUserInventory(User user) {

        List<Item> inventory = null;

        return inventory;


    }


    public List<Integer> getSharedItems(User user) {

        log.info("Retrieving inventory of user (id" + user.getId() + ")");
        String response = null;

        try {

            response = gw2Client.request("https://api.guildwars2.com/v2/account/inventory?access_token=" + user.getApiKeys().get(0));
            Item item = mapper.readValue(response, JsonNode.class).get();
            //mapper.readValue(response, Item.class);

        } catch (IOException e) {

            e.printStackTrace();

        }
        return null;

    }

    public List<Integer> getCharacterItems(User user) {

        return null;

    }

    public List<Integer> getBankItems(User user) {

        return null;

    }

    public List<Integer> getMaterialItems(User user) {

        return null;

    }


}
