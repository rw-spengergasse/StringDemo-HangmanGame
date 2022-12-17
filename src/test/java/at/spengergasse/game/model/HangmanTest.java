package at.spengergasse.game.model;

import at.spengergasse.game.model.Hangman.GAME_STATE;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// TDD
// Test Driven Development

// BDD
// Behaviour Driven Development
// Specification by Example
// Gherkin Style
// GIVEN, WHEN, THEN, AND, BUT
// Always use present tense
// https://automationpanda.com/bdd/

// Scenario 1:
// GIVEN: The user starts a hangman game with wanted word of `Spengergasse`
// WHEN: The user guesses 'S' as a next character.
// THEN: The `faults` are 0
// AND: The `corrects` are 3
// AND: The `guessWords` is equal to s********ss*
// AND The `guessedCharacters` is equal to `s`

// Scenario 3:
// GIVEN: The user starts a hangman game with wanted word of `Spengergasse`
// AND: The user guesses `S` as a next character
// WHEN: The user guesses again `S` a  next character
// THEN: The faults are 0
// AND: The corrects are 3
// AND: The `guessWords` is equal to s********ss*
// AND The `guessedCharacters` is equal to `s`


// () -> {} = Lambda
// (String name) -> { System.out.println(name); }

// Method without a name / Anonymous Method
// 193x Alonzo Church (mathematician)
// Lambda Calculus

class HangmanTest
{
    @Test
    public void guessNextCharacters_shouldWorkIfUserSuppliesContainingCharacter()
    {
        // GIVEN: The user starts a hangman game with wanted word of `Spengergasse`
        Hangman game = new Hangman("Spengergasse");

        // WHEN: The user guesses 'S' as a next character.
        game.guessNextCharacter('S');

        // THEN: The `faults` are 0
        // AND: The `corrects` are 3
        // AND: The `guessWords` is equal to s********ss*
        // AND The `guessedCharacters` is equal to `s`
        assertEquals(0, game.getFaults());
        assertEquals(3, game.getCorrects());
        assertEquals("s********ss*", game.getGuessedWord());
        assertEquals("s", game.getGuessedCharacters());

    }

    @Test
    public void guessNextCharacters_shouldFailIfUserSuppliesNotContainingCharacter()
    {
        // GIVEN: The user starts a hangman game with wanted word of `Spengergasse`
        Hangman game = new Hangman("Spengergasse");

        // WHEN: The user guesses `B` as a next character
        game.guessNextCharacter('B');

        // THEN: The faults are 1
        // AND: The corrects are 0
        // AND: The `guessWords` is equal to ************
        // AND The `guessedCharacters` is equal to `b`
        assertEquals(1, game.getFaults());
        assertEquals(0, game.getCorrects());
        assertEquals("************", game.getGuessedWord());
        assertEquals("b", game.getGuessedCharacters());
    }

    @Test
    public void guessNextCharacters_shouldFailIfUserSuppliesSameCharacterAgain()
    {
        // GIVEN: The user starts a hangman game with wanted word of `Spengergasse`
        // AND: The user guesses `S` as a next character
        Hangman game = new Hangman("Spengergasse");
        game.guessNextCharacter('S');

        // WHEN: The user guesses again `S` a  next character
        game.guessNextCharacter('S');

        // THEN: The faults are 0
        // AND: The corrects are 3
        // AND: The `guessWords` is equal to s********ss*
        // AND The `guessedCharacters` is equal to `s`
        assertEquals(0, game.getFaults());
        assertEquals(3, game.getCorrects());
        assertEquals("s********ss*", game.getGuessedWord());
        assertEquals("s", game.getGuessedCharacters());
    }

    @Test
    public void guessNextCharacters_shouldWinTheGameIfUserSuppliesLastCharacter()
    {
        // GIVEN: The user starts a hangman game with wanted word of `Anna`
        // AND: The user guesses `A` as a next character
        Hangman game = new Hangman("Anna");
        game.guessNextCharacter('A');

        // WHEN: The user guesses `N` as a next character
        game.guessNextCharacter('N');

        // THEN: The user won the game
        assertEquals(GAME_STATE.WON, game.getGameState());
    }

    @Test
    public void guessNextCharacters_shouldLoseTheGameIfUserSuppliesLastWrongCharacter()
    {
        // GIVEN: The user starts a hangman game with wanted word of `Z`
        // AND: The user guesses 6 times wrong characters
        Hangman game = new Hangman("Z");
        for (int i = 0; i < 6; i++)
            game.guessNextCharacter((char) ('A' + i));

        // WHEN: The users guesses the 7th wrong character
        game.guessNextCharacter('X');

        // THEN: The user lost the game
        assertEquals(GAME_STATE.LOST, game.getGameState());
    }

    @Test
    public void guessNextCharacters_shouldFailIfUserHasWonOrLost()
    {
        // GIVEN: The user starts a hangman game with wanted word of `Z`
        // AND: The user guesses 7 times wrong characters
        Hangman game = new Hangman("Z");
        for (int i = 0; i < 7; i++)
            game.guessNextCharacter((char) ('A' + i));

        // WHEN: The user guesses the 8th wrong character
        IllegalStateException ex = assertThrows(
            IllegalStateException.class,
            () -> game.guessNextCharacter('X'));

        // THEN: The game rejects guessing the 8th character with an exception
        assertEquals("Guessing a character only possibly while playing", ex.getMessage());
    }
}