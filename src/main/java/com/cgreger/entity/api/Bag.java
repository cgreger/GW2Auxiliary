package com.cgreger.entity.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by katana on 2/13/17.
 */
public class Bag extends Item {

    @JsonProperty("size")
    private int numberOfSlots;

    @JsonProperty("no_sell_or_sort")
    private boolean noSellOrSort;

    public Bag() { }

    public int getNumberOfSlots() {
        return numberOfSlots;
    }

    public void setNumberOfSlots(int numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
    }

    public boolean isNoSellOrSort() {
        return noSellOrSort;
    }

    public void setNoSellOrSort(boolean noSellOrSort) {
        this.noSellOrSort = noSellOrSort;
    }

    @Override
    public String toString() {
        return "Bag{" +
                "numberOfSlots=" + numberOfSlots +
                ", noSellOrSort=" + noSellOrSort +
                '}';
    }
}
