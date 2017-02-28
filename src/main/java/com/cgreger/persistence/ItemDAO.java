package com.cgreger.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import com.cgreger.entity.Item;


import java.io.IOException;

/**
 * Created by katana on 2/13/17.
 */
public class ItemDAO {

    private GW2ServiceClient gw2Client;
    private String response;

    public Item getGW2Item(int id) throws IOException {

        gw2Client = new GW2ServiceClient("https://api.guildwars2.com/v2/items?id=" + id);

        response = gw2Client.target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();

        Item item = mapper.readValue(response, Item.class);

        return item;

    }

}
