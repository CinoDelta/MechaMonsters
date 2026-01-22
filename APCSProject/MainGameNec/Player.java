package MainGameNec;

public class Player extends statClass implements battleObject<statClass>  {

    private MechSuit mySuit;
    public String battleClass;
    public int defending;

    public Player(int attackStat, int defenseStat, int speedStat, int specialStat, int healthStat, int critRate, String name, String battleClass) {
        super(attackStat, defenseStat, speedStat, specialStat, healthStat, critRate, name);
        this.battleClass = battleClass;
        defending = 0;
        mySuit = new MechSuit(1, 1, 1, 1, 1, 1, "Your mech suit");
        System.out.println("Health stat put in: " + healthStat);
    }

    public void attack(statClass targetPerson) throws InterruptedException { // this is a non-primitive, so it should be a referencer and actually effect the stats
        System.out.println(getName() + " attacks " + targetPerson.getName() + "!");
        Thread.sleep(1000);
        int damage = super.getAttack() * 2 - targetPerson.getDefense();

        if (damage <= 0) {
            damage = 1;
        }

        if ((Math.random() * 100) < super.getCritRate()) { // Did we crit chat?
            targetPerson.setHealth(targetPerson.getHealth() - damage * 2);
            System.out.println("\u001b[31mCritical hit!!!\n");
            Thread.sleep(1000);
        } else {
            targetPerson.setHealth(targetPerson.getHealth() - damage);
        }
        System.out.println("\u001b[0m" + getName() + " did " + damage + " damage.");
        Thread.sleep(2000);
        System.out.println(targetPerson.getName() + "'s hp:\n Before:  " + (targetPerson.getHealth() + damage) + "\n After: " + targetPerson.getHealth());
        Thread.sleep(2000);
    }   

    @Override
    public int getAttack() {
        return super.getAttack() + mySuit.getAttack();
    }

    @Override
    public int getDefense() {
        return super.getDefense() + mySuit.getDefense() * (1 + defending);
    }

    @Override
    public int getSpeed() {
        return super.getSpeed() + mySuit.getSpeed();
    }

    @Override
    public int getSpecial() {
        return super.getSpecial() + mySuit.getSpecial();
    }

    public int getHealth() {
        return super.getHealth() + mySuit.getHealth();
    }

    @Override
    public int getCritRate() {
        return super.getSpeed() + mySuit.getCritRate();
    }

    public MechSuit getMechSuit() {
        return mySuit;
    }

    public void defend() throws InterruptedException {
        System.out.println(getName() + " defends for the next attack.");
        defending = 1;
        Thread.sleep(2000);
    }
    public void special(statClass targetPerson) throws InterruptedException {
        Thread.sleep(1000);
    }

    public boolean isDead() throws InterruptedException { // blunder #2: should've been in the stat class instead. exact same as monster method.
        if (getHealth() <= 0) {
            System.out.println(getName() + " collapsed!");
            Thread.sleep(2000);
        }
        return (getHealth() <= 0);
    }
}
