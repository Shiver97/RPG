package MenusPack;

import CharactersPack.HeroPack.Hero;
import CharactersPack.MonsterPack.Monster;

import java.util.Scanner;

public class CombatLoop {
    public static boolean display(Hero hero, Monster monster, Scanner sc) {

        //Variable to decide if you loot something
        boolean wonFight;

        while (hero.getHp() > 0 && monster.getHp() > 0) {

            //Hero's attack
            System.out.println("1 : Auto attack\n2 : Spell");
            if (sc.nextInt() == 1) {
                int damage = hero.basicAttack(monster.getDefense(), monster.getDodgeChance(), monster.getName());
                monster.takeDamage(damage);
            }

            else {

                System.out.println("Current mana : " + hero.getMana());
                System.out.println("\n1 : Fireball - Manacost : 7\n2 : More spells coming soon\n\n");

                int userChoice = sc.nextInt();

                if (userChoice == 1 && hero.getMana() >= 7) {
                    monster.setHp(monster.getHp() - hero.fireBall(hero.getAttack(), monster.getDefense(), monster.getName()));
                    hero.setMana(hero.getMana() - 7);
                }

                else if (userChoice == 1 && hero.getMana() < 7) {
                    System.out.println("Your mana is too low to use this spell ..\n");
                }

                else {
                    System.out.println("This spell isn't available");
                }
            }

            System.out.printf("%s's remaining hp : %d\n\n", monster.getName(), monster.getHp());

            //Monster's attack
            if (monster.getHp() > 0) {
                int damage = monster.basicAttack(hero.getDefense(), hero.getDodgeChance(), hero.getName());
                hero.takeDamage(damage);
                System.out.printf("%s's remaining hp : %d\n\n", hero.getName(), hero.getHp());
            }

            System.out.println("Press enter to continue...");
            sc.nextLine();
        }

        if (hero.getHp() > 0) {
            return wonFight = true;
        }

        else {
            return wonFight = false;
        }
    }
}