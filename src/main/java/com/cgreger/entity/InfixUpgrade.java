package com.cgreger.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by katana on 2/13/17.
 */
public class InfixUpgrade {

    private List<Attribute> attributes = new ArrayList<Attribute>();
    private Buff buff;

    public InfixUpgrade() { }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public Buff getBuff() {
        return buff;
    }

    public void setBuff(Buff buff) {
        this.buff = buff;
    }

    @Override
    public String toString() {
        return "InfixUpgrade{" +
                "attributes=" + attributes +
                ", buff=" + buff +
                '}';
    }

}

