package com.cgreger.helpers;

import com.cgreger.entity.api.Ingredient;
import com.cgreger.entity.api.Item;
import com.cgreger.entity.api.Recipe;
import com.cgreger.entity.db.TrackedItem;
import com.cgreger.entity.db.User;
import com.cgreger.persistence.ItemDAO;
import com.cgreger.persistence.TrackedItemDAO;

import java.util.ArrayList;

/**
 * Created by katana on 4/21/17.
 */
public class ItemTracker {

    private ItemDAO itemDAO = new ItemDAO();
    private TrackedItemDAO trackedItemDAO = new TrackedItemDAO();

    //TODO: IMPORTANT figure this out!!!!
    public double calculateItemCompletion(User user, Item item) {

        double completionPercent = 0.0;

        Recipe recipe = itemDAO.getRecipe(item.getRecipes().get(0));

        for (Ingredient ingredient : recipe.getIngredients()) {

            ingredient.getCountNeeded();

        }

        for (Item inventoryItem : trackedItemDAO.getUserInventory(user).keySet()) {

            if (inventoryItem.getId() == recipe.getIngredients().get(0).getId()) {



            }

        }


        return completionPercent;

    }

    public ArrayList<Item> getNeededItems(User user, Item item) {

        ArrayList<Item> items = null;

        return items;

    }

}
