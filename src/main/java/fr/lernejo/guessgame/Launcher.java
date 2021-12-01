package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(final String[] args) {
        if (args.length == 1 && args[0].equalsIgnoreCase("-interactive")) {
            final SecureRandom random = new SecureRandom();
            final long number = random.nextInt(100);
            final Player player = new HumanPlayer();
            final Simulation simulation = new Simulation(player);
            simulation.initialize(number);
            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
            return;
        }
        if (args.length == 2 && args[0].equalsIgnoreCase("-auto")) {
            final long number = Long.parseLong(args[1]);
            final Player player = new ComputerPlayer();
            final Simulation simulation = new Simulation(player);
            simulation.initialize(number);
            simulation.loopUntilPlayerSucceed(1000);
            return;
        }
        System.out.println("Arguments:");
        System.out.println(" -interactive");
        System.out.println(" -auto [nombre]");
    }
}
