package com.cgreger.entity;

/**
 * Created by katana on 2/13/17.
 */
public class BagItem extends Item {

    private int numberOfSlots;
    private boolean noSellOrSort;

    public BagItem() { }

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
        return "BagItem{" +
                "numberOfSlots=" + numberOfSlots +
                ", noSellOrSort=" + noSellOrSort +
                '}';
    }
}
