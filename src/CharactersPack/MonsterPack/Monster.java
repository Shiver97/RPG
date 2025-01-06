package CharactersPack.MonsterPack;
import CharactersPack.Character;

import java.util.Random;

public class Monster extends Character {

    //Builder
    public Monster(String name, int maxHP, int hp, int maxMana, int mana, int attack, int defense, int critChance, int critDamage, int dodgeChance) {
        super(name, maxHP, hp, maxMana, mana, attack, defense, critChance, critDamage, dodgeChance);
    }



    //Getters and Setters
    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

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

    //Display the created monster
    public void display() {
        System.out.printf("Monster : \033[0;33m%s\033[0m (HP : %d, Mana : %d, Attack : %d, Defense : %d)\n\n", name, hp, mana, attack, defense);
    }
}


