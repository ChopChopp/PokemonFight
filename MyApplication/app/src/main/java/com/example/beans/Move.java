package com.example.beans;

import com.orm.SugarRecord;

public class Move extends SugarRecord {

    private String name;
    private String type;
    private int damage;
    private String description;
    private String effect;
    private int ap;

    public Move() {

    }

    public Move(String name, String type, int damage, String description, String effect, int ap) {
        this.name = name;
        this.type = type;
        this.damage = damage;
        this.description = description;
        this.effect = effect;
        this.ap = ap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public int getAp() {
        return ap;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }
}
