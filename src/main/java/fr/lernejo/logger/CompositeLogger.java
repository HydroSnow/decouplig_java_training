package fr.lernejo.logger;

public class CompositeLogger implements Logger {

    private final Logger[] loggers;

    public CompositeLogger(final Logger... loggers) {
        this.loggers = loggers;
    }

    @Override
    public void log(final String message) {
        for (final Logger logger : loggers) {
            logger.log(message);
        }
    }
}
