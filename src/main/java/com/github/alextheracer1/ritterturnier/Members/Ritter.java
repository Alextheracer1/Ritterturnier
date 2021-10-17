package com.github.alextheracer1.ritterturnier.Members;

public class Ritter {

    private String name;
    private int mobileNumber;
    private String reputationName;
    private int id;

     Ritter(String name, int mobileNumber, String reputationName, int id) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.reputationName = reputationName;
        this.id = id;
    }

    private void addKnappe(){
        // TODO: Add Knappe
    }

    private void addWeapon(){
        // TODO: Add Weapon
    }

    public String toString(){
        String string = "ID: " + id + "\nName: " + name + "\nRufname: " + reputationName;

        //TODO: Implement Knappe and Weapon Checks

        return string;
    }

}
