package com.github.alextheracer1.ritterturnier.Members;

import com.github.alextheracer1.ritterturnier.Weapons.Weapon;

public class Ritter {

    private String name;
    private String mobileNumber;
    private String reputationName;
    private int id;
    private Knappe knappe;
    private Weapon weapon;

     public Ritter(String name, String mobileNumber, String reputationName, int id) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.reputationName = reputationName;
        this.id = id;
    }

    public void setKnappe(Knappe knappe){
        this.knappe = knappe;
    }

    public String getKnappeName(){
         return knappe.getName();
    }

    public String getKnappeToString(){
         return knappe.toString();
    }

    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    public String toString(){
        String string = "\nID: " + id + "\nName: " + name + "\nTelefonnummer: " + mobileNumber + "\nRufname: " + reputationName + "\nWaffe: " + weapon.getCategory();
        return string;
    }

    public String getName() {
        return name;
    }
}
