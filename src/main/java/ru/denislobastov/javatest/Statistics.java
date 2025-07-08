package ru.denislobastov.javatest;

import java.util.List;

public class Statistics {
    private int countInts;
    private int countFloats;
    private int countStrings;

    private long maxInt = Integer.MIN_VALUE;
    private long minInt = Integer.MAX_VALUE;
    private long sumInt;

    private double maxFloat = Float.MIN_VALUE;
    private double minFloat = Float.MAX_VALUE;
    private double sumFloat;

    private int minLengthString = Integer.MAX_VALUE;
    private int maxLengthString = 0;

    public void addInteger(long value){
        countInts++;
        sumInt += value;
        maxInt = Math.max(maxInt,value);
        minInt = Math.min(minInt,value);
    }
    public void addFloat(double value){
        countFloats++;
        sumFloat += value;
        maxFloat = Math.max(maxFloat,value);
        minFloat = Math.min(minFloat,value);
    }

    public void addString(String value) {
        countStrings++;
        maxLengthString = Math.max(maxLengthString,value.length());
        minLengthString = Math.min(minLengthString,value.length());
    }

    public void print(boolean fullStats, boolean shortStats){
        if (!fullStats && !shortStats) return;
        System.out.println("Count of integers: " + countInts);
        System.out.println("Count of floats: " + countFloats);
        System.out.println("Count of strings: " + countStrings);
        if (fullStats){
            System.out.println("INTEGER");
            System.out.println("Max of integers: " + maxInt);
            System.out.println("Min of integers: " + minInt);
            System.out.println("Sum of integers: " + sumInt);
            System.out.println("Avg of integers: " + (double)(sumInt/countInts));
            System.out.println("FLOAT");
            System.out.println("Max of floats: " + maxFloat);
            System.out.println("Min of floats: " + minFloat);
            System.out.println("Sum of floats: " + sumFloat);
            System.out.println("Avg of floats: " + sumFloat/countFloats);
            System.out.println("STRINGS");
            System.out.println("Max length of strings: " + maxLengthString);
            System.out.println("Min length of strings: " + minLengthString);
        }

    }
}
