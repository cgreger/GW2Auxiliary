package com.cgreger.persistence;

import com.cgreger.entity.Item;
import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by katana on 2/28/17.
 */
public class ItemDAOTest {

    Logger log = Logger.getLogger(this.getClass());

    @Test
    public void getGW2Item() throws Exception {

        ItemDAO dao = new ItemDAO();

        Item item = dao.getGW2Item(1);

        log.info(item.toString());

        String itemName = item.getName();

        assertEquals("MONSTER ONLY Moa Unarmed Pet", itemName);

    }

}