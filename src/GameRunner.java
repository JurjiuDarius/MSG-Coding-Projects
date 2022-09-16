import java.util.Scanner;

import static java.lang.System.out;

public class GameRunner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        out.println("The game has started. Enter your character's name, health, damage, coins and number of levels " +
                "in the given order. If they are outside of the given bounds," +
                "they will be adjusted accordingly");
        String name;
        Knight player;
        int health, damage, coins, levels;
        while (true) {
            try {
                name = scanner.nextLine();
                health = scanner.nextInt();
                damage = scanner.nextInt();
                coins = scanner.nextInt();
                levels = scanner.nextInt();
                scanner.nextLine();
                player = new Knight(health, damage, coins, levels, name);
                break;
            } catch (Exception e) {
                out.println("You have entered wrong data. Try again please.");
                scanner.nextLine();
            }
        }
        out.println("While started");
        Enemy currentEnemy;
        int currentLevel = 0;
        while (currentLevel < levels) {
            currentLevel++;
            if (currentLevel % 3 == 0) currentEnemy = new Witch();
            else if (currentLevel % 3 == 1) currentEnemy = new Giant();
            else
                currentEnemy = new Dragon();

            label:
            while (player.getHealth() > 0) {
                out.println(player);
                out.println(currentEnemy);
                if (player.getCoins() > currentEnemy.getGreed()) {
                    out.println("Choose Action (battle,bribe,sneak)");
                } else {
                    out.println("Choose Action (battle,sneak)");
                }

                String action;

                action = scanner.nextLine();
                out.println(action);
                switch (action) {
                    case "battle":
                        player.takeDamage(currentEnemy.getDamage());
                        currentEnemy.takeDamage(player.getDamage());
                        if (currentEnemy.getHealth() <= 0)
                            break label;

                        break;
                    case "bribe":
                        player.payCoins(currentEnemy.getGreed());
                        break label;
                    case "sneak":
                        if (currentEnemy.wasDistracted()) {
                            out.println("You snuck away successfully");
                            break label;
                        } else {
                            out.println("The monster caught you");
                            player.takeDamage(100);
                        }

                        break;
                    default:
                        out.println("You typed clumsily and the monster killed you");
                        player.setHealth(-1);
                        break label;
                }

            }
            if (player.getHealth() <= 0) {
                out.println("You died");
                break;
            } else if (player.getCoins() < 0) {
                out.println("You tried offering an insulting sum. The monster killed you.");
            }


        }
        if (player.getHealth() > 0) {
            out.println("You have successfully retrieved the sword.");
        }
    }
}
