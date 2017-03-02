package com.cgreger.persistence;

import com.cgreger.entity.api.*;
import com.fasterxml.jackson.databind.*;

import com.mysql.jdbc.MiniAdmin;
import org.apache.log4j.Logger;
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

    public Item getItem(int id) throws IOException {

        log.info("Retrieving Item (id=" + id + ")");

        String response = gw2Client.request("https://api.guildwars2.com/v2/items?id=" + id);

        String itemType = mapper.readValue(response, JsonNode.class).get("type").toString();

        Item item = mapItem(itemType, response);

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

    private Item mapItem(String itemType, String response) throws IOException {

        Item itemClass;

        switch (itemType) {

            case "Armor":
                itemClass = mapper.readValue(response, Armor.class);
                break;

            case "Back":
                itemClass = mapper.readValue(response, Back.class);
                break;

            case "Bag":
                itemClass = mapper.readValue(response, Bag.class);
                break;

            case "Consumable":
                itemClass = mapper.readValue(response, Consumable.class);
                break;

            case "Container":
                itemClass = mapper.readValue(response, Container.class);
                break;

            case "CraftingMaterial":
                itemClass = mapper.readValue(response, CraftingMaterial.class);
                break;

            case "Gathering":
                itemClass = mapper.readValue(response, Tool.class);
                break;

            case "Gizmo":
                itemClass = mapper.readValue(response, Gizmo.class);
                break;

            case "MiniPet":
                itemClass = mapper.readValue(response, Miniature.class);
                break;

            case "Tool":
                itemClass = mapper.readValue(response, SalvageKit.class);
                break;

            case "Trait":
                itemClass = mapper.readValue(response, Trait.class);
                break;

            case "Trinket":
                itemClass = mapper.readValue(response, Trinket.class);
                break;

            case "Trophy":
                itemClass = mapper.readValue(response, Trophy.class);
                break;

            case "UpgradeComponent":
                itemClass = mapper.readValue(response, UpgradeComponent.class);
                break;

            case "Weapon":
                itemClass = mapper.readValue(response, Weapon.class);
                break;

            default:
                itemClass = mapper.readValue(response, Item.class);

        }

        return itemClass;

    }

}
