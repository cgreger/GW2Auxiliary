package com.cgreger.entity;

/**
 * Created by katana on 2/13/17.
 */
public class ToolItem extends Item {

    private String type;

    public ToolItem() { }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ToolItem{" +
                "type='" + type + '\'' +
                '}';
    }
}
