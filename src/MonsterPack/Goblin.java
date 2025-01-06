package MonsterPack;

import java.util.Random;

public class Goblin extends Monster {

    public Goblin(String name, int maxHP, int hp, int maxMana, int mana, int attack, int defense, int critChance, int critDamage, int dodgeChance) {
        super(name, maxHP, hp, maxMana, mana, attack, defense, critChance, critDamage, dodgeChance);
    }

    @Override
    public int basicAttack(int monsterAttack, int monsterCritChance, int monsterCritDamage, int heroDefense, int heroDodge, String heroName) {
        Random random = new Random();
        double damages;
        int critOrDodge;

        // Reset attack
        monsterAttack = this.attack;

        // Dice roll for attack range
        int randomNumber = random.nextInt(100) + 1;
        if (randomNumber > 70) {
            monsterAttack += 2;
        } else if (randomNumber <= 30) {
            monsterAttack -= 2;
        }

        // Dice roll for crit/dodge
        randomNumber = random.nextInt(100) + 1;
        critOrDodge = randomNumber + monsterCritChance - heroDodge;

        if (critOrDodge > 90) {
            // Crit damage calculation
            double critMultiplier = 1 + (double) monsterCritDamage / 100;
            damages = (critMultiplier * monsterAttack) - ((double) heroDefense / 2);
            System.out.printf("The \033[0;33m%s\033[0m attacked with double swords for a Crit Strike and inflicted \033[0;31m%.0f damage(s)\033[0m to \033[0;34m%s\033[0m!\n\n", name, damages, heroName);
        } else if (critOrDodge <= 10) {
            damages = 0;
            System.out.printf("\033[0;34m%s\033[0m rolled to dodge the hit and received no damage.\n\n", heroName);
        } else {
            damages = monsterAttack - ((double) heroDefense / 2);
            System.out.printf("The \033[0;33m%s\033[0m hits with his sword and inflicts \033[0;31m%.0f damage(s)\033[0m to \033[0;34m%s\033[0m.\n\n", name, damages, heroName);
        }

        // Round the double before casting to int
        damages = Math.round(damages);

        return (int) damages;
    }
}
