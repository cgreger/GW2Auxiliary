package com.cgreger.entity.api;

/**
 * Created by katana on 2/13/17.
 */
public class Attribute {

    private String type;
    private int modifierValue;

    public Attribute() { }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getModifierValue() {
        return modifierValue;
    }

    public void setModifierValue(int modifierValue) {
        this.modifierValue = modifierValue;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "type='" + type + '\'' +
                ", modifierValue=" + modifierValue +
                '}';
    }

}
