package com.cgreger.entity.api;

/**
 * Created by katana on 2/13/17.
 */
public class Gizmo extends Item {

    private String type;

    public Gizmo() { }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Gizmo{" +
                "type='" + type + '\'' +
                '}';
    }

}
