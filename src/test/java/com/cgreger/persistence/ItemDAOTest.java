package com.cgreger.persistence;

import com.cgreger.entity.api.*;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by katana on 2/28/17.
 */
public class ItemDAOTest {

    Logger log = Logger.getLogger(this.getClass());
    ItemDAO dao;
    //TODO: finish tests

    @Before
    public void setUp() throws  Exception {

         dao = new ItemDAO();

    }

    @Test
    public void getItem() throws Exception {

        Item item = dao.getItem(50065);
        log.info(item.getClass().toString());

        assertEquals("Failed to retrieve correct Item.", 50065, item.getId());
        assertEquals("Failed to retrieve correct Item.", "Gift of Blades", item.getName());

        log.info("\n\n" + item.toString());

    }

    @Test
    public void getItems() throws Exception {

        ArrayList<Integer> itemIds = new ArrayList<Integer>();

        itemIds.add(70892);
        itemIds.add(1);
        itemIds.add(255);

        List<Item> items = dao.getItems(itemIds);

        for (Item item : items) {

            log.info(item.toString());

        }

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
    public void getRecipe() throws Exception {

        Recipe recipe = dao.getRecipe(100);
        ArrayList<String> disciplinesExpected = new ArrayList<String>();
        disciplinesExpected.add("Leatherworker");
        disciplinesExpected.add("Armorsmith");
        disciplinesExpected.add("Tailor");


        assertEquals("Failed to retrieve correct Recipe.", 100, recipe.getId());
        assertEquals("Failed to retrieve correct Recipe.", disciplinesExpected, recipe.getDisciplines());

        log.info("\n\n" + recipe.toString());

        ArrayList<Ingredient> ingredients = (ArrayList<Ingredient>) recipe.getIngredients();


        log.info(ingredients);

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