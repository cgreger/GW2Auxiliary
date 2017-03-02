package com.cgreger.persistence;

import com.cgreger.entity.Item;
import com.cgreger.entity.Recipe;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by katana on 2/28/17.
 */
public class ItemDAOTest {

    Logger log = Logger.getLogger(this.getClass());
    ItemDAO dao;

    @Before
    public void setUp() throws  Exception {

         dao = new ItemDAO();

    }

    @Test
    public void getItem() throws Exception {

        Item item = dao.getItem(1);

        assertEquals("Failed to retrieve correct item.", 1, item.getId());
        assertEquals("Failed to retrieve correct item.", "MONSTER ONLY Moa Unarmed Pet", item.getName());

        log.info("\n\n" + item.toString());
    }

    @Test
    public void getItemRecipes() throws Exception {

        ArrayList<Integer> recipes = dao.getItemRecipes(50065);
        ArrayList<Integer> recipesExpected = new ArrayList<Integer>();
        recipesExpected.add(8455);
        recipesExpected.add(8459);
        recipesExpected.add(8460);

        assertEquals("Failed to retrieve list of Item Recipes for Item (id50065)", recipesExpected, recipes);

    }

    @Test
    public void setItemRecipes() throws Exception {

        Item item = new Item();

        ArrayList<Integer> recipes = new ArrayList<Integer>();
        recipes.add(8455);
        recipes.add(8459);
        recipes.add(8460);

        item.setRecipes(recipes);

        assertEquals("Failed to set Recipes for Item (id" + item.getId() + ")",
                recipes, item.getRecipes());

    }

}