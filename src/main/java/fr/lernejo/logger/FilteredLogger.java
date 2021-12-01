package fr.lernejo.logger;

import java.util.function.Predicate;

public class FilteredLogger implements Logger {

    private final Logger delegateLogger;
    private final Predicate<String> condition;

    public FilteredLogger(final Logger delegateLogger, final Predicate<String> condition) {
        this.delegateLogger = delegateLogger;
        this.condition = condition;
    }

    @Override
    public void log(final String message) {
        if (condition.test(message)) {
            delegateLogger.log(message);
        }
    }
}
