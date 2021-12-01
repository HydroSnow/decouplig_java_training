package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player {

    final Logger logger = LoggerFactory.getLogger("player");
    final Scanner scanner = new Scanner(System.in);

    @Override
    public long askNextGuess() {
        // demander au joueur un nombre
        logger.log("Entrez un nombre:");

        // lire le nombre
        final long value = scanner.nextLong();

        // consommer la ligne
        scanner.nextLine();

        return value;
    }

    @Override
    public void respond(final boolean lowerOrGreater) {
        // true: plus petit
        // false: plus grand
        if (lowerOrGreater) {
            System.out.println("C'est plus petit.");
        } else {
            System.out.println("C'est plus grand.");
        }
    }
}
