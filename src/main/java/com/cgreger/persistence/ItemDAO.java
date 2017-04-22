package com.cgreger.persistence;

import com.cgreger.entity.api.*;
import com.fasterxml.jackson.databind.*;
import org.apache.log4j.Logger;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by katana on 2/13/17.
 */
public class ItemDAO {

    private GW2ServiceClient gw2Client = new GW2ServiceClient();
    private ObjectMapper mapper = new ObjectMapper();

    private Logger log = Logger.getLogger(this.getClass());

    public ItemDAO() { }

    //READ ITEMS BY GW2ID
    public Item getItem(int id) {

        Item item = null;
        String response = null;

        log.info("Retrieving Item (id=" + id + ")");

        try {

            response = gw2Client.request("https://api.guildwars2.com/v2/items?id=" + id);
            item = mapper.readValue(response, Item.class);
            setItemRecipes(item);

        } catch (IOException e) {

            e.printStackTrace();

        }

        log.info("Successfully retrieved Item (id=" + id + ")");

        return item;
    }

    //GET MULTIPLE ITEMS
    public Map<Item, Integer> getItems(Map<Integer, Integer> itemIds) {

        Map<Item, Integer> items = new HashMap<Item, Integer>();
        JsonNode itemNodes = null;
        String response = null;
        String request = "https://api.guildwars2.com/v2/items?ids=";

        for (int itemId : itemIds.keySet()) {

            request += itemId + ",";

        }

        response = gw2Client.request(request);

        try {

            itemNodes = mapper.readValue(response, JsonNode.class);

            for(JsonNode itemNode : itemNodes) {

                log.info(itemNode.toString());

                Item item = mapper.readValue(itemNode.toString(), Item.class);
                int itemCount = itemIds.get(item.getId());
                items.put(item, itemCount);

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        return items;

    }

    //READ RECIPESLIST BY GW2ID
    protected ArrayList<Integer> getItemRecipes(int id) {

        log.info("Retrieving Recipes for Item (id=" + id + ")");
        String response = null;
        ArrayList<Integer> recipeIds = null;

        try {

            response = gw2Client.request("https://api.guildwars2.com/v2/recipes/search?output=" + id);
            recipeIds = mapper.readValue(response, ArrayList.class);

        } catch (IOException e) {

            e.printStackTrace();

        }

        log.info("Successfully retrieved Recipes for Item (id=" + id + ")");

        return recipeIds;

    }



    //READ RECIPE BY GW2ID
    public Recipe getRecipe(int id) {

        log.info("Retrieving Recipe (id" + id + ")");
        String response = null;
        Recipe recipe = null;

        try {

            response= gw2Client.request("https://api.guildwars2.com/v2/recipes?id=" + id);
            recipe = mapper.readValue(response, Recipe.class);

        } catch (IOException e) {

            e.printStackTrace();

        }

        return recipe;
    }

    //UPDATE ITEM RECIPES LIST
    public void setItemRecipes(Item item) {

        log.info("Setting Recipes list for Item (id=" + item.getId() + ")");

        item.setRecipes(getItemRecipes(item.getId()));

        if (item.getRecipes() != null) {

            log.info("Setting Recipes list for Item (id=" + item.getId() + ")");

        } else {

            log.error("Failed to set Recipes list for Item (id=" + item.getId() + ")");

        }

    }

    //TODO: DELETE ITEM RECIPES LIST FROM ITEM

}
