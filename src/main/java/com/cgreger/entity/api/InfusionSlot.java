package com.cgreger.entity.api;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class InfusionSlot {

	@JsonProperty("flags")
	private List<String> flags;

	private int itemInSlotId;
//
//	public InfusionSlotsItem() {
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