package fr.lernejo.logger;

public class ConsoleLogger implements Logger {
    @Override
    public void log(final String message) {
        System.out.println(message);
    }
}
