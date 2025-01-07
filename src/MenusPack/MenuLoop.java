package MenusPack;

import CharactersPack.HeroPack.Hero;
import CharactersPack.MonsterPack.Monster;
import java.util.Scanner;

public class MenuLoop {
    public static void display(Hero hero, Scanner sc) {
        //Combat loop and print winner
        boolean continueGame = false;
        do {

            System.out.println("1 : Fight a monster\n2 : Rest (Regenerate HP and Mana)\n3 : Display inventory\n4 : Save Game\n\n");

            int userChoice = sc.nextInt();

            if (userChoice == 1) {
                Monster monster = Monster.createMonster();
                System.out.println(CombatLoop.display(hero, monster, sc));

            } else if (userChoice == 2) {
                System.out.println("You rest and regenerate maximum HP and Mana.\n\n");
                hero.rest();

            }
            else if (userChoice == 3) {
                System.out.println("Opening the inventory :\n");
                hero.displayInventory();
            }

            else {
                System.out.println("Work in Progress.\n\n");
            }

            System.out.println("Do you want to keep going ? Press 1 for Yes, 2 for No.");
            continueGame = sc.nextInt() == 1;

        } while (continueGame);
    }
}
