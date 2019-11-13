package com.example.myapplication;

import com.example.beans.Move;
import com.example.beans.Pokemon;

public class DAO {

    private Move flamethrower;
    private Move focusblast;
    private Move solarbeam;
    private Move airslash;

    private Move hydropump;
    private Move shuriken;
    private Move darkpulse;
    private Move earthquake;

    private Move leafstorm;
    private Move dragonpulse;
    private Move leechseed;
    private Move poisonjab;

    private Move wildcharge;
    private Move facade;
    private Move superpower;
    private Move voltswitch;

    public void createMoves() {

        flamethrower = new Move("Flamethrower", "Fire", 80, "Burns the enemy", "Burn", 20);
        flamethrower.save();
        focusblast = new Move("Focus blast", "Fight", 150, "Shoots a big laserball", "Missable", 5);
        focusblast.save();
        solarbeam = new Move("Solar beam", "Grass", 150, "Big Laser which solar powered", "Missable", 10);
        solarbeam.save();
        airslash = new Move("Air Slash", "Flight", 70, "Shoots cool air stuff", "Crit", 20);
        airslash.save();

        hydropump = new Move("Hydropump", "Water", 150, "Shoots a lot of water", "Missable", 5);
        hydropump.save();
        shuriken = new Move("Water Shuriken", "Water", 75, "Shoots some water shuriken", null, 30);
        shuriken.save();
        darkpulse = new Move("Darkpulse", "Dark", 80, "Shoots some darkness stuff", "Finch", 25);
        darkpulse.save();
        earthquake = new Move("Earthquake", "Ground", 100, "Real bad earthquake", null, 15);
        earthquake.save();

        leafstorm = new Move("Leaf Storm", "Grass", 175, "Storm of leafs", "Missable", 10);
        leafstorm.save();
        dragonpulse = new Move("Dragonpulse", "Dragon", 90, "Dragon laser", null, 5);
        dragonpulse.save();
        leechseed = new Move("Leech Seed", "Gras", 80, "Heals with seeds", "Heal", 25);
        leechseed.save();
        poisonjab = new Move("Poison Jab", "Poison", 80, "Poison Punch", "Poison", 30);
        poisonjab.save();

        wildcharge = new Move("Wild Charhe", "Lightning", 120, "Elektro Charge", "Static", 5);
        wildcharge.save();
        facade = new Move("Facade", "Normal", 80, "Weird stuff that hurts", "Status Hurt", 20);
        facade.save();
        superpower = new Move("Superpower", "Fighting", 160, "Brawling", "Missable", 5);
        superpower.save();
        voltswitch = new Move("Voltswitch", "Lightning", 100, "Electric stuff", "Static", 15);
        voltswitch.save();
    }

    public void createPokemon() {
        Pokemon charizard = new Pokemon(1000, 120, 300, 100, flamethrower, solarbeam, focusblast, airslash, "A fire dragon", "Charizard", "Fire");
        Pokemon greninja = new Pokemon(1700, 250, 250, 400, hydropump, darkpulse, shuriken, earthquake, "A ninja frog", "Greninja", "Water");
        Pokemon gewaldro = new Pokemon(750, 300, 250, 250, leafstorm, leechseed, dragonpulse, poisonjab, "A leaf lizard", "Sceptile", "Leaf");
        Pokemon luxray = new Pokemon(1000, 120, 300, 100, wildcharge, superpower, facade, voltswitch, "A lighting lynx", "Luxray", "Electro");
        charizard.save();
        greninja.save();
        gewaldro.save();
        luxray.save();
    }
}
