package com.cgreger.entity;

/**
 * Created by katana on 2/13/17.
 */
public class WeaponItem extends CustomizedItem {

    private String weaponType;
    private String damageType;
    private int minPower;
    private int maxPower;
    private int defenseValue;

    public WeaponItem() { }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    public String getDamageType() {
        return damageType;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    public int getMinPower() {
        return minPower;
    }

    public void setMinPower(int minPower) {
        this.minPower = minPower;
    }

    public int getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(int maxPower) {
        this.maxPower = maxPower;
    }

    public int getDefenseValue() {
        return defenseValue;
    }

    public void setDefenseValue(int defenseValue) {
        this.defenseValue = defenseValue;
    }

    @Override
    public String toString() {
        return "WeaponItem{" +
                "weaponType='" + weaponType + '\'' +
                ", damageType='" + damageType + '\'' +
                ", minPower=" + minPower +
                ", maxPower=" + maxPower +
                ", defenseValue=" + defenseValue +
                '}';
    }

}
