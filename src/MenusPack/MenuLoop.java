package MenusPack;

import CharactersPack.HeroPack.Hero;
import CharactersPack.MonsterPack.Monster;
import Files.Save;
import ItemsPack.Equipment;

import java.io.IOException;
import java.util.Scanner;

public class MenuLoop {
    public static void display(Hero hero, Scanner sc) throws IOException {
        //Combat loop and print winner
        boolean continueGame = false;
        do {

            System.out.println("1 : Fight a monster\n2 : Rest (Regenerate HP and Mana)\n3 : Display inventory\n4 : Save Game\n\n");

            int userChoice = sc.nextInt();

            if (userChoice == 1) {
                Monster monster = Monster.createMonster();

                //CombatLoop with boolean return to determinate if you won the fight
                if (CombatLoop.display(hero, monster, sc)) {
                    System.out.printf("You won the fight against the %s !\n\n", monster.getName());

                    //Rolling a dice to check if you loot an item. If yes, return the corresponding item
                    Equipment looted = (LootingCalc.calculateLoot(monster.getName()));

                    //If you looted something, adds it to the inventory
                    if (looted != null) {
                        hero.addItemToInventory(looted);
                    }

                }
                else {
                    System.out.println("You lost the fight ..");
                }

            } else if (userChoice == 2) {
                System.out.println("You rest and regenerate maximum HP and Mana.\n\n");
                hero.rest();

            }
            else if (userChoice == 3) {
                System.out.println("Opening the inventory :\n");
                hero.displayInventory();
            }

            else {
                System.out.println("Save game.\n\n");
                Save.save(hero);
                System.out.println("Game saved.\n\n");
            }

            System.out.println("Do you want to keep going ? Press 1 for Yes, 2 for No.");
            continueGame = sc.nextInt() == 1;

        } while (continueGame);
    }
}
