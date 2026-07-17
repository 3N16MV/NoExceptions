//Programmers: Brittany Burson & Alexis Lariviere
//Module: 4 Problem 1
//Date: 07/16/2026
//Email Address: b.burson4211@nu.edu & t.lariviere7089.nu.edu
//Class: CSC262
//Description: Java program designed to read a set of floating-point numbers from user input, calculate the average,
// the smallest and largest values, and the range between them, and display the results while handling exceptions.

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class NoExceptions

{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the file name: ");
        String fileName = input.nextLine();

        try {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
        catch (NoSuchElementException e) {
            System.out.println("File contents invalid " + fileName);
        }
        catch (IOException e) {
            System.out.println("An I/O error occurred while reading the file: " + fileName);
            return;
        }
        }

    public static double[] readDataFromFile(String fileName) throws FileNotFoundException, NoSuchElementException {
        File file = new File(fileName);
        Scanner fileScanner = new Scanner(file);

        int count = 0;
        while (fileScanner.hasNextDouble()) {
            fileScanner.nextDouble();
            count++;
        }

        double[] data = new double[count];
        fileScanner.close();

        fileScanner = new Scanner(file);
        for (int i = 0; i < count; i++) {
            if (fileScanner.hasNextDouble()) {
                data[i] = fileScanner.nextDouble();
            } else {
                throw new NoSuchElementException("File contents are invalid.");
            }
        }

        fileScanner.close();
        return data;
    }
}