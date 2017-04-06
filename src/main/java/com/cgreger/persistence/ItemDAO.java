package com.cgreger.persistence;

import com.cgreger.entity.api.*;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.*;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mysql.jdbc.MiniAdmin;
import jdk.nashorn.internal.parser.JSONParser;
import jdk.nashorn.internal.runtime.JSType;
import org.apache.log4j.Logger;
import org.glassfish.jersey.internal.inject.Custom;
import org.hibernate.Transaction;


import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by katana on 2/13/17.
 */
public class ItemDAO {

    private GW2ServiceClient gw2Client = new GW2ServiceClient();
    private ObjectMapper mapper = new ObjectMapper();
    private Logger log = Logger.getLogger(this.getClass());

    public void updateItemDatabase() throws IOException {

        log.info("Updating items database");

        String response = gw2Client.request("https://api.guildwars2.com/v2/items?page=0&page_size=200");


    }

    public Item<?> getItem(int id) throws IOException {

        log.info("Retrieving Item (id=" + id + ")");

        String response = gw2Client.request("https://api.guildwars2.com/v2/items?id=" + id);

        String itemType = mapper.readValue(response, JsonNode.class).get("type").toString();

        Item<?> item = mapItem(itemType, response);

        log.info("Successfully retrieved Item (id=" + id + ")");

        return item;

    }

    public ArrayList<Integer> getItemRecipes(int id) throws IOException {

        log.info("Retrieving Recipes for Item (id=" + id + ")");

        String response = gw2Client.request("https://api.guildwars2.com/v2/recipes/search?output=" + id);

        ArrayList<Integer> recipes = mapper.readValue(response, ArrayList.class);

        log.info("Successfully retrieved Recipes for Item (id=" + id + ")");

        return recipes;

    }

    public Recipe getRecipe(int id) throws IOException {

        log.info("Retrieving Recipe (id" + id + ")");

        String response = gw2Client.request("https://api.guildwars2.com/v2/recipes?id=" + id);

        Recipe recipe = mapper.readValue(response, Recipe.class);

        return recipe;
    }

    //TODO: Anyway to keep this private??
    protected void setItemRecipes(Item item) throws IOException {

        log.info("Setting Recipes list for Item (id=" + item.getId() + ")");

        item.setRecipes(getItemRecipes(item.getId()));

        if (item.getRecipes() != null) {

            log.info("Setting Recipes list for Item (id=" + item.getId() + ")");

        } else {

            log.error("Failed to set Recipes list for Item (id=" + item.getId() + ")");

        }

    }

    //TODO: fix
    private Item<?> mapItem(String itemType, String response) throws IOException {

        Item<?> item;

        switch (itemType) {

            case "Armor":
                item = mapper.readValue(response, Armor.class);

            case "Back":
                item = mapper.readValue(response, Back.class);

            case "Bag":
                item = mapper.readValue(response, Bag.class);

            case "Consumable":
                item = mapper.readValue(response, Consumable.class);

            case "Container":
                item = mapper.readValue(response, Container.class);

            case "CraftingMaterial":
                item  = mapper.readValue(response, CraftingMaterial.class);

            case "Gathering":
                item = mapper.readValue(response, Tool.class);

            case "Gizmo":
                item = mapper.readValue(response, Gizmo.class);

            case "MiniPet":
                item = mapper.readValue(response, Miniature.class);

            case "Tool":
                item = mapper.readValue(response, SalvageKit.class);

            case "Trait":
                item = mapper.readValue(response, Trait.class);

            case "Trinket":
                item = mapper.readValue(response, Trinket.class);

            case "Trophy":
                item = mapper.readValue(response, Trophy.class);

            case "UpgradeComponent":
                item = mapper.readValue(response, UpgradeComponent.class);

            case "Weapon":
                item = mapper.readValue(response, Weapon.class);

            default:
                item = mapper.readValue(response, Item.class);

        }

        return item;

    }

}
