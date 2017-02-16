package com.cgreger.entity;

/**
 * Created by katana on 2/13/17.
 */
public class Miniature extends Item {

    private int minipetId;

    public Miniature() { }

    public int getMinipetId() {
        return minipetId;
    }

    public void setMinipetId(int minipetId) {
        this.minipetId = minipetId;
    }

    @Override
    public String toString() {
        return "Miniature{" +
                "minipetId=" + minipetId +
                '}';
    }

}
