package rpg;

public class Dungeon0 extends Dungeon {
    
    public Dungeon0(Player p) {
        super(p);
    }

    @Override
    public void run() {
        int answer1 = RPG.promptForInput("You're standing at the mouth of a goblin-infested cave. Great " +
        "wealth awaits you or painful death. Do you go in?", "Yes", "No");
        if (answer1 == 2) {
            System.out.println("Weenie!");
            return;
        }
        System.out.println("Whew! You took a while to answer; I got nervous. Ok, back to business.");
        boolean notDone = false;
        int answer2;
        do {
            answer2 = RPG.promptForInput("Through the darkness of the cave, you can just barely "
            + "make out the forms of two goblins. What do you want to do?", "Rush them", "Use a ranged attack",
            "Attempt to tippety-toe around them");
            if (answer2 == 2) {
                System.out.println("Too bad! That's not supported yet.");
                notDone = true;
            }
            else {
                notDone = false;
            }
        } while(notDone);
        boolean gottaFight = true;
        switch(answer2) {
            case 1: {
                System.out.println("Cool. You rushed them."); 
            } break;
            case 2: {
                // I need to come up with a magic system at some point
            } break;
            case 3: {
                if (((p.check(p.getStealth())) > 13)) {
                    System.out.println("Sick. You snuck around them. Ordinarily there would be treasure here or something, but that isn't supported yet. Here's 50 XP.");
                    p.addXP(50);
                    gottaFight = false;
                    return;
                }
                else { 
                    System.out.println("Uh oh! They noticed you! Get ready to fight!");
                }
            } break;
        }
        if(gottaFight) {
            System.out.println("Due to incompetence on the programmer's part, you must fight them one at a time.");
            Player g1 = new Player("Weak Goblin 1", "Warrior", 6, 1, 14, 0, 14, 3, 3, 0, 6, 6);
            Player g2 = new Player("Weak Goblin 2", "Warrior", 6, 1, 14, 0, 14, 3, 3, 0, 6, 6);
            RPG.battle(p, g1);
            if (this.p.isAlive()) {
                RPG.battle(p, g2);
            }
            else {
                return;
            }
        }
        if (this.p.isAlive()) {
            System.out.println("Yay! You win the tutorial!");
        }
        else {
            System.out.println("Too bad.");
        }
    }
}