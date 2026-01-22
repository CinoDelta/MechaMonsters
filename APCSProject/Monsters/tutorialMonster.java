package Monsters;
import MainGameNec.Player;

public class tutorialMonster extends Monster {
    private int attackStat;
    private int defenseStat;
    private int speedStat;
    private int specialStat;
    private int healthStat;
    private int critRate;
    private String name = "";

    public String elementalType;

    public tutorialMonster(int attackStat, int defenseStat, int speedStat, int specialStat, int healthStat, int critRate, String name, String elementalType) {
        super(attackStat, defenseStat, speedStat, specialStat, healthStat, critRate, name, elementalType);
    }

    public void attack(Player targetPerson) throws InterruptedException { 
        double rand = Math.random() * 100;

        System.out.println(targetPerson.getHealth());
        System.out.println(getName() + "'s turn!");

        Thread.sleep(2000);

        if (rand > 75) { // 25% chance first move
            System.out.println(getName() + " tickles you.");
            Thread.sleep(2000);
            System.out.println("...");
            Thread.sleep(2000);
            System.out.println("It did nothing.");
            Thread.sleep(2000);
        } else if (rand > 50) { // 25% chance second move
            System.out.println(getName() + "fired a special beam cannon!");
            Thread.sleep(1000);
            int damage = 5 + (int) Math.ceil(Math.random() * 5);
            targetPerson.setHealth(targetPerson.getHealth() - damage);
            System.out.println("Did " + damage + " damage!");
            Thread.sleep(2000);
            System.out.println(targetPerson.getName() + "'s hp:\n Before:  " + (targetPerson.getHealth() + damage) + "\n After: " + targetPerson.getHealth());
            Thread.sleep(2000);
        } else { // 50% chance normal attack
            System.out.println(this.getName() + " pokes you!");
            Thread.sleep(1000);
            int damage = this.getAttack() * 2 - targetPerson.getDefense();

            if (damage <= 0) {
                damage = 1;
            }

            if ((Math.random() * 100) < critRate) { // Did we crit chat?
                targetPerson.setHealth(targetPerson.getHealth() - damage * 2);
                System.out.println("\u001b[31mCritical hit!!!\n");
                Thread.sleep(1000);
            } else {
                System.out.println(targetPerson.getHealth());
                targetPerson.setHealth(targetPerson.getHealth() - damage);
                System.out.println(targetPerson.getHealth());
            }
            System.out.println("\u001b[0m" + getName() + " did " + damage + " damage.");
            Thread.sleep(2000);
            System.out.println(targetPerson.getName() + "'s hp:\n Before:  " + (targetPerson.getHealth() + damage) + "\n After: " + targetPerson.getHealth());
            Thread.sleep(2000);
        }
    }   
}
