package com.cgreger.entity.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by katana on 2/13/17.
 */
public class Gizmo extends Item {

    @JsonProperty("type")
    private String gizmoType;

    public Gizmo() { }

    public String getGizmoType() {
        return gizmoType;
    }

    public void setGizmoType(String gizmoType) {
        this.gizmoType = gizmoType;
    }

    @Override
    public String toString() {
        return "Gizmo{" +
                "gizmoType='" + gizmoType + '\'' +
                '}';
    }

}
