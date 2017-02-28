package com.cgreger.persistence;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by katana on 2/27/17.
 */
public class GW2ServiceClient {

    Client client;
    WebTarget target;


    public GW2ServiceClient(String target) {

        client = ClientBuilder.newClient();
        this.target = client.target(target);

    }

}
