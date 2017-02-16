package com.cgreger.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by katana on 2/13/17.
 */
public class UpgradeComponentItem extends Item {

    private String type;
    private List<String> upgradableItemTypes = new ArrayList<String>();
    private List<String> applicableInfusions = new ArrayList<String>();
    private String suffix;
    private InfixUpgrade infixUpgrade;
    private List<String> bonuses = new ArrayList<String>();

    public UpgradeComponentItem() { }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getUpgradableItemTypes() {
        return upgradableItemTypes;
    }

    public void setUpgradableItemTypes(List<String> upgradableItemTypes) {
        this.upgradableItemTypes = upgradableItemTypes;
    }

    public List<String> getApplicableInfusions() {
        return applicableInfusions;
    }

    public void setApplicableInfusions(List<String> applicableInfusions) {
        this.applicableInfusions = applicableInfusions;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public InfixUpgrade getInfixUpgrade() {
        return infixUpgrade;
    }

    public void setInfixUpgrade(InfixUpgrade infixUpgrade) {
        this.infixUpgrade = infixUpgrade;
    }

    public List<String> getBonuses() {
        return bonuses;
    }

    public void setBonuses(List<String> bonuses) {
        this.bonuses = bonuses;
    }

    @Override
    public String toString() {
        return "UpgradeComponentItem{" +
                "type='" + type + '\'' +
                ", upgradableItemTypes=" + upgradableItemTypes +
                ", applicableInfusions=" + applicableInfusions +
                ", suffix='" + suffix + '\'' +
                ", infixUpgrade=" + infixUpgrade +
                ", bonuses=" + bonuses +
                '}';
    }

}
