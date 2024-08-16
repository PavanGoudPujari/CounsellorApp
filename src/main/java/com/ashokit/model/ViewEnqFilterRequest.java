package com.ashokit.model;

public class ViewEnqFilterRequest {
    
    private int counsellorId;
    private String enqStatus;

    // Constructors
    public ViewEnqFilterRequest() {}

    public ViewEnqFilterRequest(int counsellorId, String enqStatus) {
        this.counsellorId = counsellorId;
        this.enqStatus = enqStatus;
    }

    // Getters and Setters
    public int getCounsellorId() {
        return counsellorId;
    }

    public void setCounsellorId(int counsellorId) {
        this.counsellorId = counsellorId;
    }

    public String getEnqStatus() {
        return enqStatus;
    }

    public void setEnqStatus(String enqStatus) {
        this.enqStatus = enqStatus;
    }

    @Override
    public String toString() {
        return "ViewEnqFilterRequest{" +
                "counsellorId=" + counsellorId +
                ", enqStatus='" + enqStatus + '\'' +
                '}';
    }
}

