package com.cgreger.entity.api;

/**
 * Created by katana on 2/13/17.
 */
public class Tool extends Item {

    private String type;

    public Tool() { }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Tool{" +
                "type='" + type + '\'' +
                '}';
    }
}