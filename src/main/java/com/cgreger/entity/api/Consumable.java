package com.cgreger.entity.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by katana on 2/13/17.
 */
public class Consumable extends Item {

    @JsonProperty("type")
    private String consumableType;

    @JsonProperty("description")
    private String description;

    @JsonProperty("duration_ms")
    private int durationInMiliSec;

    @JsonProperty("unlock_type")
    private String unlockType;

    @JsonProperty("color_id")
    private int dyeId;

    @JsonProperty("recipe_id")
    private int recipeId; //TODO: redundant?

    @JsonProperty("name")
    private String effectName;

    public Consumable() { }

    public String getConsumableType() {
        return consumableType;
    }

    public void setConsumableType(String consumableType) {
        this.consumableType = consumableType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDurationInMiliSec() {
        return durationInMiliSec;
    }

    public void setDurationInMiliSec(int durationInMiliSec) {
        this.durationInMiliSec = durationInMiliSec;
    }

    public String getUnlockType() {
        return unlockType;
    }

    public void setUnlockType(String unlockType) {
        this.unlockType = unlockType;
    }

    public int getDyeId() {
        return dyeId;
    }

    public void setDyeId(int dyeId) {
        this.dyeId = dyeId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getEffectName() {
        return effectName;
    }

    public void setEffectName(String effectName) {
        this.effectName = effectName;
    }

    @Override
    public String toString() {
        return "Consumable{" +
                "consumableType='" + consumableType + '\'' +
                ", description='" + description + '\'' +
                ", durationInMiliSec=" + durationInMiliSec +
                ", unlockType='" + unlockType + '\'' +
                ", dyeId=" + dyeId +
                ", recipeId=" + recipeId +
                ", effectName='" + effectName + '\'' +
                '}';
    }
}
