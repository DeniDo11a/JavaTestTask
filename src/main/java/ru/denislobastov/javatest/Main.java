package ru.denislobastov.javatest;

public class Main {
    public static void main(String[] args) {
        try {
            Options options = new Options(args);
            FileWriter writer = new FileWriter(options.isAppendMode(),options.getOutputPath(),
                    options.getOutputFilePrefix());
            DataController dataController = new DataController(options.getInputFiles(),writer);
            dataController.readFiles();
            dataController.getStatistics().print(options.isFullStats(),options.isShortStats());
            dataController.writeFiles();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}