package com.cgreger.entity.api;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class WeaponDetails {

	@JsonProperty("infix_upgrade")
	private InfixUpgrade infixUpgrade;

	@JsonProperty("damage_type")
	private String damageType;

	@JsonProperty("max_power")
	private int maxPower;

	@JsonProperty("secondary_suffix_item_id")
	private String secondarySuffixItemId;

	@JsonProperty("defense")
	private int defense;

	@JsonProperty("infusion_slots")
	private List<Object> infusionSlots;

	@JsonProperty("type")
	private String type;

	@JsonProperty("min_power")
	private int minPower;

	public void setInfixUpgrade(InfixUpgrade infixUpgrade){
		this.infixUpgrade = infixUpgrade;
	}

	public InfixUpgrade getInfixUpgrade(){
		return infixUpgrade;
	}

	public void setDamageType(String damageType){
		this.damageType = damageType;
	}

	public String getDamageType(){
		return damageType;
	}

	public void setMaxPower(int maxPower){
		this.maxPower = maxPower;
	}

	public int getMaxPower(){
		return maxPower;
	}

	public void setSecondarySuffixItemId(String secondarySuffixItemId){
		this.secondarySuffixItemId = secondarySuffixItemId;
	}

	public String getSecondarySuffixItemId(){
		return secondarySuffixItemId;
	}

	public void setDefense(int defense){
		this.defense = defense;
	}

	public int getDefense(){
		return defense;
	}

	public void setInfusionSlots(List<Object> infusionSlots){
		this.infusionSlots = infusionSlots;
	}

	public List<Object> getInfusionSlots(){
		return infusionSlots;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setMinPower(int minPower){
		this.minPower = minPower;
	}

	public int getMinPower(){
		return minPower;
	}
}