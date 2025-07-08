package ru.denislobastov.javatest;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Options {
    private boolean appendMode = false;
    private boolean shortStats = false;
    private boolean fullStats = false;
    private Path outputPath = Path.of(System.getProperty("user.dir"));
    private String outputFilePrefix = "";
    private List<String> inputFiles = new ArrayList<>();
    public Options (String args[]) throws URISyntaxException {
        for (int i = 0; i < args.length; i++){
            switch (args[i]){
                case "-a" -> appendMode = true;
                case "-s" -> shortStats = true;
                case "-f" -> fullStats = true;
                case "-o" -> {
                    i++;
                    String rawPath = args[i];
                    outputPath = Path.of(normalizePath(rawPath)).normalize();
                }
                case "-p" -> {
                    i++;
                    outputFilePrefix = args[i];
                }
                default -> inputFiles.add(args[i]);
            }
        }
    }

    private String normalizePath(String rawPath) {
        if (rawPath.startsWith("\\") || rawPath.startsWith("/")) {
            return rawPath.substring(1);
        }
        return rawPath;
    }

    boolean isAppendMode(){
        return appendMode;
    }
    boolean isShortStats(){
        return shortStats;
    }
    boolean isFullStats(){
        return fullStats;
    }
    Path getOutputPath(){
        return outputPath;
    }
    String getOutputFilePrefix(){
        return outputFilePrefix;
    }
    List<String> getInputFiles(){
        return inputFiles;
    }
}
