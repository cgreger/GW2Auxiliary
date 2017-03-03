package com.cgreger.entity.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by katana on 2/13/17.
 */
public class Tool extends Item {

    @JsonProperty("type")
    private String toolType;

    public Tool() { }

    public String getToolType() {
        return toolType;
    }

    public void setToolType(String toolType) {
        this.toolType = toolType;
    }

    @Override
    public String toString() {
        return "Tool{" +
                "toolType='" + toolType + '\'' +
                '}';
    }
}
