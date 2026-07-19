//Programmers: Manuel Brugues Amaro, Brittany Burson, & Alexis Lariviere
//Module: 4 Problem 2
//Date: 07/16/2026
//Email Address: m.bruguesamaro@student.nu.edu,  b.burson4211@student.nu.edu & t.lariviere7089@student.nu.edu
//Class: CSC262
//Description: Java program designed to read a set of floating-point
//numbers from user input, calculate the average, the smallest and largest
//values, and the range between them, and display the results while
//handling exceptions.

//Final integration:
//Integrated the DataAnalyzer functionality into the final exception handling
//implementation to produce the final project submission.

//Correcting syntax errors and finalizing assignment alignment for final commit.

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Logger;

public class NoExceptions {

    // Hide implicit public constructor
    private NoExceptions() {
    }

    private static final Logger logger =
            Logger.getLogger(NoExceptions.class.getName());

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            logger.info("Enter the file name: ");
            String fileName = input.nextLine();

            try {
                double[] data = readDataFromFile(fileName);

                if (data.length == 0) {
                    logger.log(
                            java.util.logging.Level.INFO,
                            "No numeric data found in file: {0}",
                            fileName
                    );

                } else {
                    double sum = 0.0;
                    double min = data[0];
                    double max = data[0];

                    for (double value : data) {
                        sum += value;
                        if (value < min) min = value;
                        if (value > max) max = value;
                    }

                    double avg = sum / data.length;
                    double range = max - min;

                    logger.log(java.util.logging.Level.INFO,
                            "Count: {0}\nAverage: {1,number,#.0000}\nMin: {2,number,#.0000}\nMax: {3,number,#.0000}\nRange: {4,number,#.0000}\n",
                            new Object[] { data.length, avg, min, max, range });
                }

            } catch (FileNotFoundException e) {
                logger.warning("File not found: " + fileName);
            } catch (NoSuchElementException e) {
                logger.warning("File contents invalid: " + fileName);
            } catch (SecurityException e) {
                logger.warning("Permission denied. Unable to access file: " + fileName);
            }

        }
    }
    public static double[] readDataFromFile(String fileName) throws FileNotFoundException, NoSuchElementException {

        File file = new File(fileName);
        ArrayList<Double> values = new ArrayList<>();

        try (Scanner fileScanner = new Scanner(file)) {

            while (fileScanner.hasNext()) {
                values.add(fileScanner.nextDouble());
            }
        }

        double[] data = new double[values.size()];

        for (int i = 0; i < values.size(); i++) {
            data[i] = values.get(i);
        }

        return data;
    }
}
