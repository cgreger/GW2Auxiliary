package com.cgreger.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by katana on 2/13/17.
 */
public class InfusionSlot {

    private List<String> type = new ArrayList<String>(); //TODO: May be able to change to a single string??
    private int itemInSlotId;

    public InfusionSlot() { }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public int getItemInSlotId() {
        return itemInSlotId;
    }

    public void setItemInSlotId(int itemInSlotId) {
        this.itemInSlotId = itemInSlotId;
    }

    @Override
    public String toString() {
        return "InfusionSlot{" +
                "type=" + type +
                ", itemInSlotId=" + itemInSlotId +
                '}';
    }

}
