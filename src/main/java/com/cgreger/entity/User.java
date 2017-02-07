package com.cgreger.entity;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by cgreger on 2/6/17.
 */
public class User {

    private int id;
    private String email;
    private String password;
    private String salt;
    private LocalDate joinDate;
    private String apiKey;
    private ArrayList<Integer> trackedItems;

    public User() { }

    public User(String email, String password, String salt, LocalDate joinDate, String apiKey, ArrayList<Integer> trackedItems) {

        this.email = email;
        this.password = password;
        this.salt = salt;
        this.joinDate = joinDate;
        this.apiKey = apiKey;
        this.trackedItems = trackedItems;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public ArrayList<Integer> getTrackedItems() {
        return trackedItems;
    }

    public void setTrackedItems(ArrayList<Integer> trackedItems) {
        this.trackedItems = trackedItems;
    }
}
