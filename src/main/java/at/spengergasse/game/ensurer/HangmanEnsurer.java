package at.spengergasse.game.ensurer;

import at.spengergasse.game.model.Hangman;

import static at.spengergasse.game.ensurer.Ensurer.ensureNotNull;

public abstract class HangmanEnsurer
{
    /**
     * Ensurers that hangman game state is valid
     *
     * @param hangman a hangman instance
     * throws IllegalStateException if hangman state is not `GAME.KEEP_PLAYING`
     */
    public static void ensureValidGameState(Hangman hangman) throws IllegalStateException
    {
        ensureNotNull(hangman, "hangman");

        if (hangman.getGameState() != Hangman.GAME_STATE.KEEP_PLAYING)
            // `IllegalStateException` is thrown because state in hangman class was not appropriate
            throw new IllegalStateException("Guessing a character only possibly while playing");

//        if (...)
//            throw new ...

//        if (...)
//            throw new ...
    }
}
