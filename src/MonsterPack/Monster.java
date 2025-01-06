package MonsterPack;

import java.util.Random;

public class Monster {
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

    //Builder
    public Monster(String name, int maxHP, int hp, int maxMana, int mana, int attack, int defense, int critChance, int critDamage, int dodgeChance) {
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

    //Auto attack
    public int basicAttack(int monsterAttack, int monsterCritChance, int monsterCritDamage, int heroDefense, int heroDodge, String heroName) {

        Random random = new Random();
        double damages;
        int critOrDodge;

        //Dice roll for attack range
        int randomNumber = random.nextInt(100) + 1;
        if (randomNumber > 70) {monsterAttack += 2;}
        else if (randomNumber >= 30) {monsterAttack -= 2;}

        //Dice roll for crit/dodge
        randomNumber = random.nextInt(100) + 1;
        critOrDodge = randomNumber + monsterCritChance - heroDodge;

        if (critOrDodge > 90) {
            damages = (monsterCritDamage * monsterAttack) - ((double) heroDefense /2);
            System.out.printf("The %s attacked with a Crit Strike and inflicted %.0f damage(s) to %s !\n\n", name, damages, heroName);
        }
        else if (critOrDodge <= 10) {
            damages = 0;
            System.out.printf("%s dodged the hit and received no damage.\n\n", heroName);
        }
        else {
            damages = monsterAttack - (double) heroDefense /2;
            System.out.printf("The %s used an auto attack and inflicted %.0f damage(s) to %s.\n\n", name, damages, heroName);
        }
        return (int)damages;
    }
}


