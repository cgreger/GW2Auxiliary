package com.cgreger.helpers;

import com.cgreger.persistence.SessionFactoryProvider;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by katana on 5/2/17.
 */
public class LuceneUtilsTest {

    private LuceneUtils lutils = new LuceneUtils("/home/katana/EnterpriseRepos/GW2Auxiliary/lucene/indexes/testindex");
    private static SessionFactory factory = SessionFactoryProvider.getSessionFactory();
    private Logger log = Logger.getLogger(this.getClass());

    @BeforeClass
    public static void runOnceBeforeClass() throws Exception {

        Session session = factory.openSession();
        Transaction tr = null;

        try {

            tr = session.beginTransaction();

            session.createSQLQuery("INSERT INTO TEST_gw2_auxiliary.item " +
                    "(gw2_id, name, type) VALUES" +
                    "(1, 'MONSTER ONLY Moa Unarmed Pet', 'Weapon')," +
                    "(2, 'Assassin Pill', 'Consumable')," +
                    "(6, '((208738))', 'Weapon')," +
                    "(11, 'Undead Unarmed', 'Weapon')," +
                    "(15, 'Abomination Hammer', 'Weapon')," +
                    "(23, 'RC Controller', 'Weapon')," +
                    "(24, 'Sealed Package of Snowballs', 'Consumable')," +
                    "(32, 'PvP Heavy Gloves of the Warrior', 'Armor')," +
                    "(46, 'Gladiator Weapon', 'Weapon')," +
                    "(50, 'Flame Legion Hammer', 'Weapon')," +
                    "(56, 'Strong Back Brace', 'Back')," +
                    "(57, 'Hearty Back Brace', 'Back')," +
                    "(58, 'Enduring Back Brace', 'Back')," +
                    "(59, 'Berserkers Spineguard of Ruby', 'Back')," +
                    "(60, 'Clerics Spineguard of Sapphire', 'Back')," +
                    "(61, 'Rampagers Spineguard of Coral', 'Back')," +
                    "(62, 'Shirt', 'Armor')," +
                    "(63, 'Leggings', 'Armor')," +
                    "(64, 'Boots', 'Armor')," +
                    "(68, 'Mighty Country Coat', 'Armor')," +
                    "(69, 'Mighty Country Coat', 'Armor')," +
                    "(70, 'Mighty Studded Coat', 'Armor')," +
                    "(71, 'Mighty Worn Chain Greaves', 'Armor')," +
                    "(72, 'Berserker''s Sneakthief Mask of the Afflicted', 'Armor')," +
                    "(73, 'Berserker''s Sneakthief Mask of Dwayna', 'Armor')," +
                    "(74, 'Mighty Worn Chain Greaves', 'Armor')," +
                    "(75, 'Berserker''s Sneakthief Mask of Strength', 'Armor')")
                    .executeUpdate();


        } catch (HibernateException e) {

            if (tr != null) {

                tr.rollback();

            }

        } finally {

            session.close();

        }


    }

    //TODO: add assertions
    @Test
    public void indexItems() throws Exception {

        lutils.indexItems();

    }

    @Test
    public void fuzzyQuery() throws Exception {

        lutils.indexItems();
        lutils.fuzzyQuery("bak string");

    }

}