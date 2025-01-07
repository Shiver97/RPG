package CharactersPack.MonsterPack;

public class RandomiseMonster {

    //Stats to return
    public String name;
    public int hp;
    public int mana;
    public int attack;
    public int defense;

    //Getters
    public String getName() {return name;}
    public int getHp() {return hp;}
    public int getMana() {return mana;}
    public int getAttack() {return attack;}
    public int getDefense() {return defense;}

    //Rolls random stats for a Monster
    public RandomiseMonster(String mobName) {

        int minHP;
        int maxHP;
        int minMana;
        int maxMana;
        int minAtkDef;
        int maxAtkDef;

        //Check which Monster to build
        if (mobName.equals("Goblin")) {
            name = "Goblin";
            minHP = 30;
            maxHP = 35;
            minMana = 0;
            maxMana = 0;
            minAtkDef = 8;
            maxAtkDef = 10;
        }
        else {
            name = "Dragon";
            minHP = 60;
            maxHP = 80;
            minMana = 20;
            maxMana = 30;
            minAtkDef = 10;
            maxAtkDef = 12;

        }

        hp = minHP + (int)(Math.random() * (maxHP - minHP + 1));
        mana = minMana + (int)(Math.random() * (maxMana - minMana + 1));
        attack = minAtkDef + (int)(Math.random() * (maxAtkDef - minAtkDef + 1));
        defense = minAtkDef + (int)(Math.random() * (maxAtkDef - minAtkDef + 1));
    }
}