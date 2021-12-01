package fr.lernejo.logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileLogger implements Logger {

    private final Path path;

    public FileLogger(final String pathAsString) {
        path = Paths.get(pathAsString).toAbsolutePath();
    }

    public void log(final String message) {
        try {
            Files.write(path, (message + "\n").getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (final IOException e) {
            throw new RuntimeException("Cannot write log message to file [" + path + "]", e);
        }
    }
}
