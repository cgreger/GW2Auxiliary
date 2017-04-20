package com.cgreger.entity.api;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ArmorDetails {

	@JsonProperty("weight_class")
	private String weightClass;

	@JsonProperty("secondary_suffix_item_id")
	private String secondarySuffixItemId;

	@JsonProperty("defense")
	private int defense;

	@JsonProperty("stat_choices")
	private List<Integer> statChoices;

	@JsonProperty("infusion_slots")
	private List<InfusionSlot> infusionSlots;

	@JsonProperty("type")
	private String type;

	public ArmorDetails() { }

	public void setWeightClass(String weightClass){
		this.weightClass = weightClass;
	}

	public String getWeightClass(){
		return weightClass;
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

	public void setStatChoices(List<Integer> statChoices){
		this.statChoices = statChoices;
	}

	public List<Integer> getStatChoices(){
		return statChoices;
	}

	public void setInfusionSlots(List<InfusionSlot> infusionSlots){
		this.infusionSlots = infusionSlots;
	}

	public List<InfusionSlot> getInfusionSlots(){
		return infusionSlots;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}
}