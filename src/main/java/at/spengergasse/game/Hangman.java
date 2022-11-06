package at.spengergasse.domain;

import static java.lang.Character.toLowerCase;

public class Hangman
{
    // attributes
    // wanted word          "spengergasse"
    // guessed word         "s********ss"
    // guessed characters   "s"
    // faults               2
    // MAX FAULT            7

    // private String wordList = "Starwars Spengergasse"
    private final String wantedWord;
    private final StringBuilder guessedWord;
    private final StringBuilder guessedCharacters;
    private int faults;
    private final int MAX_FAULTS = 7;

    enum GAME_STATE
    {
        WON, LOST, KEEP_PLAYING
    }

    public Hangman(String wantedWord)
    {
        // TODO verify wantedWord (not null, at least n characters)
        String stars = "*".repeat(wantedWord.length());

        this.wantedWord = wantedWord.toLowerCase();
        this.guessedWord = new StringBuilder(stars);
        this.guessedCharacters = new StringBuilder();
        this.faults = 0;
    }

    public GAME_STATE getGameState()
    {
        if (faults >= MAX_FAULTS)
            return GAME_STATE.LOST;

        if (wantedWord.equals(guessedWord.toString()))
            return GAME_STATE.WON;

        return GAME_STATE.KEEP_PLAYING;
    }

    public void guessNextCharacters(char nextCharacter)
    {
        char nextCharacterLower = toLowerCase(nextCharacter);

        if (!guessedCharacters.toString().contains(String.valueOf(nextCharacterLower)))
        {
            guessedCharacters.append(nextCharacterLower);
            int found = checkAndSetCharacters(nextCharacter);

            if (found == 0)
                faults++;
        }
    }

    private int checkAndSetCharacters(char nextCharacter)
    {
        int found = 0;

        for (int i = 0; i < wantedWord.length(); i++)
        {
            if (wantedWord.charAt(i) == nextCharacter)
            {
                guessedWord.setCharAt(i, nextCharacter);
                found++;
            }
        }

        return found;
    }

    /*
    public int checkAndSetCharactersV2(char nextCharacter)
    {
        int found = 0;
        int foundAt = 0;

        while((foundAt = wantedWord.indexOf(nextCharacter, foundAt)) >= 0 )
        {
            guessedWord.setCharAt(foundAt, nextCharacter);
            found++;
            foundAt++;
        }

        return found;
    }
    */

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
