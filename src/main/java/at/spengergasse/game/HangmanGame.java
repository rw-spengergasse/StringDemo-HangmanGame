package at.spengergasse.game;

import java.util.Scanner;
import java.util.logging.Logger;

import static at.spengergasse.game.Hangman.GAME_STATE;

public class HangmanGame
{
    public static void main(String[] args)
    {
        Hangman hangman = new Hangman("Spengergasse");
        Scanner scanner = new Scanner(System.in);

        while (hangman.getGameState() == GAME_STATE.KEEP_PLAYING)
        {
            System.out.print("Guess next character: ");
            char nextCharacter = scanner.next().charAt(0);

            hangman.guessNextCharacter(nextCharacter);
            System.out.println(hangman.toString());
        }

        System.out.println("You " + hangman.getGameState());

        // Hangman hangman = new Hangman("Spengergasse");
        // hangman.guessNextCharacters('s');
        // System.out.println(hangman.toString());
        //
        // hangman.guessNextCharacters('z');
        // System.out.println(hangman.toString());
        //
        // hangman.guessNextCharacters('y');
        // System.out.println(hangman.toString());
    }
}
