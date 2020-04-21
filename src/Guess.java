
//Users: Mariam Khatib, "Doc" Nathan Cowley, Kylie Johnson
//"Non-user program assistant": "Tron"
//CS 145
//Lab 1: Guessing Game
//IDE: IntelliJ
/*Purpose of Program Summary:
   This program plays a guessing game. The program will print out an introduction, then
   it will create a random number between one and the constant, and the player
   will guess it until they get it correct. If the player guesses incorrectly then
   the program will tell them they guessed incorrectly, then tell them if the correct answer
   is higher or lower than their input and then ask for another number. If the answer
   is correct, then the program will them them the amount of guesses they took to
   get the right answer, then ask if they would like to play another game. If they
   respond with y, then the process repeats. If they respond with n, then the program
   gives them the statistic of the total games the user played, including the number
   of games played, total guesses over all games, average amount of guesses, and
   the high score.
 */
// ©DuchessDocSpacetranautIndustries., All rights Reserved
// So, Hippity Hoppety: Get OFF our Property!!

import java.util.Scanner;
import java.util.*;


//sos some one come save me

public class Guess {
    private static Scanner console = new Scanner(System.in);
    enum results { //to test later, new edit as of 8:30 04/17
        HIGH, LOW, CORRECT;
    }

    public static void main(String[] args) { //This main method calls an initial game and then creates a while loop so that
        //unless the user inputs a phrase that starts with "n", the user will continue to play again.
        //If user inputs a "n" word, main will call "TheResult" method and end.
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
    }

    public static void GameIntro(){ //Prints a large amount of introductory exposition, helps clean up main.
        System.out.println("This program allows you to play a guessing game.");
        System.out.println("I will think of a number between 1 and");
        System.out.println("100 and will allow you to guess until");
        System.out.println("you get it. For each guess, I will tell you");
        System.out.println("whether the right answer is higher or lower");
        System.out.println("than your guess.");
        System.out.println();

    }
    public static int TheGame() { //This method creates a random integer between 1 and 100 and will continue to ask
        // for user input of integers until the user can guess the correct one, continually
        // telling him whether his guess is too low or high.
        // It will then tell him the amount of guesses it took the user to guess the
        // correct integer.
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
            } else {
                System.out.println("It's higher");
            }
        }
        return numguess;

    }
    public static void TheResult(int numguess, int numgame, int bestgame) {
        //This method displays the total amount of games, guesses, average guess per game, and the best game played.

        System.out.println("Total games: " + numgame);
        System.out.println("Total Guesses: " + numguess);
        System.out.println("guesses/games: " + (numguess / numgame));
        System.out.println("Best game: " + bestgame);

    }

}
