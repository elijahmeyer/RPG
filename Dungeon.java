package rpg;

public abstract class Dungeon implements Runnable {
    Player p;
    
    public Dungeon(Player p) {
        this.p = p;
    }
    
    @Override
    public abstract void run();
}
