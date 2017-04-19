package com.cgreger.persistence;

import com.cgreger.entity.api.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
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

    public ItemDAO() {

        mapper.getSerializationConfig().getDefaultVisibilityChecker()
                .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                .withGetterVisibility(JsonAutoDetect.Visibility.ANY)
                .withSetterVisibility(JsonAutoDetect.Visibility.ANY)
                .withCreatorVisibility(JsonAutoDetect.Visibility.ANY);

    }

    public void updateItemDatabase() throws IOException {

        log.info("Updating items database");

        String response = gw2Client.request("https://api.guildwars2.com/v2/items?page=0&page_size=200");


    }

    public Item getItem(int id) throws IOException {

        log.info("Retrieving Item (id=" + id + ")");

        String response = gw2Client.request("https://api.guildwars2.com/v2/items?id=" + id);

        String itemType = mapper.readValue(response, JsonNode.class).get("type").toString();
        //log.info("Successfully retrieved Item (id=" + id + ")");
        //TODO: method for each type
        switch (itemType) {

            case "\"Armor\"":
                return mapper.readValue(response, Armor.class);

            case "\"Back\"":
                return mapper.readValue(response, Back.class);

            case "\"Bag\"":
                return mapper.readValue(response, Bag.class);

            case "\"Consumable\"":
                return mapper.readValue(response, Consumable.class);

            case "\"Container\"":
                return mapper.readValue(response, Container.class);

            case "\"CraftingMaterial\"":
                return mapper.readValue(response, CraftingMaterial.class);

            case "\"Gathering\"":
                return mapper.readValue(response, Tool.class);

            case "\"Gizmo\"":
                return mapper.readValue(response, Gizmo.class);

            case "\"MiniPet\"":
                return mapper.readValue(response, Miniature.class);

            case "\"Tool\"":
                return mapper.readValue(response, SalvageKit.class);

            case "\"Trait\"":
                return mapper.readValue(response, Trait.class);

            case "\"Trinket\"":
                return mapper.readValue(response, Trinket.class);

            case "\"Trophy\"":
                return mapper.readValue(response, Trophy.class);

            case "\"Upgrade Component\"":
                return mapper.readValue(response, UpgradeComponent.class);

            case "\"Weapon\"":
                return mapper.readValue(response, Weapon.class);

            default:
                return mapper.readValue(response, Item.class);
            
        }

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
//    private Item mapItem(String itemType, String response) throws IOException {
//
//        switch (itemType) {
//
//            case "Armor":
//                return mapper.readValue(response, Armor.class);
//
//            case "Back":
//                return mapper.readValue(response, Back.class);
//
//            case "Bag":
//                return mapper.readValue(response, Bag.class);
//
//            case "Consumable":
//                return mapper.readValue(response, Consumable.class);
//
//            case "Container":
//                return mapper.readValue(response, Container.class);
//
//            case "CraftingMaterial":
//                return mapper.readValue(response, CraftingMaterial.class);
//
//            case "Gathering":
//                return mapper.readValue(response, Tool.class);
//
//            case "Gizmo":
//                return mapper.readValue(response, Gizmo.class);
//
//            case "MiniPet":
//                return mapper.readValue(response, Miniature.class);
//
//            case "Tool":
//                return mapper.readValue(response, SalvageKit.class);
//
//            case "Trait":
//                return mapper.readValue(response, Trait.class);
//
//            case "Trinket":
//                return mapper.readValue(response, Trinket.class);
//
//            case "Trophy":
//                return mapper.readValue(response, Trophy.class);
//
//            case "UpgradeComponent":
//                return mapper.readValue(response, UpgradeComponent.class);
//
//            case "Weapon":
//                return mapper.readValue(response, Weapon.class);
//
//            default:
//                return mapper.readValue(response, Item.class);
//
//        }

    //}

}
