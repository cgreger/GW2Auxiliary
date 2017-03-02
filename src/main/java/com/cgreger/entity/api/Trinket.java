package com.cgreger.entity.api;

/**
 * Created by katana on 2/13/17.
 */
public class Trinket extends CustomizedItem {

    private String type;

    public Trinket() { }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Trinket{" +
                "type='" + type + '\'' +
                '}';
    }
}
