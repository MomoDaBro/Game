import java.util.Scanner;

public class Main {

// There will be 3 main parts to each level
// the first part will be the character you play as
// The componets that make up the character stage are as follows
// Hitpoints, how much health you currently have should be stated after every turn
// Turn Options, the four actions that can be chosen during your turn
// These four options are Attack, dealing a static amount of damage unless increased with means later on mentioned (maybe crits..?)
// Blocking is the second option, allowing the user to take less damage, this amount can also be scaled later through means
// Item, allowing a user to use an item in their inventory, this action does not consume a turn
// Escape, Escape essentially ends the game allowing a user to restart.

// Part two consists of the enemies that you will face upon playing.
// The compentnets that make up the enemies are as follows
// First the number of enemies that you take on at once will be determined
// Easier and beginner levels will contain one enemy while as you progress you can get more enemies to appear
// Damage: Enemies will deal static damage unless affected by an item, harder enemies deal more damage
// There will be three base types of enemies, a melee unit, a ranged unit, and a magic unit.
// Bosses may be implemted but not fully thought out just yet.

// The last part is items as previously mentioned.
// After an enemy is slain it will have a chance of dropping an item based on its class.
// The current items accessible are, Regen potions, Defense up, Attack up, Clear Effect, Spell card

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


