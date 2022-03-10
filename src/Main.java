import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int HRbaseHealthPoints = 100;
        int HRbaseDamage = 10;
        int EN0baseHP = 30;
        int EN0baseDamage = 10;
        String EN0name = "Melee unit";
        int EN1baseHP = 15;
        int EN1baseDamage = 30;
        String EN1name = "Ranged unit";
        int EN2baseHP = 25;
        int EN2baseDamage = 25;
        String EN2name = "Magic unit";

        List<Enemy> EnemyList = new ArrayList<>();

        Enemy enemy1 = new Enemy("Melee Unit", 30, 10);
        Enemy enemy2 = new Enemy("Ranged Unit", 15, 30);
        Enemy enemy3 = new Enemy("Magic Unit", 25, 25);

        EnemyList.add(enemy1);
        EnemyList.add(enemy2);
        EnemyList.add(enemy3);


        System.out.println("Please name your character");
        String characterName = scanner.nextLine();
        System.out.println(characterName + " enters the monster dungeon, will they survive?");
        System.out.println("尺ㄖㄖ爪 1");
        int ENtype = ThreadLocalRandom.current().nextInt(3);

        int ENspecificHP;
        int ENspecificATK;
        String ENspecificName;
        if (ENtype == 0) {
            ENspecificHP = EN0baseHP;
            ENspecificATK = EN0baseDamage;
            ENspecificName = EN0name;
        } else {
            if (ENtype == 1) {
                ENspecificHP = EN1baseHP;
                ENspecificATK = EN1baseDamage;
                ENspecificName = EN1name;
            } else {
                ENspecificHP = EN2baseHP;
                ENspecificATK = EN2baseDamage;
                ENspecificName = EN2name;
            }

        }
        System.out.println("A " + ENspecificName + " appears!");
        int HRspecificHP = HRbaseHealthPoints;
        double DoubleENspecificATK;
        int convertENspecificATK;
        while (true) {
            int roundENspecificATK = ENspecificATK;
            System.out.println(ENspecificName + " currently has " + ENspecificHP + " health");
            System.out.println(characterName + " currently has " + HRspecificHP + " health");
            System.out.println("Choose 1 to attack, 2 for block, 3 for items, 4 for escape");
            String characterInput = scanner.nextLine();
            int action = Integer.parseInt(characterInput);
            if (action == 1) {
                System.out.println(characterName + " attacks " + ENspecificName + " for " + HRbaseDamage + " damage!");
                ENspecificHP -= HRbaseDamage;
                if (ENspecificHP >= 0){
                    System.out.println("The " + ENspecificName + " attacks!");
                }
            } else if (action == 2) {
                System.out.println(characterName + " blocks the attack!");
                int HRblockChance = ThreadLocalRandom.current().nextInt(3);
                if (HRblockChance == 0) {
                    roundENspecificATK = 0;
                    System.out.println(characterName + " counters " + ENspecificName + " for " + HRbaseDamage + " damage!");
                    ENspecificHP -= HRbaseDamage;
                } else {
                    DoubleENspecificATK = ENspecificATK;
                    convertENspecificATK = (int) (DoubleENspecificATK * (40.0/100.0));
                    roundENspecificATK = convertENspecificATK;
                    System.out.println("The " + ENspecificName + " attacks!");
                }

            } else if (action == 4) {
                System.out.println(characterName + " decided to run away!");
                System.out.println(characterName + " is a coward!");
                System.out.println("₲₳₥Ɇ ØVɆⱤ");
                break;
            }

            if (ENspecificHP <= 0) {
                System.out.println(ENspecificName + " has been slain!");
                System.out.println("尺ㄖㄖ爪 2");
                break;
            }
            HRspecificHP -= roundENspecificATK;

            System.out.println(characterName + " has taken " + roundENspecificATK + " damage!");
            if (HRspecificHP <= 0){
                System.out.println(characterName + " has been slain!");
                System.out.println("₲₳₥Ɇ ØVɆⱤ");
                break;

            }

        }

        //Should each room be its own seperate loop?
        //If i do that, each room will need its own values for enemies health to make it harder
        //Or i could take the base health and scale it up like how i did with block damage (but reverse)

        ENtype = ThreadLocalRandom.current().nextInt(3);
        if (ENtype == 0) {
            ENspecificHP = EN0baseHP;
            ENspecificATK = EN0baseDamage;
            ENspecificName = EN0name;
        } else {
            if (ENtype == 1) {
                ENspecificHP = EN1baseHP;
                ENspecificATK = EN1baseDamage;
                ENspecificName = EN1name;
            } else {
                ENspecificHP = EN2baseHP;
                ENspecificATK = EN2baseDamage;
                ENspecificName = EN2name;
            }

        }
        System.out.println("A " + ENspecificName + " appears!");
        while (true) {
            int roundENspecificATK = ENspecificATK;
            System.out.println(ENspecificName + " currently has " + ENspecificHP + " health");
            System.out.println(characterName + " currently has " + HRspecificHP + " health");
            System.out.println("Choose 1 to attack, 2 for block, 3 for items, 4 for escape");
            String characterInput = scanner.nextLine();
            int action = Integer.parseInt(characterInput);
            if (action == 1) {
                System.out.println(characterName + " attacks " + ENspecificName + " for " + HRbaseDamage + " damage!");
                ENspecificHP -= HRbaseDamage;
                System.out.println("The " + ENspecificName + " attacks!");
            } else if (action == 2) {
                System.out.println(characterName + " blocks the attack!");
                int HRblockChance = ThreadLocalRandom.current().nextInt(3);
                if (HRblockChance == 0) {
                    roundENspecificATK = 0;
                    System.out.println(characterName + " counters " + ENspecificName + " for " + HRbaseDamage + " damage!");
                    ENspecificHP -= HRbaseDamage;
                } else {
                    DoubleENspecificATK = ENspecificATK;
                    convertENspecificATK = (int) (DoubleENspecificATK * (40.0f/100.0f));
                    roundENspecificATK = convertENspecificATK;
                    System.out.println("The " + ENspecificName + " attacks!");
                }

            } else if (action == 4) {
                System.out.println(characterName + " decided to run away!");
                System.out.println(characterName + " is a coward!");
                System.out.println("₲₳₥Ɇ ØVɆⱤ");
                break;
            }

            if (ENspecificHP <= 0) {
                System.out.println(ENspecificName + " has been slain!");
                break;
            }
            HRspecificHP -= roundENspecificATK;

            System.out.println(characterName + " has taken " + roundENspecificATK + " damage!");
            if (HRspecificHP <= 0){
                System.out.println(characterName + " has been slain!");
                System.out.println("₲₳₥Ɇ ØVɆⱤ");
                break;

            }

        }

    }

}


