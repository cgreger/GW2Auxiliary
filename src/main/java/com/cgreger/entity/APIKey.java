package com.cgreger.entity;

import javax.persistence.*;

/**
 * Created by cgreger on 2/8/17.
 */

@Entity
@Table(name = "gw2_api_key")
public class APIKey {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade=CascadeType.ALL) //Unsure about this...
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "api_key")
    private String apiKey;

    public APIKey() { }

    public APIKey(User user, String apiKey) {

        this.user = user;
        this.apiKey = apiKey;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public String toString() {

        return "";
    }
}
