package MenusPack;

import ItemsPack.Equipment;
import java.util.Random;

public class LootingCalc {
    public static Equipment calculateLoot(String mobName) {

        //Roll dice to determinate loot
        Random rand = new Random();
        int randomNum = rand.nextInt(100) +1;

        if (randomNum <= 40) {
            System.out.printf("The %s's body is empty, you found nothing interesting ..\n\n", mobName);
            return null;
        }
        else if (randomNum <= 50 ) {
            System.out.printf("You found a pair of boots on the %s's body !\n\n", mobName);
            return Equipment.generateItem("Boots");
        }
        else if (randomNum <= 60 ) {
            System.out.printf("You found a pair of gloves on the %s's body !\n\n", mobName);
            return Equipment.generateItem("Gloves");
        }
        else if (randomNum <= 70 ) {
            System.out.printf("You found a pair of pants on the %s's body !\n\n", mobName);
            return Equipment.generateItem("Legs");
        }
        else if (randomNum <= 80 ) {
            System.out.printf("You found a chestplate on the %s's body !\n\n", mobName);
            return Equipment.generateItem("Chest");
        }
        else if (randomNum <= 90 ) {
            System.out.printf("You found a helmet on the %s's body !\n\n", mobName);
            return Equipment.generateItem("Helmet");
        }
        else {
            System.out.printf("You found a weapon on the %s's body !\n\n", mobName);
            return Equipment.generateItem("Weapon");
        }
    }
}
