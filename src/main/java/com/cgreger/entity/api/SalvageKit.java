package com.cgreger.entity.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by katana on 2/13/17.
 */
public class SalvageKit extends Item {

    @JsonProperty("type")
    private String salvageKitType;

    @JsonProperty("charges")
    private int chargesLeft;

    public SalvageKit() { }

    public String getSalvageKitType() {
        return salvageKitType;
    }

    public void setSalvageKitType(String salvageKitType) {
        this.salvageKitType = salvageKitType;
    }

    public int getChargesLeft() {
        return chargesLeft;
    }

    public void setChargesLeft(int chargesLeft) {
        this.chargesLeft = chargesLeft;
    }

    @Override
    public String toString() {
        return "SalvageKit{" +
                "salvageKitType='" + salvageKitType + '\'' +
                ", chargesLeft=" + chargesLeft +
                '}';
    }

}
