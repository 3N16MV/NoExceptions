import java.util.Scanner;

public class DataAnalyzer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double sum = 0;
        double number;
        double smallest = Double.MAX_VALUE;
        double largest = -Double.MAX_VALUE;
        int count = 0;

        System.out.println("Enter floating-point values.");
        System.out.println("Enter anything other than a number to finish.");

        while (input.hasNextDouble()) {
            number = input.nextDouble();

            sum += number;
            count++;

            if (number < smallest) {
                smallest = number;
            }

            if (number > largest) {
                largest = number;
            }
        }

        if (count > 0) {
            double average = sum / count;
            double range = largest - smallest;

            System.out.println("Average: " + average);
            System.out.println("Smallest value: " + smallest);
            System.out.println("Largest value: " + largest);
            System.out.println("Range: " + range);
        } else {
            System.out.println("No valid numbers were entered.");
        }

        input.close();
    }
}
