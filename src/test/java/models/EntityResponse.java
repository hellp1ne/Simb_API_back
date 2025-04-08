package models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class EntityResponse {
    @SerializedName("entity")
    private List<Entity> entities;

    // Getters and Setters
    public List<Entity> getEntities() { return entities; }
    public void setEntities(List<Entity> entities) { this.entities = entities; }
}