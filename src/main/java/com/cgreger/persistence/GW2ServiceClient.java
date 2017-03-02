package com.cgreger.persistence;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by katana on 2/27/17.
 */
public class GW2ServiceClient {

    Client client;
    WebTarget target;
    String response;


    public GW2ServiceClient() { }

    public String request(String requestUrl) {

        client = ClientBuilder.newClient();
        this.target = client.target(requestUrl);

        response = this.target.request(MediaType.APPLICATION_JSON).get(String.class);

        return response;

    }



}
