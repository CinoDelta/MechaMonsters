package MainGameNec;
public class statClass {
    private int attackStat;
    private int defenseStat;
    private int speedStat;
    private int specialStat;
    private String name;

    public statClass(int attackStat, int defenseStat, int speedStat, int specialStat, String name) {
        this.attackStat = attackStat;
        this.defenseStat = defenseStat;
        this.speedStat = speedStat;
        this.specialStat = specialStat;
        this.name = name;
    }

    public int getAttack() {
        return this.attackStat;
    }
    public int getDefense() {
        return this.defenseStat;
    }
    public int getSpeed() {
        return this.speedStat;
    }
    public int getSpecial() {
        return this.specialStat;
    }

    public void setAttack(int newAttack) {
        this.attackStat = newAttack;
    }
    public void setDefense(int newDefense) {
        this.defenseStat = newDefense;
    }
    public void setSpeed(int newSpeed) {
        this.speedStat = newSpeed;
    }
    public void setSpecial(int newSpecial) {
        this.specialStat = newSpecial;
    }

    public String returnAllStats() {
        return "Stats for " + this.name + "-> \n Attack: " + String.valueOf(this.attackStat) + "\n Defense: " + String.valueOf(this.defenseStat) + "\n Speed: " + String.valueOf(this.speedStat) + "\n Special: " + String.valueOf(this.specialStat);
    }

    public String getName() {
        return this.name;
    }
}
