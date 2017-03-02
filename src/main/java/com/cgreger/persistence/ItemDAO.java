package com.cgreger.persistence;

import com.cgreger.entity.Recipe;
import com.fasterxml.jackson.databind.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import com.cgreger.entity.Item;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by katana on 2/13/17.
 */
public class ItemDAO {

    private GW2ServiceClient gw2Client;
    private String response;
    private ObjectMapper mapper = new ObjectMapper();

    public Item getItem(int id) throws IOException {

        gw2Client = new GW2ServiceClient("https://api.guildwars2.com/v2/items?id=" + id);

        response = gw2Client.target.request(MediaType.APPLICATION_JSON).get(String.class);

        Item item = mapper.readValue(response, Item.class);

        return item;

    }

    public ArrayList<Integer> getItemRecipes(int id) throws IOException {

        gw2Client = new GW2ServiceClient("https://api.guildwars2.com/v2/recipes/search?output=" + id);

        response = gw2Client.target.request(MediaType.APPLICATION_JSON).get(String.class);

        ArrayList<Integer> recipes = mapper.readValue(response, ArrayList.class);

        return recipes;

    }

}
