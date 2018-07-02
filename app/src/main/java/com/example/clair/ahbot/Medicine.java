package com.example.clair.ahbot;

public class Medicine {
    private String medName;
    private String medAmount;
    private String medFrequency;
    private String remarks;

    public Medicine(String medName, String medAmount, String medFrequency, String remarks) {
        this.medName = medName;
        this.medAmount = medAmount;
        this.medFrequency = medFrequency;
        this.remarks = remarks;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public String getMedAmount() {
        return medAmount;
    }

    public void setMedAmount(String medAmount) {
        this.medAmount = medAmount;
    }

    public String getMedFrequency() {
        return medFrequency;
    }

    public void setMedFrequency(String medFrequency) {
        this.medFrequency = medFrequency;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
