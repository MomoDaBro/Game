import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public  class Main {

    public static Enemy randomEnemy() {

        int randomNumber = ThreadLocalRandom.current().nextInt(3);
        return switch (randomNumber) {
            case 0 -> new Enemy("Melee Unit", 30, 10);
            case 1 -> new Enemy("Ranged Unit", 15, 30);
            case 2 -> new Enemy("Magic Unit", 25, 25);
            default -> null;
        };

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int HRbaseHealthPoints = 100;
        int HRbaseDamage = 10;
//        int EN0baseHP = 30;
//        int EN0baseDamage = 10;
//        String EN0name = "Melee unit";
//        int EN1baseHP = 15;
//        int EN1baseDamage = 30;
//        String EN1name = "Ranged unit";
//        int EN2baseHP = 25;
//        int EN2baseDamage = 25;
//        String EN2name = "Magic unit";

//        List<Enemy> enemyList = new ArrayList<>();
//
//        enemyList.add(new Enemy("Melee Unit", 30, 10));
//        enemyList.add(new Enemy("Ranged Unit", 15, 30));
//        enemyList.add(new Enemy("Magic Unit", 25, 25));


        System.out.println("Please name your character");
        String characterName = scanner.nextLine();
        System.out.println(characterName + " enters the monster dungeon, will they survive?");
        System.out.println("尺ㄖㄖ爪 1");
        Enemy currentEnemy = randomEnemy();

//        int ENspecificHP;
//        int ENspecificATK;
//        String currentEnemy.getName();
//        if (ENtype == 0) {
//            ENspecificHP = EN0baseHP;
//            ENspecificATK = EN0baseDamage;
//            currentEnemy.getName() = EN0name;
//        } else {
//            if (ENtype == 1) {
//                ENspecificHP = EN1baseHP;
//                ENspecificATK = EN1baseDamage;
//                currentEnemy.getName() = EN1name;
//            } else {
//                ENspecificHP = EN2baseHP;
//                ENspecificATK = EN2baseDamage;
//                currentEnemy.getName() = EN2name;
//            }
//
//        }

        System.out.println("A " + currentEnemy.getName() + " appears!");
        int HRspecificHP = HRbaseHealthPoints;
        double DoubleENspecificATK;
        int convertENspecificATK;
        while (true) {
            int roundENspecificATK = currentEnemy.getDamage();
            System.out.println(currentEnemy.getName() + " currently has " + currentEnemy.getHealth() + " health");
            System.out.println(characterName + " currently has " + HRspecificHP + " health");
            System.out.println("Choose 1 to attack, 2 for block, 3 for items, 4 for escape");
            String characterInput = scanner.nextLine();
            int action = Integer.parseInt(characterInput);
            if (action == 1) {
                System.out.println(characterName + " attacks " + currentEnemy.getName() + " for " + HRbaseDamage + " damage!");
                currentEnemy.takeDamage(HRbaseDamage);
                if (currentEnemy.getHealth() >= 0) {
                    System.out.println("The " + currentEnemy.getName() + " attacks!");
                }
            } else if (action == 2) {
                System.out.println(characterName + " blocks the attack!");
                int HRblockChance = ThreadLocalRandom.current().nextInt(3);
                if (HRblockChance == 0) {
                    roundENspecificATK = 0;
                    System.out.println(characterName + " counters " + currentEnemy.getName() + " for " + HRbaseDamage + " damage!");
                    currentEnemy.takeDamage(HRbaseDamage);
                } else {
                    DoubleENspecificATK = currentEnemy.getDamage();
                    convertENspecificATK = (int) (DoubleENspecificATK * (40.0 / 100.0));
                    roundENspecificATK = convertENspecificATK;
                    System.out.println("The " + currentEnemy.getName() + " attacks!");
                }

            } else if (action == 4) {
                System.out.println(characterName + " decided to run away!");
                System.out.println(characterName + " is a coward!");
                System.out.println("₲₳₥Ɇ ØVɆⱤ");
                break;
            }

            if (currentEnemy.getHealth() <= 0) {
                System.out.println(currentEnemy.getName() + " has been slain!");
                System.out.println("尺ㄖㄖ爪 2");
                break;
            }
            HRspecificHP -= roundENspecificATK;

            System.out.println(characterName + " has taken " + roundENspecificATK + " damage!");
            if (HRspecificHP <= 0) {
                System.out.println(characterName + " has been slain!");
                System.out.println("₲₳₥Ɇ ØVɆⱤ");
                break;

            }

        }

        //Should each room be its own seperate loop?
        //If i do that, each room will need its own values for enemies health to make it harder
        //Or i could take the base health and scale it up like how i did with block damage (but reverse)


        currentEnemy = randomEnemy();

        System.out.println("A " + currentEnemy.getName() + " appears!");
        while (true) {
            int roundENspecificATK = currentEnemy.getDamage();
            System.out.println(currentEnemy.getName() + " currently has " + currentEnemy.getHealth() + " health");
            System.out.println(characterName + " currently has " + HRspecificHP + " health");
            System.out.println("Choose 1 to attack, 2 for block, 3 for items, 4 for escape");
            String characterInput = scanner.nextLine();
            int action = Integer.parseInt(characterInput);
            if (action == 1) {
                System.out.println(characterName + " attacks " + currentEnemy.getName() + " for " + HRbaseDamage + " damage!");
                currentEnemy.takeDamage(HRbaseDamage);
                System.out.println("The " + currentEnemy.getName() + " attacks!");
            } else if (action == 2) {
                System.out.println(characterName + " blocks the attack!");
                int HRblockChance = ThreadLocalRandom.current().nextInt(3);
                if (HRblockChance == 0) {
                    roundENspecificATK = 0;
                    System.out.println(characterName + " counters " + currentEnemy.getName() + " for " + HRbaseDamage + " damage!");
                    currentEnemy.takeDamage(HRbaseDamage);
                } else {
                    DoubleENspecificATK = currentEnemy.getDamage();
                    convertENspecificATK = (int) (DoubleENspecificATK * (40.0f / 100.0f));
                    roundENspecificATK = convertENspecificATK;
                    System.out.println("The " + currentEnemy.getName() + " attacks!");
                }

            } else if (action == 4) {
                System.out.println(characterName + " decided to run away!");
                System.out.println(characterName + " is a coward!");
                System.out.println("₲₳₥Ɇ ØVɆⱤ");
                break;
            }

            if (currentEnemy.getHealth() <= 0) {
                System.out.println(currentEnemy.getName() + " has been slain!");
                break;
            }
            HRspecificHP -= roundENspecificATK;

            System.out.println(characterName + " has taken " + roundENspecificATK + " damage!");
            if (HRspecificHP <= 0) {
                System.out.println(characterName + " has been slain!");
                System.out.println("₲₳₥Ɇ ØVɆⱤ");
                break;

            }

        }

    }

}


