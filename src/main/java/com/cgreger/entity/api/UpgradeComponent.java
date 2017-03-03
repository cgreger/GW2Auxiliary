package com.cgreger.entity.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by katana on 2/13/17.
 */
public class UpgradeComponent extends Item {

    @JsonProperty("type")
    private String upgradeComponentType;

    @JsonProperty("flags")
    private List<String> upgradableItemTypes = new ArrayList<String>();

    @JsonProperty("infusion_upgrade_flags")
    private List<String> applicableInfusions = new ArrayList<String>();

    @JsonProperty("suffix")
    private String suffix;

    @JsonProperty("infix_upgrade")
    private InfixUpgrade infixUpgrade;

    @JsonProperty("bonuses")
    private List<String> bonuses = new ArrayList<String>();

    public UpgradeComponent() { }

    public String getUpgradeComponentType() {
        return upgradeComponentType;
    }

    public void setUpgradeComponentType(String upgradeComponentType) {
        this.upgradeComponentType = upgradeComponentType;
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
        return "UpgradeComponent{" +
                "upgradeComponentType='" + upgradeComponentType + '\'' +
                ", upgradableItemTypes=" + upgradableItemTypes +
                ", applicableInfusions=" + applicableInfusions +
                ", suffix='" + suffix + '\'' +
                ", infixUpgrade=" + infixUpgrade +
                ", bonuses=" + bonuses +
                '}';
    }

}
