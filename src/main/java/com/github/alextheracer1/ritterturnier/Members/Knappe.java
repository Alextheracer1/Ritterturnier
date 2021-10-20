package com.github.alextheracer1.ritterturnier.Members;

public class Knappe {

    private String name;
    private String mobileNumber;
    private int levelOfTraining = 10;
    private int id;

    public Knappe(String name, String mobileNumber, int levelOfTraining, int id) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        if (levelOfTraining >= 10){
            this.levelOfTraining = levelOfTraining;
        }
        this.id = id;

    }

    public String toString() {
        String string = "\nID: " + id + "\nName: " + name + "\nTelefonnummer: " + mobileNumber + "\nLevel of Training: " + levelOfTraining;
        return string;
    }

    public String getName() {
        return name;
    }
}
