package com.cgreger.entity.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by katana on 2/13/17.
 */
//@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
@JsonSubTypes.Type(value=Armor.class, name="Armor")
//@JsonSubTypes.Type(value=Weapon.class, name="Weapon")
public class CustomizedItem extends Item {

    @JsonProperty("infusion_slots")
    private List<InfusionSlot> infusionSlots = new ArrayList<InfusionSlot>();

    @JsonProperty("infix_upgrade")
    private InfixUpgrade infixUpgrade;

    @JsonProperty("suffix_item_id")
    private int suffixItemId;

    @JsonProperty("secondary_suffix_item_id")
    private int secondarySuffixItemId;

    @JsonProperty("stat_choices")
    private List<String> statChoices = new ArrayList<String>();

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
