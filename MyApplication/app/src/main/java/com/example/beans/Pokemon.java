package com.example.beans;

import com.orm.SugarRecord;

public class Pokemon extends SugarRecord {

    int hp;
    int atack;
    int defense;
    int speed;
    Move move1;
    Move move2;
    Move move3;
    Move move4;
    String description;
    String name;
    String type;

    public Pokemon() {
    }

    public Pokemon(int hp, int atack, int defense, int speed, Move move1, Move move2, Move move3, Move move4, String desriptioin, String name, String type) {
        this.hp = hp;
        this.atack = atack;
        this.defense = defense;
        this.speed = speed;
        this.move1 = move1;
        this.move2 = move2;
        this.move3 = move3;
        this.move4 = move4;
        this.description = description;
        this.name = name;
        this.type = type;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtack() {
        return atack;
    }

    public void setAtack(int atack) {
        this.atack = atack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Move getMove1() {
        return move1;
    }

    public void setMove1(Move move1) {
        this.move1 = move1;
    }

    public Move getMove2() {
        return move2;
    }

    public void setMove2(Move move2) {
        this.move2 = move2;
    }

    public Move getMove3() {
        return move3;
    }

    public void setMove3(Move move3) {
        this.move3 = move3;
    }

    public Move getMove4() {
        return move4;
    }

    public void setMove4(Move move4) {
        this.move4 = move4;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
