package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(final Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        final long guess = player.askNextGuess();
        if (guess == numberToGuess) {
            logger.log("Player guess is the right number");
            return true;
        } else {
            if (numberToGuess < guess) {
                logger.log("Player guess is above the right number");
                player.respond(true);
            } else {
                logger.log("Player guess is below the right number");
                player.respond(false);
            }
            return false;
        }
    }

    public void loopUntilPlayerSucceed(final long maxRounds) {
        final long start = System.currentTimeMillis();

        for (long round = 0; round < maxRounds; round++) {
            logger.log("Loop " + round);
            final boolean stop = nextRound();
            if (stop) {
                logger.log("Player won");
                break;
            }
        }

        final long time = System.currentTimeMillis() - start;
        final long milliseconds = time % 1000;
        final long seconds = (time / 1000) % 60;
        final long minutes = (time / 60000);
        logger.log("Elapsed: "
            + (minutes < 10 ? "0" : "") + minutes
            + ":" + (seconds < 10 ? "0" : "") + seconds
            + "." + (milliseconds < 100 ? "0" : "") + (milliseconds < 10 ? "0" : "") + milliseconds);
    }
}
