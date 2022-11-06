package at.spengergasse.domain;

import java.util.Scanner;

import static at.spengergasse.domain.Hangman.GAME_STATE.KEEP_PLAYING;

public class HangmanGame
{
    public static void main(String[] args)
    {
        Hangman hangman = new Hangman("Spengergasse");
        Scanner scanner = new Scanner(System.in);

        while( hangman.getGameState() == KEEP_PLAYING )
        {
            System.out.print("Guess next character: ");
            char nextCharacter = scanner.next().charAt(0);

            hangman.guessNextCharacters(nextCharacter);
            System.out.println(hangman.toString());
        }

        System.out.println("You " + hangman.getGameState());


//        Hangman hangman = new Hangman("Spengergasse");
//        hangman.guessNextCharacters('s');
//        System.out.println(hangman.toString());
//
//        hangman.guessNextCharacters('z');
//        System.out.println(hangman.toString());
//
//        hangman.guessNextCharacters('y');
//        System.out.println(hangman.toString());
    }
}
