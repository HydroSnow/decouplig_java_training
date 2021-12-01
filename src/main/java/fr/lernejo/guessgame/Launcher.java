package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;

public class Launcher {

    private static final Logger logger = LoggerFactory.getLogger("launcher");

    public static void main(final String[] args) {
        if (args.length == 1 && args[0].equalsIgnoreCase("-interactive")) {
            logger.log("Selected interactive");

            final SecureRandom random = new SecureRandom();
            final long number = random.nextInt(100);
            logger.log("Number is " + number);

            final Player player = new HumanPlayer();
            final Simulation simulation = new Simulation(player);
            simulation.initialize(number);

            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);

            return;
        }

        if (args.length == 2 && args[0].equalsIgnoreCase("-auto")) {
            logger.log("Selected automatic");

            final long number = Long.parseLong(args[1]);
            logger.log("Number is " + number);

            final Player player = new ComputerPlayer();
            final Simulation simulation = new Simulation(player);
            simulation.initialize(number);

            simulation.loopUntilPlayerSucceed(1000);

            return;
        }

        logger.log("Showing help");
        System.out.println("Arguments:");
        System.out.println(" -interactive");
        System.out.println(" -auto [nombre]");
    }
}
