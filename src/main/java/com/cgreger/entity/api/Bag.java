package com.cgreger.entity.api;

/**
 * Created by katana on 2/13/17.
 */
public class Bag extends Item {

    private int numberOfSlots;
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
