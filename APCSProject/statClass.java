

public class statClass {
    
    private int attackStat;
    private int defenseStat;
    private int speedStat;
    private int specialStat;
    private int healthStat;
    private int critRate;

    private String name;

    public statClass(int attackStat, int defenseStat, int speedStat, int specialStat, int healthStat, int critRate, String name) {
        this.attackStat = attackStat;
        this.defenseStat = defenseStat;
        this.speedStat = speedStat;
        this.specialStat = specialStat;
        this.healthStat = healthStat;
        this.critRate = critRate;
        this.name = name;
    }

    public int getAttack() {
        return attackStat;
    }
    public int getDefense() {
        return defenseStat;
    }
    public int getSpeed() {
        return speedStat;
    }
    public int getSpecial() {
        return specialStat;
    }
    public int getHealth() {
        return healthStat;
    }
    public int getCritRate() {
        return critRate;
    }

    public void setAttack(int attackStat) {
        this.attackStat = attackStat;
    }
    public void setDefense(int defenseStat) {
        this.defenseStat = defenseStat;
    }
    public void setSpeed(int speedStat) {
        this.speedStat = speedStat;
    }
    public void setSpecial(int specialStat) {
        this.specialStat = specialStat;
    }

    public void setHealth(int healthStat) {
        this.healthStat = healthStat;
    }
    public void setCritRate(int critRate) {
        this.critRate = critRate;
    }

    public String returnAllStats() {
        return "Stats for " + name + "->\n Health: " + String.valueOf(healthStat) + "\n Attack: " + String.valueOf(attackStat) + "\n Defense: " + String.valueOf(defenseStat) + "\n Speed: " + String.valueOf(speedStat) + "\n Special: " + String.valueOf(specialStat);
    }

    public String getName() {
        return name;
    }
}
