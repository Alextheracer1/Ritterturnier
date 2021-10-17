package com.github.alextheracer1.ritterturnier.Members;

public class Knappe {

    private String name;
    private int mobileNumber;
    private int levelOfTraining = 10;

    Knappe(String name, int mobileNumber, int levelOfTraining) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        if (levelOfTraining >= 10){
            this.levelOfTraining = levelOfTraining;
        }

    }

    public String toString() {
        String string = "Name: " + name + "\nLevel of Training: " + levelOfTraining;
        System.out.println(string);
        return string;
    }
}
