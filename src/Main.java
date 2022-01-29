import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int HRbaseHealthPoints = 100;
        int HRbaseDamage = 10;
        int ENbaseHP = 30;
        int ENbaseDamage = 10;
        int shieldDamageReduction = 5;


        System.out.println("Please name your character");
        String characterName = scanner.nextLine();
        System.out.println(characterName + " enters the monster dungeon, will they survive?");
        System.out.println("尺ㄖㄖ爪 1");
        System.out.println("A melee unit appears!");

        int ENspecificHP = ENbaseHP;
        int HRspecificHP = HRbaseHealthPoints;
        while (true) {
            int roundENspecificATK = ENbaseDamage;
            System.out.println("Melee Unit currently has " + ENspecificHP + " health");
            System.out.println(characterName + " currently has " + HRspecificHP + " health");
            System.out.println("Choose 1 to attack, 2 for block, 3 for items, 4 for escape");
            String characterInput = scanner.nextLine();
            int action = Integer.parseInt(characterInput);
            if (action == 1) {
                System.out.println(characterName + " attacks melee unit for " + HRbaseDamage + " damage!");
                ENspecificHP -= HRbaseDamage;
            } else if (action == 2) {
                System.out.println(characterName + " blocks the attack!");
                roundENspecificATK -= 3;
            } else if (action == 4) {
                System.out.println(characterName + " decided to run away!");
                System.out.println(characterName + " is a coward!");
                System.out.println("₲₳₥Ɇ ØVɆⱤ");
                break;
            }

            if (ENspecificHP <= 0) {
                System.out.println("Melee Unit has been slain!");
                break;
            }
            HRspecificHP -= roundENspecificATK;
            System.out.println("The melee unit attacks!");
            System.out.println(characterName + " has taken " + roundENspecificATK + " damage!");

        }


    }

}


