package at.spengergasse.game.model;

import at.spengergasse.game.ensurer.Ensurer;
import at.spengergasse.game.ensurer.HangmanEnsurer;

import static at.spengergasse.game.ensurer.Ensurer.ensureNotNull;
import static at.spengergasse.game.ensurer.Ensurer.ensureNotNullNotBlank;

public class Hangman
{
    // attributes
    // wanted word          "spengergasse"
    // guessed word         "***********"
    // guessed characters   "s"
    // faults               1
    // MAX FAULT            7

    // private String wordList = "Starwars Spengergasse ..."

    public static final String DEFAULT = "spengergasse";

    private String wantedWord;
    private StringBuilder guessedWord;
    private StringBuilder guessedCharacters;
    private int faults;
    private int corrects;

    private final int MAX_FAULTS = 7;

    public enum GAME_STATE
    {
        WON, LOST, KEEP_PLAYING
    }

    // ctor ------------------------------------------------
    public Hangman(String wantedWord)
    {
        this.wantedWord = ensureNotNullNotBlank(wantedWord.toLowerCase(), "wantedWord");

        this.guessedWord = new StringBuilder("*".repeat(wantedWord.length()));
        this.guessedCharacters = new StringBuilder();

        this.faults = 0;
        this.corrects = 0;
    }


    // getter ------------------------------------------------
    public String getGuessedWord()
    {
        return guessedWord.toString();
    }

    public String getGuessedCharacters()
    {
        return guessedCharacters.toString();
    }

    public int getCorrects()
    {
        return corrects;
    }

    public int getFaults()
    {
        return faults;
    }

    public GAME_STATE getGameState()
    {
        if (faults >= MAX_FAULTS)
            return GAME_STATE.LOST;

        // if (wantedWord.equals(guessedWord.toString()))
        if (corrects == wantedWord.length())
            return GAME_STATE.WON;

        return GAME_STATE.KEEP_PLAYING;
    }



    // game logic ------------------------------------------------
    public void guessNextCharacter(char nextCharacter)
    {
        // Gateway Ensurer
         HangmanEnsurer.ensureValidGameState(this);

        char nextCharacterLower = Character.toLowerCase(nextCharacter);

        if (! containsInGuessed(nextCharacterLower))
            updateGameState(nextCharacterLower);
        else
            System.out.printf("Fehler: Das gleiche Zeichen %c wurde schon eingegeben%n", nextCharacter);
    }

    public boolean containsInGuessed(char nextCharacter)
    {
        return guessedCharacters.indexOf(String.valueOf(nextCharacter)) >= 0;
    }

    private void updateGameState(char nextCharacter)
    {
        guessedCharacters.append(nextCharacter);

        int oldCorrects = corrects;

        // for each character
        for (int i = 0; i < wantedWord.length(); i++)
        {
            // matched wanted[i] with nextCharacter?
            if (wantedWord.charAt(i) == nextCharacter)
            {
                guessedWord.setCharAt(i, nextCharacter);
                corrects++;
            }
        }

       if (oldCorrects == corrects)
           faults++;
    }


    // toString ------------------------------------------------
    public String toString()
    {

         // Guessed Word: s*****ss*
         // Guessed Characters:
         // Tries left: 2
         // Draw Hangman

        return """
            Guessed Word: %s
            Guessed Characters: %s
            Tries Left: %d
            %s
            """.formatted(guessedWord, guessedCharacters,
            MAX_FAULTS - faults, getHangman());
    }

    private String getHangman()
    {
        // Java 14 switch expression
        return switch (faults)
            {
                case 0 -> "";
                case 1 -> hangman1();
                case 2 -> hangman2();
                case 3 -> hangman3();
                case 4 -> hangman4();
                case 5 -> hangman5();
                case 6 -> hangman6();
                default -> hangman7();
            };
    }

    private String hangman1()
    {
        return """
              +---+
              |   |
                  |
                  |
                  |
                  |
            =========
                  """;
    }

    private String hangman2()
    {
        return """
              +---+
              |   |
              O   |
                  |
                  |
                  |
            =========
                  """;
    }

    private String hangman3()
    {
        return """
              +---+
              |   |
              O   |
              |   |
             /|   |
                  |
            =========
                  """;
    }

    private String hangman4()
    {
        return """
              +---+
              |   |
              O   |
              |   |
             /|\\  |
                  |
            =========
                  """;
    }

    private String hangman5()
    {
        return """
              +---+
              |   |
              O   |
              |   |
             /|\\  |
                  |
            =========
                  """;
    }

    private String hangman6()
    {
        return """
              +---+
              |   |
              O   |
              |   |
             /|\\  |
             /    |
            =========
                  """;
    }

    private String hangman7()
    {
        return """
              +---+
              |   |
              O   |
              |   |
             /|\\  |
             / \\  |
            =========
                  """;
    }
}



//    public void guessNextCharacter(char nextCharacter)
//    {
//        char nextCharacterLower = Character.toLowerCase(nextCharacter);
//
//        if (getGameState() != GAME_STATE.KEEP_PLAYING)
//        {
//            System.out.println("Fehler: ...");
//            return;
//        }
//
//        if (containsInGuessed(nextCharacterLower))
//        {
// System.out.println("Fehler: Das gleiche Zeichen "+ nextCharacter +" wurde schon eingegeben");
// System.out.println(String.format("Fehler: Das gleiche Zeichen %c wurde schon eingegeben", nextCharacter));
//            System.out.println("Fehler: ...");
//            return;
//        }
//
//        updateGameState(nextCharacterLower);
//
//    }
