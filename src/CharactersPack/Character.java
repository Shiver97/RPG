package CharactersPack;

import java.util.Random;

public class Character {
    protected String name;
    protected int maxHP;
    protected int hp;
    protected int maxMana;
    protected int mana;
    protected int attack;
    protected int defense;
    protected int critChance;
    protected int critDamage;
    protected int dodgeChance;

    public Character(String name, int maxHP, int hp, int maxMana, int mana, int attack, int defense, int critChance, int critDamage, int dodgeChance) {
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

    public int basicAttack(int targetDef, int targetDodge, String targetName){

        Random random = new Random();
        double damages;
        int critOrDodge;
        int tempAttack = this.attack;

        //Dice roll for attack range
        int randomNumber = random.nextInt(100) + 1;
        if (randomNumber > 70) {tempAttack += 2;}
        else if (randomNumber >= 30) {tempAttack -= 2;}

        //Dice roll for crit/dodge
        randomNumber = random.nextInt(100) + 1;
        critOrDodge = randomNumber + this.critChance - targetDodge;

        if (critOrDodge > 90) {
            damages = ((1 + (double) this.critDamage / 100) * tempAttack) - ((double) targetDef /2);
            System.out.printf("\033[0;34m%s\033[0m attacked with a Crit Strike and inflicted\033[0;31m %.0f damage(s)\033[0m to %s!\n\n", name, damages, targetName);
        }
        else if (critOrDodge <= 10) {
            damages = 0;
            System.out.printf("\033[0;33m%s\033[0m dodged the hit and received no damage ..\n\n", targetName);
        }
        else {
            damages = tempAttack - (double) targetDef /2;
            System.out.printf("\033[0;34m%s\033[0m used an auto attack and inflicted\033[0;31m %.0f damage(s)\033[0m to \033[0;33m %s\033[0m\n\n", name, damages, targetName);
        }
        return (int)damages;
    }
}
