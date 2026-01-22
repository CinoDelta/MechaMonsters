package MainGameNec;
import java.time.Duration;
import java.util.*;

import Monsters.Monster;
import Monsters.tutorialMonster;

public class theGame {


    public static Player thePlayer;

    private static int playerOptionChoose(String[]options) throws InterruptedException {
        System.out.println("Choose an option.");
        String outputString = "";

        int index = 1; // i know its know actually 1. im making it one so that it goes like press 1 or 2 or.. etc.
        for (String option : options) {
            outputString = outputString + option + ": " + index + "\n";
            index ++;
        }

        System.out.println(outputString);

        int finalResult = 0;

        Scanner optionScanner = new Scanner(System.in);

        while (finalResult == 0) {
            try {
                finalResult = optionScanner.nextInt();
                if (finalResult > 0 && finalResult <= options.length) {
                    System.out.println("You have chosen option " + finalResult + "!");
                } else {
                    finalResult = 0;
                    System.out.println("Please input a number in the interval range of E {Z, [1" + options.length + "]}.");
                }
                Thread.sleep(2000);
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data type. Please provide an integer.");
                Thread.sleep(2000);
            }
        }

        return finalResult;
    }

    private static void playersTurn(Monster monsterOnField) throws InterruptedException {
        System.out.println("Its " + thePlayer.getName() + "'s turn!");

        thePlayer.defending = 0;

        int chosenDecision = playerOptionChoose(new String[] {"Attack", "Defend", "Special"});

        switch (chosenDecision) {
            case 1:// attack
                thePlayer.attack(monsterOnField);
                break;
            case 2:// defend
                thePlayer.defend();
                break;
            case 3:// special
                int specialDecision = playerOptionChoose(thePlayer.getMechSuit().getSpecialMoves());
                String chosenMove = thePlayer.getMechSuit().getSpecialMoves()[specialDecision - 1];

                if (chosenMove == "NONE") {
                    System.out.println("Why'd you do that?");
                    Thread.sleep(700);
                    System.out.println("Your mech suit did nothing.");
                    Thread.sleep(1000);
                }
        
            default:
                thePlayer.attack(monsterOnField);
                break;
        }
    }

    private static void battleLoop(int roundNum) throws InterruptedException {
        System.out.println("\u001b[32mBattle start!");
        System.out.println("\u001b[0m");
        boolean battling = true;
        boolean won = false;
        
        // round num will scale the difficulty. but since its only 10 rounds, i will choose the arrangement myself.

        Monster theMonster;

        switch (roundNum) {
            case 0:
                theMonster = new tutorialMonster(3, 1, 8, 2, 10, 3, "Booger", "Basic");
                break;
        
            default:
                theMonster = new tutorialMonster(3, 1, 8, 2, 10, 3, "Booger", "Basic");
                break;
        }

        Thread.sleep(1000);

        System.out.println("Fighting: " + theMonster.getName() + ".\n Elemental type: " + theMonster.elementalType + ". Plan accordingly.");

        Thread.sleep(1000);
        while (battling) {
            if (theMonster.getSpeed() <= thePlayer.getSpeed()) { // if theres a speed tie, the player goes first
                playersTurn(theMonster);
                if (theMonster.isDead()) {
                    battling = false;
                    won = true;
                    break;
                } else {
                    theMonster.attack(thePlayer);
                    if (thePlayer.isDead()) {
                        battling = false; // loooooserrrrr
                    }
                }
            } else {
                theMonster.attack(thePlayer);
                if (thePlayer.isDead()) {
                    battling = false;
                    break;
                } else {
                    System.out.println("P turn");
                    playersTurn(theMonster);
                    if (theMonster.isDead()) {
                        battling = false; // wiiiinerrrrrrr winnnerrrr chickennn dinnerrrr pls put me into apcs period 3 and move my chem up one periodddddd
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {

        Scanner mainSc = new Scanner(System.in);

        System.out.println("Welcome to MechaMonsters!");

        Thread.sleep(1000);

        System.out.println("A java program text battle simulator!");
        
        Thread.sleep(1000);

        System.out.println("However, first things first, may I have your name? Input below:");

        String thePlayersName = mainSc.nextLine();

        System.out.println("Now, choose your class. \n Type 1 for brawler. \n7 attack, 4 defense, 5 speed, 0 special stat, \n22 health, and 20% base crit rate.");
        System.out.println("\n Type 2 for specialist. \n2 attack, 2 defense, 8 speed, 8 special stat, \n16 health, and 10% base crit rate.");

        Thread.sleep(2000);

        int chosenClass = 0;

        while (chosenClass == 0) {
            try 
            {
                chosenClass = mainSc.nextInt(); 
                if (chosenClass < 1 || chosenClass > 2) {
                    chosenClass = 0;
                    System.out.println("Please input 1 or 2.");
                } else {
                    System.out.println("You have decided to pick class " + chosenClass + ".");
                }
                Thread.sleep(1000);
            } catch (InputMismatchException e) {
                System.out.println("Please input an integer. \n Valid inputs: 1 or 2.");
                Thread.sleep(1000);
            }
        }

        
  

        switch (chosenClass) {
            case 1: // brawler
                thePlayer = new Player(7, 4, 5, 0, 22, 20, thePlayersName, "Brawler");
                System.out.println("Players health: " + thePlayer.getHealth()); // zero here
                break;
            case 2: // specialist
                thePlayer = new Player(2, 2, 8, 8, 16, 10, thePlayersName, "Specialist");
                break;
        
            default:
                thePlayer = new Player(1, 1, 1, 1, 22, 22, thePlayersName, "Hackerman");
                break;
        }

       

        System.out.println("Great! We have created your own player file. You are a " + thePlayer.battleClass);

        Thread.sleep(1000);
        // 0 here
        System.out.println("Your stats are as shown below: \n" + thePlayer.returnAllStats());

        Thread.sleep(1000);

        System.out.println("Throughout the game, you will gain rougelike-power ups, choices of new mech suits, and infinitely scaling fights against monsters.");

        Thread.sleep(3000);

        System.out.println("To keep this game small in scope however, there will only be 3 mech suits, and 4 types of monsters. Sorry! :D");

        Thread.sleep(3000);

        System.out.println("You'll also win in 10 rounds. This first round will be a tutorial monster.");

        Thread.sleep(3000);

        System.out.println("Battling should be very self explanatory. After each battle, you will receive a choice of a random upgrade.");
        
        Thread.sleep(3000);
        
        System.out.println("Good luck!");

        Thread.sleep(3000);

        System.out.println(thePlayer.getHealth());
        battleLoop(0);

    }
}