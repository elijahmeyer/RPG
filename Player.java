package rpg;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private String clas;
    private int hitDie;
    private int level = 1;
    private int health;
    private int xp;
    private int maj;
    private int maxHealth;
    private int atk;
    private int def;
    private int maxMaj;
    private int intl;
    private int stealth;
    
    public Player(String name, String clas, int hitDie, int level, int health, int maj, int maxHealth, int atk, int def, int maxMaj, int intl, int stealth) {
        this.name = name;
        this.clas = clas;
        this.hitDie = hitDie;
        this.level = level;
        this.health = health;
        this.maj = maj;
        this.maxHealth = maxHealth;
        this.atk = atk;
        this.def = def;
        this.maxMaj = maxMaj;
        this.intl = intl;
        this.stealth = stealth;
    }
    
    public Player(String name, String clas) {
        this.name = name;
        this.clas = clas;
        this.setStats();
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getHealth() {
        return this.health;
    }
    
    public void setHealth(int i) {
        if (i <= this.maxHealth) {
            this.health = i;
        }
        else {
            this.health = this.maxHealth;
        }
    }
    
    public int getAtk() {
        return this.atk;
    }
    
    public int getDef() {
        return this.def;
    }
    
    public int getStealth() {
        return this.stealth;
    }
    
    public int getMaj() {
        return this.maj;
    }
    
    public int useMaj(int i) {
        int j = 0;
        if (i <= this.maj) {
            this.maj -= i;
        }
        else {
            j = 1;
        }
        return j;
    }
    
    public void setStats() {
        switch(clas) {
            case "Warrior": {
                this.hitDie = 8;
                this.atk = 8 + (2 * level);
                this.def = 8 + (2 * level);
                this.maxMaj = 0;
                this.maj = this.maxMaj;
                this.maxHealth = 15 + level;
                this.health = this.maxHealth;
                this.intl = 5 + (level / 2);
                this.stealth = 6 + (level /  2);
            } break;
            
            case "Wizard": {
                this.hitDie = 4;
                this.atk = 5 + (level / 2);
                this.def = 5 + (level / 2);
                this.maxMaj = 7 + (3 * level);
                this.maj = this.maxMaj;
                this.maxHealth = 7 + level;
                this.health = this.maxHealth;
                this.intl = 8 + (2 * level);
                this.stealth = 8 + (level / 2);
            } break;
            
            case "Rogue": {
                this.hitDie = 6;
                this.atk = 6 + (2 * level);
                this.def = 6 + (2 * level);
                this.maxMaj = 3 + (level / 2);
                this.maj = this.maxMaj;
                this.maxHealth = 10 + level;
                this.health = this.maxHealth;
                this.intl = 7 + (level / 2);
                this.stealth = 8 + (2 * level);
            }
        }
    }
    
    public void addXP(int amt) {
        this.xp += amt;
    }
    
    public void levelUp() {
        level++;
        this.setStats();
    }
    
    public void attack(Player p) {
        System.out.println(this.name + " attacks " + p.getName());
        int roll = roll(20);
        if ((this.atk / 4) + roll > p.getDef()) {
            int dmg = roll(this.hitDie);
            System.out.println("Did " + dmg + " damage!");
            p.getHit(dmg);
        }
        else {
            System.out.println(this.name + " missed!");
        }
    }
    
    public void getHit(int i) {
        this.health -= i;
        if (this.health <= 0) {
            System.out.println(this.name + " died.");
        }
    }
    
    public static int roll(int i) {
        return (int) (Math.random() * i) + 1;
    }
    
    public int check(int stat) {
        return roll(20) + stat;
    }
    
    public boolean isAlive() {
        return this.health > 0;
    }
    
    @Override
    public String toString() {
        return this.name + "\nLv. " + this.level + " " + this.clas + "\nHP: " 
        + this.health + "/" + this.maxHealth + "     " + "MP: " + this.maj + "/" +
        this.maxMaj + "\nATK: " + this.atk + "\nDEF: " + this.def + "\nINT: " + this.intl +
        "\nStealth: " + this.stealth;
    }
}