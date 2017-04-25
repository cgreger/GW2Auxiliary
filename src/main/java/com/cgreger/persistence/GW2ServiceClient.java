package com.cgreger.persistence;

import org.apache.log4j.Logger;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by katana on 2/27/17.
 */
public class GW2ServiceClient {

    private Logger log = Logger.getLogger(this.getClass());
    private Client client;
    private WebTarget target;
    private String response = null;


    public GW2ServiceClient() { }

    public String request(String requestUrl) {

        try {

            client = ClientBuilder.newClient();
            this.target = client.target(requestUrl);
            response = this.target.request(MediaType.APPLICATION_JSON).get(String.class);

        } catch (NotFoundException nfe) {

            log.error("API is currently down: " + nfe);

        }

        return response;

    }



}
