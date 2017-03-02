package com.cgreger.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by katana on 2/13/17.
 */
public class ArmorItem extends CustomizedItem {

    @JsonProperty("type")
    //TODO: item types must be named descriptively, super class Item already has attribute called type!!
    private String armorType;

    @JsonProperty("weight_class")
    private String weightClass;

    @JsonProperty("defense")
    private String defenseValue;

    public ArmorItem() { }

    public String getType() {
        return armorType;
    }

    public void setType(String type) {
        this.armorType = type;
    }

    public String getWeightClass() {
        return weightClass;
    }

    public void setWeightClass(String weightClass) {
        this.weightClass = weightClass;
    }

    public String getDefenseValue() {
        return defenseValue;
    }

    public void setDefenseValue(String defenseValue) {
        this.defenseValue = defenseValue;
    }

    @Override
    public String toString() {
        return "ArmorItem{" +
                "type='" + armorType + '\'' +
                ", weightClass='" + weightClass + '\'' +
                ", defenseValue='" + defenseValue + '\'' +
                '}';
    }
}
