import java.util.Scanner;


public class game {


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

    }


}
