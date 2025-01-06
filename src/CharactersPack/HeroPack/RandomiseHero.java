package CharactersPack.HeroPack;

public class RandomiseHero {
    //Stats to return
    public int hp;
    public int mana;
    public int attack;
    public int defense;

    //Getters
    public int getHp() {return hp;}
    public int getMana() {return mana;}
    public int getAttack() {return attack;}
    public int getDefense() {return defense;}


    public RandomiseHero() {

        //Randomise HP
        int minHP = 50;
        int maxHP = 60;
        hp = minHP + (int)(Math.random() * (maxHP - minHP + 1));

        //Randomise Mana
        int minMana = 20;
        int maxMana = 25;
        mana = minMana + (int)(Math.random() * (maxMana - minMana + 1));

        //Randomise Atk/Def
        int minAtkDef = 10;
        int maxAtkDef = 12;
        attack = minAtkDef + (int)(Math.random() * (maxAtkDef - minAtkDef + 1));
        defense = minAtkDef + (int)(Math.random() * (maxAtkDef - minAtkDef + 1));
    }
}
