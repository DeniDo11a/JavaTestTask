package ru.denislobastov.javatest;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DataController {
    private final List<String> inputFiles;

    private List<String> integers = new ArrayList<>();
    private List<String> floats = new ArrayList<>();
    private List<String> strings = new ArrayList<>();

    private Statistics statistics = new Statistics();
    private FileWriter fileWriter;

    public DataController(List<String> inputFiles, FileWriter fileWriter){
        this.inputFiles = inputFiles;
        this.fileWriter = fileWriter;
    }

    public void readFiles(){
        for (String path : inputFiles){
            readFile(path);
        }
    }

    private void readFile(String path){
        try ( InputStream input = getClass().getResourceAsStream("/" + path);
                BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            String line = reader.readLine();
            while (line != null) {
                switch (typeDetector(line)){
                    case INTEGER :
                        integers.add(line);
                        statistics.addInteger(Long.parseLong(line));
                        break;
                    case FLOAT :
                        floats.add(line);
                        statistics.addFloat(Double.parseDouble(line));
                        break;
                    case STRING :
                        strings.add(line);
                        statistics.addString(line);
                        break;
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Type typeDetector(String line){
        try {
            Long.parseLong(line);
            return Type.INTEGER;
        } catch (NumberFormatException e){
            try {
                Double.parseDouble(line);
                return Type.FLOAT;
            } catch (NumberFormatException e1) {
                return Type.STRING;
            }
        }
    }

    public void writeFiles() throws IOException {
        for (Type type : Type.values()){
            switch (type){
                case INTEGER -> fileWriter.write(integers,type);
                case FLOAT -> fileWriter.write(floats,type);
                case STRING -> fileWriter.write(strings,type);
            }
        }
    }

    public Statistics getStatistics() {
        return statistics;
    }
}
