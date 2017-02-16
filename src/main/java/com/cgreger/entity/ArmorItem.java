package com.cgreger.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by katana on 2/13/17.
 */
public class ArmorItem extends CustomizedItem {

    private String type;
    private String weightClass;
    private String defenseValue;

    public ArmorItem() { }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
                "type='" + type + '\'' +
                ", weightClass='" + weightClass + '\'' +
                ", defenseValue='" + defenseValue + '\'' +
                '}';
    }
}
