package fr.lernejo.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    private final Logger delegateLogger;

    public ContextualLogger(final Logger delegateLogger) {
        this.delegateLogger = delegateLogger;
    }

    @Override
    public void log(final String message) {
        delegateLogger.log(LocalDateTime.now().format(formatter) + " " + Thread.currentThread().getStackTrace()[2].getClassName() + " " + message);
    }
}
