package com.cgreger.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.List;

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

    //@NotNull
    @Column(name="join_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false)
    private Calendar joinDate;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<APIKey> apiKeys;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<TrackedItem> trackedItems;

    public User() { }

    public User(String email, String password, String salt, List<APIKey> apiKeys, List<TrackedItem> trackedItems) {

        this.email = email;
        this.password = password;
        this.salt = salt;
        this.apiKeys = apiKeys;
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

    public Calendar getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Calendar joinDate) {
        this.joinDate = joinDate;
    }

    public List<APIKey> getApiKeys() {
        return apiKeys;
    }

    public void setApiKeys(List<APIKey> apiKeys) {
        this.apiKeys = apiKeys;
    }

    public List<TrackedItem> getTrackedItems() {
        return trackedItems;
    }

    public void setTrackedItems(List<TrackedItem> trackedItems) {
        this.trackedItems = trackedItems;
    }

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
