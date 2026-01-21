package MainGameNec;
import java.time.Duration;
import java.util.*;

import Monsters.Monster;

public class theGame {

    private static HashMap<String, String> tutorialBattleHashMap;
    

    private static void battleLoop(HashMap<String, String> battleInfo) {
        new Monster(0, 0, 0, 0, null);
    }

    private static void initializeBattleInfo() {
        tutorialBattleHashMap.put("Monster", "LoserMonster");
        
    }

    public static void main(String[] args) throws InterruptedException {

        Scanner mainSc = new Scanner(System.in);

        System.out.println("Welcome to Mech Fight X!");

        Thread.sleep(1000);

        System.out.println("A java program text battle simulator!");
        
        Thread.sleep(1000);

        System.out.println("However, first things first, may I have your name? Input below:");

        String thePlayersName = mainSc.nextLine();

        Player thePlayer = new Player(1, 1, 1, 1, thePlayersName);

        System.out.println("Great! We have created your own player file.");

        Thread.sleep(1000);
        
        thePlayer.setAttack(10);

        System.out.println("Your stats are as shown below: \n" + thePlayer.returnAllStats());

        Thread.sleep(1000);

        System.out.println("Throughout the game, you will gain rougelike-power ups, choices of new mech suits, and infinitely scaling fights against monsters.");

        Thread.sleep(3000);

        System.out.println("To keep this game small in scope however, there will only be 3 mech suits, and 3 types of monsters. Sorry! :D");


        

    }
}