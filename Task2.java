/*
TASK 2
STUDENT GRADE CALCULATOR
 Input: Take marks obtained (out of 100) in each subject.
 Calculate Total Marks: Sum up the marks obtained in all subjects.
 Calculate Average Percentage: Divide the total marks by the total number of subjects to get the
 average percentage.
 Grade Calculation: Assign grades based on the average percentage achieved.
 Display Results: Show the total marks, average percentage, and the corresponding grade to the user
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextInt();

            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid input. Marks should be between 0 and 100.");
                i--; // Reattempt for the same subject
                continue;
            }

            totalMarks += marks[i];
        }

        double averagePercentage = (double) totalMarks / numSubjects;
        char grade;

        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}

/*
SAMPLE INPUT/OUTPUT:
Enter the number of subjects: 5
Enter marks for subject 1 (out of 100): 89
Enter marks for subject 2 (out of 100): 92
Enter marks for subject 3 (out of 100): 91
Enter marks for subject 4 (out of 100): 87
Enter marks for subject 5 (out of 100): 95

Results:
Total Marks: 454
Average Percentage: 90.80%
Grade: A

*/
