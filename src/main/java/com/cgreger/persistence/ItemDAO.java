package com.cgreger.persistence;

import com.cgreger.entity.api.*;
import com.fasterxml.jackson.databind.*;

import org.apache.log4j.Logger;


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

    private Item mapItem(String itemType, String response) {

        Item itemClass;

        switch (itemType) {

            case "Armor":
                itemClass = mapper.readValue(response, Item.class);
                break;

            case "Back":
                itemClass = Back.class;
                break;

            case "Bag":
                itemClass = Bag.class;
                break;

            case "Consumable":
                itemClass = Consumable.class;
                break;

            case "Container":
                itemClass = Container.class;
                break;

            case "CraftingMaterial":
                itemClass = CraftingMaterial.class;
                break;

            case "Gathering":
                itemClass = Tool.class;
                break;

            case "Gizmo":
                itemClass = Gizmo.class;
                break;

            case "MiniPet":
                itemClass = Miniature.class;
                break;

            case "Tool":
                itemClass = SalvageKit.class;
                break;

            case "Trait":
                itemClass = Trait.class;
                break;

            case "Trinket":
                itemClass = Trinket.class;
                break;

            case "Trophy":
                itemClass = Trophy.class;
                break;

            case "UpgradeComponent":
                return UpgradeComponent.class;
                break;

            case "Weapon":
                itemClass = Weapon.class;
                break;

            default:
                itemClass = Item.class;

        }

        return itemClass;

    }

}
