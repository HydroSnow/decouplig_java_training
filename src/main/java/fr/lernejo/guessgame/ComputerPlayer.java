package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player {

    final Logger logger = LoggerFactory.getLogger("player");

    private long minimum = 0;
    private long maximum = Long.MAX_VALUE;
    private long lastGuess;

    @Override
    public long askNextGuess() {
        logger.log("Minimum is: " + minimum);
        logger.log("Maximum is: " + maximum);
        final long guess = (minimum + maximum) / 2;
        lastGuess = guess;
        logger.log("Guessing: " + guess);
        return guess;
    }

    @Override
    public void respond(final boolean lowerOrGreater) {
        if (lowerOrGreater) {
            maximum = lastGuess - 1;
        } else {
            minimum = lastGuess + 1;
        }
    }
}
