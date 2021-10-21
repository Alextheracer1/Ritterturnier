package com.github.alextheracer1.ritterturnier;

import com.github.alextheracer1.ritterturnier.Members.Knappe;
import com.github.alextheracer1.ritterturnier.Members.Ritter;

import java.util.HashMap;

public class MemberList {

    private HashMap<Integer, Ritter> hashMapRitter = new HashMap<>();
    private HashMap<Integer, Knappe> hashMapKnappe = new HashMap<>();


    public void setRitter(Ritter ritter, int id) {
        hashMapRitter.put(id, ritter);
    }

    public void setKnappe(Knappe knappe, int id) {
        hashMapKnappe.put(id, knappe);
    }

    public Ritter getRitter(int id) {
        return hashMapRitter.get(id);
    }

    public int getHashSizeRitter() {
        return hashMapRitter.size();
    }

    public Knappe getKnappe(int id) {
        return hashMapKnappe.get(id);
    }

    private void listAllMembers() {
        for (int i = 1; hashMapRitter.size() > i; i++){
            System.out.println(hashMapRitter.get(i));
        }
    }


}
