package com.cgreger.entity;

import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by cgreger on 2/6/17.
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "salt")
    private String salt;

    @Column(name = "join_date")
    private LocalDate joinDate;
    /*private ArrayList<String> apiKeys;
    private ArrayList<Integer> trackedItems;*/

    public User() { }

    public User(String email, String password, String salt, LocalDate joinDate/*, ArrayList<String> apiKeys, ArrayList<Integer> trackedItems*/) {

        this.email = email;
        this.password = password;
        this.salt = salt;
        this.joinDate = joinDate;
        /*this.apiKeys = new ArrayList<String>(apiKeys);
        this.trackedItems = new ArrayList<Integer>(trackedItems);*/

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

    /*public ArrayList<String> getApiKeys() {
        return apiKeys;
    }

    public void setApiKeys(ArrayList<String> apiKeys) {
        this.apiKeys = apiKeys;
    }

    public ArrayList<Integer> getTrackedItems() {
        return trackedItems;
    }

    public void setTrackedItems(ArrayList<Integer> trackedItems) {
        this.trackedItems = trackedItems;
    }*/
}
