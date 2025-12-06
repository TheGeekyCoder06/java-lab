import java.util.Scanner;

class Student {
    String usn;
    String name;
    int n;               // number of subjects
    int[] credits;
    int[] marks;
    double sgpa;

    void acceptDetails() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter USN: ");
        usn = sc.nextLine();

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter number of subjects: ");
        n = sc.nextInt();

        credits = new int[n];
        marks = new int[n];

        System.out.println("Enter credits and marks for each subject:");
        for (int i = 0; i < n; i++) {
            System.out.print("Subject " + (i + 1) + " credits: ");
            credits[i] = sc.nextInt();
            System.out.print("Subject " + (i + 1) + " marks: ");
            marks[i] = sc.nextInt();
        }
    }

    void calculateSGPA() {
        int totalCredits = 0;
        int totalCreditPoints = 0;

        for (int i = 0; i < n; i++) {
            int gp;       // grade point
            int m = marks[i];

            if (m >= 90) gp = 10;
            else if (m >= 80) gp = 9;
            else if (m >= 70) gp = 8;
            else if (m >= 60) gp = 7;
            else if (m >= 50) gp = 6;
            else if (m >= 40) gp = 5;
            else gp = 0;

            totalCredits += credits[i];
            totalCreditPoints += gp * credits[i];
        }

        sgpa = (double) totalCreditPoints / totalCredits;
    }

    void displayDetails() {
        System.out.println("\n--- Student Details ---");
        System.out.println("USN   : " + usn);
        System.out.println("Name  : " + name);
        System.out.println("SGPA  : " + sgpa);
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        Student s = new Student();
        s.acceptDetails();
        s.calculateSGPA();
        s.displayDetails();
    }
}
