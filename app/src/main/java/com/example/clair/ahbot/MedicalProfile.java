package com.example.clair.ahbot;

public class MedicalProfile {
    String name,age,diseases,allergies;

    public MedicalProfile(String name, String age, String diseases, String allergies) {
        this.name = name;
        this.age = age;
        this.diseases = diseases;
        this.allergies = allergies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDiseases() {
        return diseases;
    }

    public void setDiseases(String diseases) {
        this.diseases = diseases;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }
}
