package com.cgreger.entity;

/**
 * Created by katana on 2/13/17.
 */
public class SalvageKitItem extends Item {

    private String type;
    private int chargesLeft;

    public SalvageKitItem() { }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getChargesLeft() {
        return chargesLeft;
    }

    public void setChargesLeft(int chargesLeft) {
        this.chargesLeft = chargesLeft;
    }

    @Override
    public String toString() {
        return "SalvageKitItem{" +
                "type='" + type + '\'' +
                ", chargesLeft=" + chargesLeft +
                '}';
    }

}
