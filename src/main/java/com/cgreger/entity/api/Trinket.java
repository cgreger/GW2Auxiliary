package com.cgreger.entity.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by katana on 2/13/17.
 */
public class Trinket extends CustomizedItem {

    @JsonProperty("type")
    private String trinketType;

    public Trinket() { }

    public String getTrinketType() {
        return trinketType;
    }

    public void setTrinketType(String trinketType) {
        this.trinketType = trinketType;
    }

    @Override
    public String toString() {
        return "Trinket{" +
                "trinketType='" + trinketType + '\'' +
                '}';
    }
}
