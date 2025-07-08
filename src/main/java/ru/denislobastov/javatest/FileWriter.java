package ru.denislobastov.javatest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileWriter {
    private final boolean appendMode;
    private final Path outputPath;
    private final String outputFilePrefix;

    public FileWriter(boolean appendMode, Path outputPath, String outputFilePrefix) {
        this.appendMode = appendMode;
        this.outputPath = outputPath;
        this.outputFilePrefix = outputFilePrefix;
    }

    public void write(List<String> data, Type type) throws IOException {
        if (data.isEmpty()) return;

        String filename = outputFilePrefix + type.toString().toLowerCase() + "s.txt";
        Path resultPath = outputPath.resolve(filename);
        Files.createDirectories(resultPath.getParent());

        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(resultPath.toFile(),appendMode))) {
            for (String line : data)
                writer.write(line);
                writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
