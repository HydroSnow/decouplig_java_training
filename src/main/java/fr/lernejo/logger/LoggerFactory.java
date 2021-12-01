package fr.lernejo.logger;

public class LoggerFactory {

    public static Logger getLogger(final String name) {
        return new ContextualLogger(
            new CompositeLogger(
                new ConsoleLogger(),
                new FilteredLogger(
                    new FileLogger("output.log"), (message) -> message.contains("fr.lernejo.guessgame.Simulation")
                )
            )
        );
    }
}
