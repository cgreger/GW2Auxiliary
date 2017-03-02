package com.cgreger.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cgreger on 2/6/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

    @JsonProperty("id")
    private int gw2Id;

    @JsonProperty("chat_link")
    private String chatLink;

    @JsonProperty("name")
    private String name;

    @JsonProperty("icon")
    private String iconUrl;

    @JsonProperty("description")
    private String description;

    @JsonProperty("type")
    private String itemType;

    @JsonProperty("rarity")
    private String rarity;

    @JsonProperty("level")
    private int level;

    @JsonProperty("vendor_value")
    private int vendorValue; //TODO: figure out exact currency conversion

    @JsonProperty("flags")
    private List<String> flags = new ArrayList<String>();

    @JsonProperty("restrictions")
    private List<String> restrictions = new ArrayList<String>();

    private List<Recipe> recipes = new ArrayList<Recipe>();

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

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
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
                ", recipes=" + recipes +
                '}';
    }
}
