package com.cgreger.entity.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by katana on 2/13/17.
 */
public class Container extends Item {

    @JsonProperty("containerType")
    private String containerType;

    public Container() { }

    public String getContainerType() {
        return containerType;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    @Override
    public String toString() {
        return "Container{" +
                "containerType='" + containerType + '\'' +
                '}';
    }

}
