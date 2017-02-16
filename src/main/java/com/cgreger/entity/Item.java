package com.cgreger.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cgreger on 2/6/17.
 */
public class Item {

    private int gw2Id;
    private String chatLink;
    private String name;
    private String iconUrl;
    private String description;
    private String itemType;
    private String rarity;
    private int level;
    private int vendorValue; //TODO: figure out exact currency conversion
    private List<String> flags = new ArrayList<String>();
    private List<String> restrictions = new ArrayList<String>();
    private List<Integer> recipe = new ArrayList<Integer>();

    public Item() { }

    public int getGw2Id() {
        return gw2Id;
    }

    public void setGw2Id(int gw2Id) {
        this.gw2Id = gw2Id;
    }

    public String getChatLink() {
        return chatLink;
    }

    public void setChatLink(String chatLink) {
        this.chatLink = chatLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getVendorValue() {
        return vendorValue;
    }

    public void setVendorValue(int vendorValue) {
        this.vendorValue = vendorValue;
    }

    public List<String> getFlags() {
        return flags;
    }

    public void setFlags(List<String> flags) {
        this.flags = flags;
    }

    public List<String> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(List<String> restrictions) {
        this.restrictions = restrictions;
    }

    public List<Integer> getRecipe() {
        return recipe;
    }

    public void setRecipe(List<Integer> recipe) {
        this.recipe = recipe;
    }

    @Override
    public String toString() {
        return "Item{" +
                "gw2Id=" + gw2Id +
                ", chatLink='" + chatLink + '\'' +
                ", name='" + name + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", description='" + description + '\'' +
                ", itemType='" + itemType + '\'' +
                ", rarity='" + rarity + '\'' +
                ", level=" + level +
                ", vendorValue=" + vendorValue +
                ", flags=" + flags +
                ", restrictions=" + restrictions +
                ", recipe=" + recipe +
                '}';
    }
}
