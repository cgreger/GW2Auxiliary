package com.cgreger.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by katana on 2/13/17.
 */
public class TrinketItem extends CustomizedItem {

    private String type;

    public TrinketItem() { }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TrinketItem{" +
                "type='" + type + '\'' +
                '}';
    }
}
