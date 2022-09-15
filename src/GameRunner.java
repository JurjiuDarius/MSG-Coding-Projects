import java.util.Objects;
import java.util.Scanner;
import static java.lang.System.out;

public class GameRunner {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        out.println("The game has started. Enter your character's name, health, damage, coins and number of levels " +
                "in the given order. If they are outside of the given bounds," +
                "they will be adjusted accordingly");
        String name;
        Knight player;
        int health=0, damage=0, coins=0,levels=0;
        while(true) {
            try {
                name = scanner.nextLine();
                health = scanner.nextInt();
                damage = scanner.nextInt();
                coins = scanner.nextInt();
                levels=scanner.nextInt();
                player= new Knight(health,damage,coins,levels,name);
                break;
            } catch (Exception e) {
                out.println("You have entered wrong data. Try again please.");
                scanner.nextLine();
            }
        }
    out.println("While started");
        Enemy current_enemy;
        int current_level=0;
        while(current_level<levels)
        {
            current_level++;
            if(current_level%3==0) current_enemy=new Witch();
            else
            if(current_level%3==1) current_enemy=new Giant();
            else
                current_enemy=new Dragon();

            while(player.getHealth()>0) {
                out.println(player);
                out.println(current_enemy);
                if (player.getCoins() > current_enemy.getGreed()) {
                    out.println("Choose Action (batlle,bribe,sneak)");
                } else {
                    out.println("Choose Action (batlle,sneak)");
                }

                String action=new String();
                while(action.isEmpty())
                {
                    action=scanner.nextLine();
                }
                out.println(action);
                if (Objects.equals(action,"battle")) {
                    player.deal_damage(current_enemy);
                    current_enemy.deal_damage(player);
                    if(current_enemy.getHealth()<=0)
                        break;

                } else if (Objects.equals(action,"bribe")) {
                    player.pay_coins(current_enemy.getGreed());
                    break;
                } else if (Objects.equals(action,"sneak")) {
                    if (current_enemy.wasDistracted()) {
                        out.println("You snuck away successfully");
                        break;
                    } else {
                        out.println("The monster caught you");
                        player.take_damge(100);
                    }

                }
                else {
                    out.println("You typed clumsily and the monster killed you");
                    player.setHealth(-1);
                    break;
                }

            }
                if(player.getHealth()<=0) {
                    out.println("You died");
                    break;
                }
                else continue;



        }
        if(player.getHealth()>0)
        {
            out.println("You have successfully retrieved the sword.");
        }
    }
}
