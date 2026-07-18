//Programmers: Brittany Burson & Alexis Lariviere & MAnuel Brugues
//Module: 4 Problem 1
//Date: 07/16/2026
//Email Address: b.burson4211@nu.edu & t.lariviere7089.nu.edu
//Class: CSC262
//Description: This program asks the user for a file name and prints the number of characters, words, and lines in the file. It also prints the longest word in the file.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionalCounts

{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the file name: ");
        String fileName = input.nextLine();

        try {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);

            int characterCount = 0;
            int wordCount = 0;
            int lineCount = 0;
            String longestWord = "";

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                
                //Brittany: Count characters in the line, remove spaces and newlines from the count
                //characterCount += line.replaceAll("\\s+", "").length();

                //Brittany: Count words in the line, split by whitespace
                //String[] words = line.trim().split("\\s+");
                //wordCount += words.length;
                
                //Alexis: Count lines in the file, increment lineCount for each line read
                lineCount++;

                // Manuel: Find the longest word in each line
                String[] words = line.trim().split("\\s+");
                for (String word : words) {
                    String cleanWord = word.replaceAll("[^a-zA-Z0-9]", "");
                    if (cleanWord.length() > longestWord.length()) {
                        longestWord = cleanWord;
                    }
                }
            }

            //System.out.println("Number of characters: " + characterCount);
            //System.out.println("Number of words: " + wordCount);
            System.out.println("Number of lines: " + lineCount);
            System.out.println("Longest word: " + longestWord);

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } finally {
            input.close();
        }
    }
}