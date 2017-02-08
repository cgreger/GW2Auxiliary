package com.cgreger.entity;

import org.hibernate.annotations.*;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by cgreger on 2/6/17.
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "salt")
    private String salt;

    @CreationTimestamp
    @Column(name="join_date")
    private Date joinDate;
    /*private ArrayList<String> apiKeys;
    private ArrayList<Integer> trackedItems;*/

    public User() { }

    public User(String email, String password, String salt/*, ArrayList<String> apiKeys, ArrayList<Integer> trackedItems*/) {

        this.email = email;
        this.password = password;
        this.salt = salt;
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

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
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

    @Override
    public String toString() {

        return "User { " +
                "id='" + id + "'" +
                ", email='" + email + "'" +
                ", password='" + password + "'" +
                ", salt='" + salt + "'" +
                ", joinDate='" + joinDate +
                "' }";

    }
}
