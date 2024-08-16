package com.ashokit.model;

public class DashboardResponse {
    
    private int totalEnquiries;
    private int openEnquiries;
    private int enrolledEnquiries;
    private int lostEnquiries;

    // Constructors
    public DashboardResponse() {}

    public DashboardResponse(int totalEnquiries, int openEnquiries, int enrolledEnquiries, int lostEnquiries) {
        this.totalEnquiries = totalEnquiries;
        this.openEnquiries = openEnquiries;
        this.enrolledEnquiries = enrolledEnquiries;
        this.lostEnquiries = lostEnquiries;
    }

    // Getters and Setters
    public int getTotalEnquiries() {
        return totalEnquiries;
    }

    public void setTotalEnquiries(int totalEnquiries) {
        this.totalEnquiries = totalEnquiries;
    }

    public int getOpenEnquiries() {
        return openEnquiries;
    }

    public void setOpenEnquiries(int openEnquiries) {
        this.openEnquiries = openEnquiries;
    }

    public int getEnrolledEnquiries() {
        return enrolledEnquiries;
    }

    public void setEnrolledEnquiries(int enrolledEnquiries) {
        this.enrolledEnquiries = enrolledEnquiries;
    }

    public int getLostEnquiries() {
        return lostEnquiries;
    }

    public void setLostEnquiries(int lostEnquiries) {
        this.lostEnquiries = lostEnquiries;
    }

    @Override
    public String toString() {
        return "DashboardResponse{" +
                "totalEnquiries=" + totalEnquiries +
                ", openEnquiries=" + openEnquiries +
                ", enrolledEnquiries=" + enrolledEnquiries +
                ", lostEnquiries=" + lostEnquiries +
                '}';
    }
}

