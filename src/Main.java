import CharactersPack.HeroPack.Hero;
import CharactersPack.HeroPack.RandomiseHero;
import CharactersPack.MonsterPack.Dragon;
import CharactersPack.MonsterPack.Goblin;
import CharactersPack.MonsterPack.Monster;
import CharactersPack.MonsterPack.RandomiseMonster;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Hero hero = initGame();

        menuLoop(hero, sc);
        
    }


    public static void menuLoop(Hero hero, Scanner sc) {
        //Combat loop and print winner
        boolean continueGame = false;
        do {

            System.out.println("1 : Fight a monster\n2 : Rest (Regenerate HP and Mana)\n3 : Save Game\n\n");
            int userChoice = sc.nextInt();
            if (userChoice == 1) {
                Monster monster = createMonster();
                System.out.println(combatLoop(hero, monster, sc));
            } else if (userChoice == 2) {
                System.out.println("You rest and regenerate maximum HP and Mana.\n\n");
                hero.rest();
            } else {
                System.out.println("Work in Progress.\n\n");
            }

            System.out.println("Do you want to keep going ? Press 1 for Yes, 2 for No.");
            if (sc.nextInt() == 1) {continueGame = true;}
            else {continueGame = false;}

        } while (continueGame);
    }

    public static String combatLoop(Hero hero, Monster monster, Scanner sc) {
        while (hero.getHp() > 0 && monster.getHp() > 0) {

            //Hero's attack
            System.out.println("1 : Auto attack\n2 : Spell");
            if (sc.nextInt() == 1) {
                monster.setHp(monster.getHp() - hero.basicAttack(monster.getDefense(), monster.getDodgeChance(), monster.getName()));
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
                hero.setHp(hero.getHp() - monster.basicAttack(hero.getDefense(), hero.getDodgeChance(), hero.getName()));
                System.out.printf("%s's remaining hp : %d\n\n", hero.getName(), hero.getHp());
            }
            System.out.println("Press enter to continue...");
            sc.nextLine();
        }
        if (hero.getHp() <= 0) {
            return hero.getName() + " has lost!";
        } else {
            return hero.getName() + " has won!";
        }
    }

    public static Hero initGame(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Do you want to start a new game ?");
        System.out.println("1 : New game\n2 : Load game");
        int choice = sc.nextInt();

        if (choice == 1) {
            return createHero();
        }
        else if (choice == 2) {
            System.out.println("No saved game currently ..");
            return null;
        }
        return null;
    }

    public static Hero createHero() {

        //Temporarily hardcoded crit and dodge stats
        int critChance = 10;
        int critDamage = 50;
        int dodge = 10;
        String [] inventory;

        //Randomise, create and display the hero
        RandomiseHero rand = new RandomiseHero();
        Hero hero = new Hero("Martin", rand.getHp(), rand.getHp(), rand.getMana(),rand.getMana(), rand.getAttack(), rand.getDefense(), critChance, critDamage, dodge);
        System.out.println("New game started ! Your hero got generated");
        hero.display();
        return hero;

    }

    public static Monster createMonster() {

        //Temporarily hardcoded crit and dodge stats
        int critChance = 10;
        int critDamage = 50;
        int dodge = 10;

        //Random entre 1 et 3
        int rollMonster = 1 + (int)(Math.random() * 3);

        if (rollMonster == 1) {
            RandomiseMonster rand = new RandomiseMonster("Goblin");
            Goblin monster = new Goblin(rand.getName(), rand.getHp(), rand.getHp(), rand.getMana(), rand.getMana(), rand.getAttack(), rand.getDefense(), critChance, critDamage, dodge);
            monster.display();
            return monster;
        }
       /* else if (rollMonster == 2) {
            RandomiseMonster rand = new RandomiseMonster("Ork");
            System.out.println("Ork still in development");
        }*/
        else {
            RandomiseMonster rand = new RandomiseMonster("Dragon");
            Dragon monster = new Dragon(rand.getName(), rand.getHp(), rand.getHp(), rand.getMana(), rand.getMana(), rand.getAttack(), rand.getDefense(), critChance, critDamage, dodge);
            monster.display();
            return monster;
        }

    }
}

