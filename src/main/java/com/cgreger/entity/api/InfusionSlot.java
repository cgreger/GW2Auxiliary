package com.cgreger.entity.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
@JsonIgnoreProperties(ignoreUnknown = true)
public class InfusionSlot {

	@JsonProperty("flags")
	private List<String> flags;

	@JsonProperty("id")
	private int itemInSlotId;
//
//	public InfusionSlotsI() {
//
//		itemInSlotId =
//
//	}

	public void setFlags(List<String> flags){
		this.flags = flags;
	}

	public List<String> getFlags(){
		return flags;
	}

	public int getItemInSlotId() {
		return itemInSlotId;
	}

	public void setItemInSlotId(int itemInSlotId) {
		this.itemInSlotId = itemInSlotId;
	}
}