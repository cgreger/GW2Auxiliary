package com.cgreger.entity;

/**
 * Created by katana on 2/13/17.
 */
public class ConsumableItem extends Item {

    private String type;
    private String description;
    private int durationInMiliSec;
    private String unlockType;
    private int dyeId;
    private int recipeId; //TODO: redundant?
    private String effectName;

    public ConsumableItem() { }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        return "ConsumableItem{" +
                "type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", durationInMiliSec=" + durationInMiliSec +
                ", unlockType='" + unlockType + '\'' +
                ", dyeId=" + dyeId +
                ", recipeId=" + recipeId +
                ", effectName='" + effectName + '\'' +
                '}';
    }
}
