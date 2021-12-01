package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(final String[] args) {
        final Player player = new HumanPlayer();
        final Simulation simulation = new Simulation(player);
        final SecureRandom random = new SecureRandom();
        final long number = random.nextInt(100);
        simulation.initialize(number);
        simulation.loopUntilPlayerSucceed();
    }
}
