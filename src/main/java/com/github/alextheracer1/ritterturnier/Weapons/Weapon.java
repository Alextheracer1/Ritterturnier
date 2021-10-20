package com.github.alextheracer1.ritterturnier.Weapons;

public class Weapon {
    protected String category;

    Weapon(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
