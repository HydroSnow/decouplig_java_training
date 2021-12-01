package fr.lernejo.logger;

public class LoggerFactory {
    public static Logger getLogger(final String name) {
        return new ContextualLogger(new FileLogger("output.log"));
    }
}
