package CharactersPack.HeroPack;
import CharactersPack.Character;
import ItemsPack.Equipment;
import ItemsPack.Items;

import java.util.Arrays;

public class Hero extends Character {
    private int xp;
    private int level;
    public Items[] inventory;

    public Hero(String name, int maxHP, int hp, int maxMana, int mana, int attack, int defense, int critChance, int critDamage, int dodgeChance, int xp, int level, Items[] inventory) {
        super(name, maxHP, hp, maxMana, mana, attack, defense, critChance, critDamage, dodgeChance);
        this.xp = xp;
        this.level = level;
        this.inventory = inventory;
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
    public Items[] getInventory() {return inventory;}
    public void setInventory(Items[] inventory) {this.inventory = inventory;}

    //Create a hero
    public static Hero createHero() {

        //Temporarily hardcoded crit and dodge stats
        int critChance = 10;
        int critDamage = 50;
        int dodge = 10;
        Items[] inventory = new Items[20];

        //Randomise, create and display the hero
        RandomiseHero rand = new RandomiseHero();
        Hero hero = new Hero("Martin", rand.getHp(), rand.getHp(), rand.getMana(),rand.getMana(), rand.getAttack(), rand.getDefense(), critChance, critDamage, dodge, 0, 0, inventory);
        System.out.println("New game started ! Your hero got generated");
        hero.display();

        //Fill inventory with items for test
/*        hero.inventory[0] = Equipment.generateItem("Weapon");
        hero.inventory[1] = Equipment.generateItem("Chest");
        hero.inventory[2] = Equipment.generateItem("Helmet");*/

        return hero;

    }

    //Display the created character
    public void display() {
        System.out.printf("Hero : \033[0;34m%s\033[0m (HP : %d, Mana : %d, Attack : %d, Defense :%d)\n\n", name, hp, mana, attack, defense);
    }

    //Rest
    public void rest() {
        this.setHp(this.getMaxHP());
    }

    //Display inventory
    public void displayInventory() {
        for (int i = 0; i < this.inventory.length; i++) {
            if (this.inventory[i] != null) {
                System.out.println(this.inventory[i].displayItem());
            }
        }
    }

    //Spells
    public int fireBall(int heroAttack, int monsterDefense, String monsterType) {
        int damages;
        damages = 2 * heroAttack - (monsterDefense/2);
        System.out.printf("\033[0;34m%s\033[0m used a\033[38;5;214m Fireball\033[0m spell and inflicted\033[0;31m %d damage(s) to the %s\033[0m\n\n", name, damages, monsterType);
        return damages;
    }

    public void addItemToInventory(Items item) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) { // Trouver une case vide
                inventory[i] = item;   // Ajouter l'objet
                System.out.println(item.getName() + " has been added to your inventory.\n");
                return; // Arrêter après avoir ajouté l'objet
            }
        }
        System.out.println("Inventory is full! Cannot add " + item.getName() + "\n");
    }

}
