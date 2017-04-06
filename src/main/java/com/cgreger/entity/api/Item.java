package com.cgreger.entity.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cgreger on 2/6/17.
 */
//TODO: create correct annotations so that entities map out properly. May need to run jackson generator instead...
//@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
//@JsonSubTypes(@JsonSubTypes.Type(value=CustomizedItem.class, name="CustomizedItem"))
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item<Type> {

    @JsonProperty("id")
    private int id;

    @JsonProperty("chat_link")
    private String chatLink;

    @JsonProperty("name")
    public String name;

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

    private List<Integer> recipes = new ArrayList<Integer>();

    private List<Type> types;

    public Item() { }

    public Item(List<Type> types) {

        this.types = types;

    }

    public Object issueType() {

        return types.get(0);

    }

    public void returnType(Type type) {

        types.add(type);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Integer> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Integer> recipes) {
        this.recipes = recipes;
    }

    //TODO: change default generation to add new lines like this one
    @Override
    public String toString() {
        return "Item{\n" +
                "id=" + id +
                ", \nchatLink='" + chatLink + '\'' +
                ", \nname='" + name + '\'' +
                ", \niconUrl='" + iconUrl + '\'' +
                ", \ndescription='" + description + '\'' +
                ", \nitemType='" + itemType + '\'' +
                ", \nrarity='" + rarity + '\'' +
                ", \nlevel=" + level +
                ", \nvendorValue=" + vendorValue +
                ", \nflags=" + flags +
                ", \nrestrictions=" + restrictions +
                ", \nrecipes=" + recipes +
                "\n}";
    }
}
