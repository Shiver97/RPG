import CharactersPack.HeroPack.Hero;
import Files.Save;
import ItemsPack.Equipment;
import MenusPack.InitGame;
import MenusPack.MenuLoop;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
/*

        Hero hero = InitGame.initGame();

        MenuLoop.display(hero, sc);*/

        Hero hero = Hero.createHero();

        System.out.println(hero.getName());
        String Test ="Test";
        Save.readFile();
        Save.writeFile(hero);
        Save.readFile();
        
    }
}

