package com.cgreger.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by katana on 3/1/17.
 */
public class Ingredient {

    @JsonProperty("item_id")
    private int id;

    @JsonProperty("count")
    private int countNeeded;

    public Ingredient() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountNeeded() {
        return countNeeded;
    }

    public void setCountNeeded(int countNeeded) {
        this.countNeeded = countNeeded;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", countNeeded=" + countNeeded +
                '}';
    }
}
