package com.cgreger.entity;

import java.util.List;

/**
 * Created by katana on 3/1/17.
 */
public class Recipe {

    private int id;
    private int outputItemId;
    private int outputItemCount;
    private int minRating;
    private int timeToCraftInMili;
    private List<String> disciplines;
    private List<String> flags;
    private List<Integer> ingredients;
    private String chatLink;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOutputItemId() {
        return outputItemId;
    }

    public void setOutputItemId(int outputItemId) {
        this.outputItemId = outputItemId;
    }

    public int getOutputItemCount() {
        return outputItemCount;
    }

    public void setOutputItemCount(int outputItemCount) {
        this.outputItemCount = outputItemCount;
    }

    public int getMinRating() {
        return minRating;
    }

    public void setMinRating(int minRating) {
        this.minRating = minRating;
    }

    public int getTimeToCraftInMili() {
        return timeToCraftInMili;
    }

    public void setTimeToCraftInMili(int timeToCraftInMili) {
        this.timeToCraftInMili = timeToCraftInMili;
    }

    public List<String> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<String> disciplines) {
        this.disciplines = disciplines;
    }

    public List<String> getFlags() {
        return flags;
    }

    public void setFlags(List<String> flags) {
        this.flags = flags;
    }

    public List<Integer> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Integer> ingredients) {
        this.ingredients = ingredients;
    }

    public String getChatLink() {
        return chatLink;
    }

    public void setChatLink(String chatLink) {
        this.chatLink = chatLink;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", outputItemId=" + outputItemId +
                ", outputItemCount=" + outputItemCount +
                ", minRating=" + minRating +
                ", timeToCraftInMili=" + timeToCraftInMili +
                ", disciplines=" + disciplines +
                ", flags=" + flags +
                ", ingredients=" + ingredients +
                ", chatLink='" + chatLink + '\'' +
                '}';
    }

}
