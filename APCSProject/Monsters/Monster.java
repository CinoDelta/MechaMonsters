package Monsters;
import MainGameNec.*;

public class Monster extends statClass implements battleObject {
    private int attackStat;
    private int defenseStat;
    private int speedStat;
    private int specialStat;
    private String name;
   
    public Monster(int attackStat, int defenseStat, int speedStat, int specialStat, String name) {
        super(attackStat, defenseStat, speedStat, specialStat, name);
    }

    public void attack() {

    }
    public void defend() {

    }
    public void special() {

    }
    public void updateHP() {

    }
    public void isDead() {

    }
}
