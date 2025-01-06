package HeroPack;

import javax.swing.*;
import java.util.Random;

public class Hero {
    private String name;
    private int maxHP;
    private int hp;
    private int maxMana;
    private int mana;
    private int attack;
    private int defense;
    private int critChance;
    private int critDamage;
    private int dodgeChance;
    private int xp;
    private int level;
    private String[] inventory;

    //Builder
    public Hero(String name, int maxHP, int hp, int maxMana, int mana, int attack, int defense, int critChance, int critDamage, int dodgeChance) {
        this.name = name;
        this.maxHP = maxHP;
        this.hp = hp;
        this.maxMana = maxMana;
        this.mana = mana;
        this.attack = attack;
        this.defense = defense;
        this.critChance = critChance;
        this.critDamage = critDamage;
        this.dodgeChance = dodgeChance;
    }

    //Getters and Setters
    public String getName() {return name;}
    public int getMaxHP() {return maxHP;}
    public void setMaxHP(int maxHP) {this.maxHP = maxHP;}
    public int getHp() {return hp;}
    public void setHp(int hp) {this.hp = hp;}
    public int getMaxMana() {return maxMana;}
    public void setMaxMana(int maxMana) {this.maxMana = maxMana;}
    public int getMana() {return mana;}
    public void setMana(int mana) {this.mana = mana;}
    public int getAttack() {return attack;}
    public void setAttack(int attack) {this.attack = attack;}
    public int getDefense() {return defense;}
    public void setDefense(int defense) {this.defense = defense;}
    public int getCritChance() {return critChance;}
    public void setCritChance(int critChance) {this.critChance = critChance;}
    public int getCritDamage() {return critDamage;}
    public void setCritDamage(int critDamage) {this.critDamage = critDamage;}
    public int getDodgeChance() {return dodgeChance;}
    public void setDodgeChance(int dodgeChance) {this.dodgeChance = dodgeChance;}
    public int getXp() {return xp;}
    public void setXp(int xp) {this.xp = xp;}
    public int getLevel() {return level;}
    public void setLevel(int level) {this.level = level;}
    public String[] getInventory() {return inventory;}
    public void setInventory(String[] inventory) {this.inventory = inventory;}

    //Display the created character
    public void display() {
        System.out.printf("Hero : \033[0;34m%s\033[0m (HP : %d, Mana : %d, Attack : %d, Defense :%d)\n\n", name, hp, mana, attack, defense);
    }

    //Rest
    public void rest() {
        this.setHp(this.getMaxHP());
    }

    //Auto attack
    public int basicAttack(int heroAttack, int heroCritChance, int heroCritDamage, int monsterDefense, int monsterDodge, String monsterType) {
        Random random = new Random();
        double damages;
        int critOrDodge;

        // Reset attack
        heroAttack = this.attack;

        // Dice roll for attack range
        int randomNumber = random.nextInt(100) + 1;
        if (randomNumber > 70) { heroAttack += 2; }
        else if (randomNumber <= 30) { heroAttack -= 2; }

        // Dice roll for crit/dodge
        randomNumber = random.nextInt(100) + 1;
        critOrDodge = randomNumber + heroCritChance - monsterDodge;

        if (critOrDodge > 90) {
            // Crit damage calculation
            double critMultiplier = 1 + (double) heroCritDamage / 100;
            damages = (critMultiplier * heroAttack) - ((double) monsterDefense / 2);
            System.out.printf("\033[0;34m%s\033[0m attacked with a Crit Strike and inflicted\033[0;31m %.0f damage(s)\033[0m to the %s!\n\n", name, damages, monsterType);
        }
        else if (critOrDodge <= 10) {
            damages = 0;
            System.out.printf("The \033[0;33m%s\033[0m dodged the hit and received no damage ..\n\n", monsterType);
        }
        else {
            damages = heroAttack - ((double) monsterDefense / 2);
            System.out.printf("\033[0;34m%s\033[0m used an auto attack and inflicted\033[0;31m %.0f damage(s)\033[0m to the\033[0;33m %s\033[0m\n\n", name, damages, monsterType);
        }

        //Round the double before casting in int
        damages = Math.round(damages);

        return (int) damages;
    }

    //Spells
    public int fireBall(int heroAttack, int monsterDefense, String monsterType) {
        int damages;
        damages = 2 * heroAttack - (monsterDefense/2);
        System.out.printf("\033[0;34m%s\033[0m used a\033[38;5;214m Fireball\033[0m spell and inflicted\033[0;31m %d damage(s) to the %s\033[0m\n\n", name, damages, monsterType);
        return damages;
    }
}
