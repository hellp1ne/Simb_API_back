package models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Entity {
    @SerializedName("id")
    private Integer id;

    @SerializedName("title")
    private String title;

    @SerializedName("verified")
    private Boolean verified;

    @SerializedName("addition")
    private Addition addition;

    @SerializedName("important_numbers")
    private List<Integer> importantNumbers;

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Boolean getVerified() { return verified; }
    public void setVerified(Boolean verified) { this.verified = verified; }
    public Addition getAddition() { return addition; }
    public void setAddition(Addition addition) { this.addition = addition; }
    public List<Integer> getImportantNumbers() { return importantNumbers; }
    public void setImportantNumbers(List<Integer> importantNumbers) { this.importantNumbers = importantNumbers; }
}