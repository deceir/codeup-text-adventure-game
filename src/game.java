import java.util.Scanner;


public class game {

    Scanner sc = new Scanner(System.in);


    public static int randomAttack() {
        return (int)(Math.random() * 15) + 5;
    }

    public static int enemyAttack() {
        return (int)(Math.random() * 15) + 10;
    }

    public static int attackChance() {
        return (int)(Math.random() * 100) + 1;
    }

    public static int battle() {

        Scanner sc = new Scanner(System.in);

        int enemyHP;
        int heroHP;
        int potionsAvailable;

        System.out.println("Your HP is set to full.");
        heroHP = 100;
        System.out.println("HP: " + heroHP);
        enemyHP = 100;
        System.out.println("Enemy HP: " + enemyHP);

        potionsAvailable = 5;



        int attackRoll;
        String userAction;
        int attackValue;
        int critMultiplier;
        do {
            System.out.println("What action will you take?");
            System.out.println("You have " + potionsAvailable + " potions.");
            System.out.println("-Attack");
            System.out.println("-Heal");
            System.out.println("-Flee");

            userAction = sc.nextLine();

            if (userAction.equalsIgnoreCase("attack")) {
                System.out.println("You attack your enemy.");
                attackValue = randomAttack();
                critMultiplier = attackChance();
                if (critMultiplier > 60) {
                    attackValue *= 2;
                }
                System.out.println("You deal " + attackValue + " points of damage to your enemy!");
                if (critMultiplier > 60) {
                    System.out.println("It critically hits!");
                }
                enemyHP -= attackValue;
            }
            if (userAction.equalsIgnoreCase("heal")) {
                if (potionsAvailable > 0) {
                    potionsAvailable -= 1;
                    System.out.println("You drink a healing potion.");
                    if (heroHP + 50 > 100) {
                        heroHP = 100;
                    } else {
                        heroHP += 50;
                    }
                } else {
                    System.out.println("You do not have any potions!");
                }
            }

            if (userAction.equalsIgnoreCase("flee")) {
                System.out.println("The sting of cowardice runs through your body as you run away.");
                System.out.println("You lose.");
                System.exit(0);
            }

            if (enemyHP <= 0) {
                System.out.println("You have defeated your enemy.");
                return 1;
            }

            System.out.println("Your enemy prepares to attack.");

            attackRoll = attackChance();
            if (attackRoll > 50) {
                attackValue = enemyAttack();
                heroHP -= attackValue;
                System.out.println("Your enemy deals " + attackValue + " points of damage!");
            } else {
                System.out.println("They miss!");
            }

            if (enemyHP < 0) {
                enemyHP = 0;
            }
            if (heroHP < 0) {
                heroHP = 0;
            }
            System.out.print("Hero HP: " + heroHP);
            System.out.print(" Enemy HP: " + enemyHP);
            System.out.println("");
            if (heroHP <= 0) {
                System.out.println("You have been defeated");
                return 0;
            };
            if (enemyHP <= 0) {
                System.out.println("You have defeated your enemy.");
                return 1;
            }
        } while (heroHP > 0 || enemyHP > 0);
        if (enemyHP > 0) {
            System.out.println("You lose.");
            System.exit(0);
            return 0;
        } else {
            System.out.println("You have defeated your enemy.");
            return 1;
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Would you like to begin the game? (y/n)");

        String gameStart = sc.nextLine();

        boolean gameWillStart;

        if (gameStart.equalsIgnoreCase("y")) {
            gameWillStart = true;
        } else {
            gameWillStart = false;
        }
        if (!gameWillStart) {
            System.exit(0);
        }

        System.out.println("Please enter our hero's name!");

        String heroName = sc.nextLine();

        System.out.println("Welcome to the story of how our hero, " + heroName + ", faced off against the mighty dragon, Vhermatron.");

        System.out.println("As " + heroName + " enters the dark cavern, a goblin attacks!");

        int battleResult;

        battleResult = battle();

        if (battleResult == 1) {
            System.out.println("After defeating the goblin, you continue through the cavern.");
        }
        System.out.println("What action will you take?");
        System.out.println("-Continue");
        System.out.println("-Search");

        String userResponse;
        userResponse = sc.nextLine();

        int searchChance;
        int userTreasure = 0;

        if (userResponse.equalsIgnoreCase("search")) {
            searchChance = attackChance();
            if (searchChance > 40) {
                System.out.println("You find something!");
                userTreasure += 1;
            }
        }

    }


}
