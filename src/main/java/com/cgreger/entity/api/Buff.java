package com.cgreger.entity.api;

/**
 * Created by katana on 2/13/17.
 */
public class Buff {

    private int skillId;
    private String description;

    public Buff() { }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Buff{" +
                "skillId=" + skillId +
                ", description='" + description + '\'' +
                '}';
    }
}
