package MenusPack;

import CharactersPack.HeroPack.Hero;

import java.util.Scanner;

public class InitGame {
    public static Hero initGame(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Do you want to start a new game ?");
        System.out.println("1 : New game\n2 : Load game");
        int choice = sc.nextInt();

        if (choice == 1) {
            return Hero.createHero();
        }
        else if (choice == 2) {
            System.out.println("No saved game currently ..");
            return null;
        }
        return null;
    }
}
