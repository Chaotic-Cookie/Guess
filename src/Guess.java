/*
Mariam Khatib
Cis 140
lab 4: Guessing
IDE: intellij

This lab will have the users guess out a randomly generated number
 */
import java.util.Scanner;
import java.util.*;

public class Guess { //program start
    private static Scanner console = new Scanner(System.in);
    enum results { //to test later, new edit as of 8:30 04/17
        HIGH, LOW, CORRECT;
    }

    public static void main(String[] args) { //main start
        GameIntro();

        int guess;
        int numguess = 0;
        int numgame = 0;
        String userreply;
        int bestgame = 1000000000;
        boolean nextgame = true;


        while (nextgame) {
            guess = TheGame();
            numguess += guess;
            if (guess < bestgame) {
                bestgame = guess;
            }
            numgame++;
            System.out.println("Want to play again?(Y/N) ");
            userreply = console.next().substring(0, 1);

            if (userreply.equalsIgnoreCase("n")) {
                nextgame = false;
            }
        }

        TheResult(numguess, numgame,bestgame);
    } //main end

    public static void GameIntro(){ //intro start
        System.out.println("This program allows you to play a guessing game.");
        System.out.println("I will think of a number between 1 and");
        System.out.println("100 and will allow you to guess until");
        System.out.println("you get it. For each guess, I will tell you");
        System.out.println("whether the right answer is higher or lower");
        System.out.println("than your guess.");
        System.out.println();

    } //intro end

       public static int TheGame() { //the game start
           Random random = new Random();
           int num = random.nextInt(100);
           int guess;
           int numguess = 0;
           boolean win = false;

           while (!win) {
               System.out.println("Your guess?");
               guess = console.nextInt();
               numguess++;

               if (guess == num) { // test enum here
                   win = true;
                   System.out.println("You got it right in " + numguess + " guesses");
               } else if (guess > num) {
                   System.out.println("It's lower");
               } else if (guess < num) {
                   System.out.println("It's higher");
               }
           }
           return numguess;

       }// the game end
       public static void TheResult(int numguess, int numgame, int bestgame) { //result start

           System.out.println("Total games: " + numgame);
           System.out.println("Total Guesses: " + numguess);
           System.out.println("guesses/games: " + (numguess / numgame));
           System.out.println("Best game: " + bestgame);

       } //end of results

}// program end
