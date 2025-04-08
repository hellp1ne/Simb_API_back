package models;

import com.google.gson.annotations.SerializedName;

public class Addition {
    @SerializedName("id")
    private Integer id;

    @SerializedName("additional_info")
    private String additionalInfo;

    @SerializedName("additional_number")
    private Integer additionalNumber;

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getAdditionalInfo() { return additionalInfo; }
    public void setAdditionalInfo(String additionalInfo) { this.additionalInfo = additionalInfo; }
    public Integer getAdditionalNumber() { return additionalNumber; }
    public void setAdditionalNumber(Integer additionalNumber) { this.additionalNumber = additionalNumber; }
}