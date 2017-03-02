package com.cgreger.persistence;

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

    public Item getGW2Item(int id) throws IOException {

        gw2Client = new GW2ServiceClient("https://api.guildwars2.com/v2/items?id=" + id);

        response = gw2Client.target.request(MediaType.APPLICATION_JSON).get(String.class);

        Item item = mapper.readValue(response, Item.class);



        return item;

    }

    public Item getItemRecipe(int id) throws IOException {

        gw2Client = new GW2ServiceClient("https://api.guildwars2.com/v2/recipes?id=" + id);

        response = gw2Client.target.request(MediaType.APPLICATION_JSON).get(String.class);

        Item recipe = mapper.readValue(response, Item.class);


        return recipe;

    }

}
