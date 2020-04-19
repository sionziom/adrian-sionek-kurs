package com.course.rps;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RpsCheat {

    private final Scanner scanner = new Scanner(System.in);
    private final Random generator = new Random();
    private int rounds;


    public void inputData() throws InputMismatchException {

        System.out.println("What's your name ?");
        String playerName = scanner.nextLine();
        System.out.println("Welcome in game " + "*" + playerName + "*" + "\nPlease tell me, how many rounds you want to win ???");
        rounds = scanner.nextInt();
        if (rounds > 0) {
            System.out.println("Ok, you must win " + rounds + " rounds\n");
        }

    }

    public void instructions() {
        System.out.println("Now please read the instructions:\n" +
                "button 1 - plays *Rock*,\n" +
                "button 2 - plays *Paper*,\n" +
                "button 3 - plays *Scissors*,\n" +
                "button x - ends the game preceded by a question, \"Are you sure to end the game ?\"\n" +
                "button n - restarts the game preceded by a question, \"Are you sure to end actual game ?\"");
    }

    public int playerPoints(int pmove, int cmove) {

        int playerPoints = 0;

        if (pmove == 1 && cmove == 3) {
            playerPoints++;
        } else if (pmove == 2 && cmove == 1) {
            playerPoints++;
        } else if (pmove == 3 && cmove == 2) {
            playerPoints++;
        }
        return playerPoints;
    }

    public int computerPoints(int pmove, int cmove) {

        int computerPoints = 0;

        if (pmove == 1 && cmove == 2) {
            computerPoints++;

        } else if (pmove == 2 && cmove == 3) {
            computerPoints++;

        } else if (pmove == 3 && cmove == 1) {
            computerPoints++;

        }
        return computerPoints;
    }

    public void playerPath(int pmove) {
        if (pmove == 1) {
            System.out.println("Your move - *Rock*");
        } else if (pmove == 2) {
            System.out.println("Your move - *Paper*");
        } else if (pmove == 3) {
            System.out.println("Your move - *Scissors*");
        } else {
            System.out.println("Wrong move!!!, choose numbers from 1 to 3");
        }
    }


    public void computerPath(int cmove) {
        if (cmove == 1) {
            System.out.println("Computer move - *Rock*");
        } else if (cmove == 2) {
            System.out.println("Computer move - *Paper*");
        } else if (cmove == 3) {
            System.out.println("Computer move - *Scissors*");
        }
    }

    public void wonRounds(int playerPoints, int computerPoints) {

        if (playerPoints > computerPoints) {
            System.out.println("Won rounds = " + playerPoints);
        } else if (playerPoints < computerPoints) {
            System.out.println("Won rounds = " + computerPoints);
        } else {
            System.out.println("Draw for all players with: " + playerPoints + " points");
        }
    }


    public void finalScore(int playerPoints, int computerPoints) {

        //final scores
        System.out.println("Final score: Player = " + playerPoints + " points, Computer = " + computerPoints + " points");

        if (playerPoints > computerPoints) {
            System.out.println("The winner is Player with " + playerPoints + " points");
        } else if (playerPoints < computerPoints) {
            System.out.println("The winner is Computer with " + computerPoints + " points");
        }

    }

    public void endGame() throws InputMismatchException {
        System.out.println("To quit press *x*,\nTo close actual game and start new round press *n* ");

        scanner.nextLine();
        String dec1 = scanner.nextLine();

        System.out.println(dec1);
        if ("x".equals(dec1)) {
            System.out.println("Are you sure to quit ?");
            String dec2 = scanner.nextLine();
            if ("".equals(dec2)) {
                System.out.println("Thanks for playing");
                System.exit(0);
            } else {
                System.out.println("New round");
                inputData();
                instructions();
                game();
                endGame();
            }

        } else if ("n".equals(dec1)) {
            System.out.println("Are you sure to close actual game, and start the new round ?");

            String dec2 = scanner.nextLine();
            if ("".equals(dec2)) {
                System.out.println("New round");
                inputData();
                instructions();
                game();
                endGame();
            } else {
                System.exit(0);
            }
        }

    }

    public int computerCheating(int pmove) {
        //if probability >0 && <=25 - computer lose
        //if probability >25 && <=50 - draw
        //if probability >50 && <=100 - computer win
        int probability = generator.nextInt(100)+1;
        int computerMove = 0;
        if (pmove == 1) {

            if (probability > 0 && probability <= 25) {
                computerMove = 3;
            } else if (probability > 25 && probability <= 50) {
                computerMove = 1;
            } else if (probability > 50 && probability <= 100) {
                computerMove = 2;
            }

        } else if (pmove == 2) {

            if (probability > 0 && probability <= 25) {
                computerMove = 1;
            } else if (probability > 25 && probability <= 50) {
                computerMove = 2;
            } else if (probability > 50 && probability <= 100) {
                computerMove = 3;
            }

        } else if (pmove == 3) {

            if (probability > 0 && probability <= 25) {
                computerMove = 2;
            } else if (probability > 25 && probability <= 50) {
                computerMove = 3;
            } else if (probability > 50 && probability <= 100) {
                computerMove = 1;
            }

        }
        return computerMove;
    }

    public void game() throws InputMismatchException {

        int ppoints = 0;
        int cpoints = 0;

        boolean end = false;
        while (!end) {

            System.out.println("Please choose your move...");

            //player move
            int pmove = scanner.nextInt();

            if (pmove == 1 || pmove == 2 || pmove == 3) {
                playerPath(pmove);
            } else {
                System.out.println("Wrong move, please choose numbers from 1 to 3");
                continue;
            }

            //computer's cheat move
            int cmove = computerCheating(pmove);

            computerPath(cmove);

            int pp = playerPoints(pmove, cmove);
            int cp = computerPoints(pmove, cmove);

            if (pp == 1) {
                System.out.println("Point for player");
            } else if (cp == 1) {
                System.out.println("Point for computer");
            } else if (pp == cp) {
                System.out.println("Draw");
            }

            //points
            ppoints = ppoints + pp;

            cpoints = cpoints + cp;

            wonRounds(ppoints, cpoints);

            //end
            if (ppoints == rounds || cpoints == rounds) {
                end = true;
            }
        }
        finalScore(ppoints, cpoints);

    }
}