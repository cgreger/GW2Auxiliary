package com.cgreger.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by katana on 2/13/17.
 */
public class CustomizedItem extends Item {

    @JsonProperty("infusion_slots")
    private List<InfusionSlot> infusionSlots = new ArrayList<InfusionSlot>();

    @JsonProperty("infix_upgrade")
    private InfixUpgrade infixUpgrade;

    @JsonProperty("suffix_item_id")
    private int suffixItemId;

    @JsonProperty("secondary_suffix_item_id")
    private int secondarySuffixItemId;

    //TODO: not an attribute of customized item, must be placed in necessary subclasses.
    //private List<String> statChoices = new ArrayList<String>(); //TODO: might be array of objects? not sure..

    public CustomizedItem() { }

    public List<InfusionSlot> getInfusionSlots() {
        return infusionSlots;
    }

    public void setInfusionSlots(List<InfusionSlot> infusionSlots) {
        this.infusionSlots = infusionSlots;
    }

    public InfixUpgrade getInfixUpgrade() {
        return infixUpgrade;
    }

    public void setInfixUpgrade(InfixUpgrade infixUpgrade) {
        this.infixUpgrade = infixUpgrade;
    }

    public int getSuffixItemId() {
        return suffixItemId;
    }

    public void setSuffixItemId(int suffixItemId) {
        this.suffixItemId = suffixItemId;
    }

    public int getSecondarySuffixItemId() {
        return secondarySuffixItemId;
    }

    public void setSecondarySuffixItemId(int secondarySuffixItemId) {
        this.secondarySuffixItemId = secondarySuffixItemId;
    }

//    public List<String> getStatChoices() {
//        return statChoices;
//    }

//    public void setStatChoices(List<String> statChoices) {
//        this.statChoices = statChoices;
//    }

    @Override
    public String toString() {
        return "CustomizedItem{" +
                "infusionSlots=" + infusionSlots +
                ", infixUpgrade=" + infixUpgrade +
                ", suffixItemId=" + suffixItemId +
                ", secondarySuffixItemId=" + secondarySuffixItemId +
                //", statChoices=" + statChoices +
                '}';
    }

}
