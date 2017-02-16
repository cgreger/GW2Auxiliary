package com.cgreger.entity;

/**
 * Created by katana on 2/13/17.
 */
public class ContainerItem extends Item {

    private String type;

    public ContainerItem() { }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ContainerItem{" +
                "type='" + type + '\'' +
                '}';
    }

}
