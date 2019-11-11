package com.example.myapplication;

import com.example.beans.Move;


public class DAO {

    public void createMoves(){

        Move flammenwurf = new Move("Flamethrower", "Fire", 80, "Burns the enemy", "Burn", 20);
        flammenwurf.save();
        Move focusblast = new Move("Focusblast", "Fight", 150, "Shoots a big laserball", "Missable", 5);
        focusblast.save();
        Move solarbeam = new Move("Solarbeam", "Grass", 150, "Big Laser which solar powered", "Missable", 10);
        solarbeam.save();
        Move airslash = new Move("Air Slash", "Flight", 70, "Shoots cool air stuff", "Crit", 20);
        airslash.save();

        Move hydropump = new Move("Hydropump", "Water", 150, "Shoots a lot of water", "Missable", 5);
        hydropump.save();
        Move shuriken = new Move("Water Shuriken", "Water", 75 , "Shoots some water shuriken", null, 30);
        shuriken.save();
        Move darkpulse = new Move("Darkpulse", "Dark", 80, "Shoots some darkness stuff", "Finch",  25);
        darkpulse.save();
        Move earthquake = new Move("Earthquake", "Ground", 100, "Real bad earthquake", null, 15);
        earthquake.save();

        Move leafstorm = new Move("Leaf Storm", "Grass", 175, "Storm of leafs", "Missable", 10);
        leafstorm.save();
        Move dragonpulse = new Move("Dragonpulse", "Dragon", 90, "Dragon laser", null, 5);
        darkpulse.save();
        Move leechseed = new Move("Leech Seed", "Gras", 80, "Heals with seeds", "Heal", 25);
        leechseed.save();
        Move poisonjab = new Move("Poison Jab", "Poison", 80, "Poison Punch", "Poison", 30);
        poisonjab.save();

        Move wildcharge = new Move("Wild Charhe", "Lightning", 120, "Elektro Charge", "Static", 5);
        wildcharge.save();
        Move facade = new Move("Facade", "Normal", 80, "Weird stuff that hurts", "Status Hurt", 20);
        facade.save();
        Move superpower = new Move("Superpower", "Fighting", 160, "Brawling", "Missable", 5);
        superpower.save();
        Move voltswitch = new Move("Voltswitch", "Lightning", 100, "Electric stuff", "Static", 15);
    }

    public void createPokemon(){


    }
}
