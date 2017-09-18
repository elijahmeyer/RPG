package rpg;
import java.util.Scanner;

public class RPG {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your character's name: ");
        String name = input.nextLine();
        int classNum = promptForInput("Please choose a class:", "Warrior", "Wizard", "Rogue");
        String clas = "";
        switch(classNum) {
            case 1: {
                clas = "Warrior";
            } break;
            case 2: {
                clas = "Wizard";
            } break;
            case 3: {
                clas = "Rogue";
            } break;
        }
        Player p = new Player(name, clas);
        int dungeonNum = promptForInput("Which dungeon would you like to run?", "Dungeon0");
        switch(dungeonNum) {
            case 1: {
                Runnable d0 = new Dungeon0(p);
                d0.run();
            } break;
        }
    }
    
    public static int promptForInput(String question, String... opt1) {
        Scanner input = new Scanner(System.in);
        boolean notDone = true;
        int j = 0;
        while (notDone) {
            System.out.println(question);
            int i = 1;
            for (String s : opt1) {
                System.out.println(i + ". " + s);
                i++;
            }
            try {
            j = input.nextInt();
            if (j > (i - 1) || j < 1) {
                System.out.println("Please enter a number between 1 and " + (i - 1));
            }
            else {
                notDone = false;
            }
            } catch (Exception ex) {
                System.out.println("Please enter a number.");
                input.next();
            }
        }
        return j;
    }
    public static void battle(Player p1, Player p2) {
        while (p1.getHealth() > 0 && p2.getHealth() > 0) {
            p1.attack(p2);
            System.out.println("Health: " + p2.getHealth());
            if (p2.getHealth() > 0) {
                p2.attack(p1);
                System.out.println("Health: " + p1.getHealth());
            }
        }
    }
}