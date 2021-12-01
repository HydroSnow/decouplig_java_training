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
            logger.log("Player has guessed the right number");
            return true;
        } else {
            logger.log("Player has not guessed the right number");
            player.respond(numberToGuess < guess);
            return false;
        }
    }

    public void loopUntilPlayerSucceed() {
        boolean guessing = true;
        int round = 0;
        while (guessing) {
            logger.log("Loop " + round);
            final boolean stop = nextRound();
            if (stop) {
                guessing = false;
            }
            round++;
        }
    }
}
