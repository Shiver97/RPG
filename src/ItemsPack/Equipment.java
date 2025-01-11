package ItemsPack;

public class Equipment extends Items {

    public enum equipmentType {WEAPON, HELMET, CHEST, LEGS, GLOVES, BOOTS, NONE};

    private boolean isEquipped;
    private equipmentType type;
    private int attack, defense, hp, crit, critDamage;

    public Equipment(String itemName, String itemCategory, boolean isEquipable, boolean isEquipped, equipmentType type, int attack, int defense, int hp, int crit, int critDamage) {
        super(itemName, itemCategory, isEquipable);
        this.isEquipped = isEquipped;
        this.type = type;
        this.attack = attack;
        this.defense = defense;
        this.hp = hp;
        this.crit = crit;
        this.critDamage = critDamage;
    }

    public boolean isEquipped() {return isEquipped;}
    public void setEquipped(boolean equipped) {
        isEquipped = equipped;}
    public equipmentType getType() {return type;}
    public void setType(equipmentType type) {this.type = type;}
    public int getAttack() {return attack;}
    public void setAttack(int attack) {this.attack = attack;}
    public int getDefense() {return defense;}
    public void setDefense(int defense) {this.defense = defense;}
    public int getHp() {return hp;}
    public void setHp(int hp) {this.hp = hp;}
    public int getCrit() {return crit;}
    public void setCrit(int crit) {this.crit = crit;}
    public int getCritDamage() {return critDamage;}
    public void setCritDamage(int critDamage) {this.critDamage = critDamage;}

    @Override
    public String displayItem() {
        return String.format("%s- Type : %s\n- Equipped : %s\n", super.displayItem(), type, isEquipped);
    }

    //Function to generate equipable gear
    public static Equipment generateItem(String itemType){

        //Set all variables necessary for Equipment generation
        String itemName = "";
        String itemCategory = "Equipment";
        boolean isEquipable = true;
        boolean isEquipped = false;
        equipmentType type = equipmentType.NONE;
        int attack = 0, defense = 0, hp = 0, crit = 0, critDamage = 0;

        //Switch between all different gear parts
        switch (itemType) {

            case "Weapon":
                itemName = "Fighting Spirit Dagger";
                attack = 5;
                crit = 20;
                critDamage = 20;
                type = equipmentType.WEAPON;
                System.out.println("Generated a dagger :\n- Attack : " + attack + "\n- Crit : " + crit + "\n- CritDamage : " + critDamage + "\n");

                break;

            case "Helmet":
                itemName = "Fighting Spirit Helmet";
                defense = 3;
                hp = 10;
                type = equipmentType.HELMET;
                System.out.println("Generated a helmet :\n- HP : " + hp + "\n- Defense : " + defense + "\n");
                break;

            case "Chest":
                itemName = "Fighting Spirit Chest";
                defense = 5;
                hp = 13;
                type = equipmentType.CHEST;
                System.out.println("Generated a chest :\n- HP : " + hp + "\n- Defense : " + defense + "\n");
                break;

            case "Legs":
                itemName = "Fighting Spirit Legs";
                defense = 4;
                hp = 11;
                type = equipmentType.LEGS;
                System.out.println("Generated a legging :\n- HP : " + hp + "\n- Defense : " + defense + "\n");
                break;

            case "Boots":
                itemName = "Fighting Spirit Boots";
                defense = 2;
                hp = 5;
                type = equipmentType.BOOTS;
                System.out.println("Generated boots :\n- HP : " + hp + "\n- Defense : " + defense + "\n");
                break;

            case "Gloves":
                itemName = "Fighting Spirit Gloves";
                defense = 2;
                hp = 5;
                type = equipmentType.GLOVES;
                System.out.println("Generated gloves :\n- HP : " + hp + "\n- Defense : " + defense + "\n");
                break;
        }
        return new Equipment(itemName,itemCategory,isEquipable, isEquipped, type,attack, defense, hp, crit, critDamage);
    }
}
