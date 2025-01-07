import CharactersPack.HeroPack.Hero;
import ItemsPack.Equipment;
import MenusPack.InitGame;
import MenusPack.MenuLoop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        Hero hero = InitGame.initGame();

        MenuLoop.display(hero, sc);
        
    }
}

