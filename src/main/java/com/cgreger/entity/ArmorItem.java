package com.cgreger.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

/**
 * Created by katana on 2/13/17.
 */

//@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
public class ArmorItem extends CustomizedItem {

    @JsonProperty("type")
    //TODO: item types must be named descriptively, super class Item already has attribute called type!!
    private String armorType;

    @JsonProperty("weight_class")
    private String weightClass;

    @JsonProperty("defense")
    private String defenseValue;

    public ArmorItem() { }

    public String getArmorType() {
        return armorType;
    }

    public void setArmorType(String armorType) {
        this.armorType = armorType;
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
                "armorType='" + armorType + '\'' +
                ", weightClass='" + weightClass + '\'' +
                ", defenseValue='" + defenseValue + '\'' +
                '}';
    }
}
