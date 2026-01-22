package Monsters;
import MainGameNec.*;

public class Monster extends statClass implements battleObject<Player> {
    private int attackStat;
    private int defenseStat;
    private int speedStat;
    private int specialStat;
    private int healthStat;
    private int critRate;
    private String name = "";

    public String elementalType;
   
    public Monster(int attackStat, int defenseStat, int speedStat, int specialStat, int healthStat, int critRate, String name, String elementalType) {
        super(attackStat, defenseStat, speedStat, specialStat, healthStat, critRate, name);
        this.elementalType = elementalType;
    }

    public void attack(Player targetPerson) throws InterruptedException { 
        
    }   

    public void defend() {

    }

    public void special(statClass targetPlayer) throws InterruptedException {
    }
    
    public boolean isDead() throws InterruptedException {
        if (getHealth() <= 0) {
            System.out.println(getName() + " collapsed!");
            Thread.sleep(2000);
        }
        return (getHealth() <= 0);
    }

}
