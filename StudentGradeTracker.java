import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> grades = new ArrayList<>();
        System.out.println("Welcome to the Student Grade Tracker");
        System.out.println("Enter student grades (enter a negative number to finish)");
        double grade;
        do {
            System.out.print("Enter grade:\n");
            grade = scanner.nextDouble();
            if (grade >= 0 && grade <= 100) {
                grades.add(grade);
            } else if (grade < 0) {
                break;
            } else {
                System.out.println("Please enter a valid grade between 0 and 100.");
            }
        } while (true);
        if (grades.isEmpty()) {
            System.out.println("No grades were entered.");
        } else {
            double total = 0;
            for (double g : grades) {
                total += g;
            }
            double average = total / grades.size();
            double highest = Collections.max(grades);
            double lowest = Collections.min(grades);
            System.out.printf("Average grade: %.2f%n", average);
            System.out.printf("Highest grade: %.2f%n", highest);
            System.out.printf("Lowest grade: %.2f%n", lowest);
        }
        scanner.close();
    }
}
