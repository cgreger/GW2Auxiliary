package com.cgreger.entity.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ConsumableDetails {

	@JsonProperty("unlock_type")
	private String unlockType;

	@JsonProperty("recipe_id")
	private int recipeId;

	@JsonProperty("type")
	private String type;

	public void setUnlockType(String unlockType){
		this.unlockType = unlockType;
	}

	public String getUnlockType(){
		return unlockType;
	}

	public void setRecipeId(int recipeId){
		this.recipeId = recipeId;
	}

	public int getRecipeId(){
		return recipeId;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}
}