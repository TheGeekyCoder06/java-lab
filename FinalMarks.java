import java.util.*;
import CIE.*;
import SEE.*;

public class FinalMarks {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        Personal[] p = new Personal[n];
        Internals[] in = new Internals[n];
        External[] ex = new External[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Enter Student " + (i + 1) + " Details ---");
            System.out.print("USN: ");
            String usn = sc.next();
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Semester: ");
            int sem = sc.nextInt();

            p[i] = new Personal(usn, name, sem);

            int[] internalMarks = new int[5];
            System.out.println("Enter CIE marks for 5 courses:");
            for (int j = 0; j < 5; j++)
                internalMarks[j] = sc.nextInt();
            in[i] = new Internals(internalMarks);

            int[] seeMarks = new int[5];
            System.out.println("Enter SEE marks for 5 courses:");
            for (int j = 0; j < 5; j++)
                seeMarks[j] = sc.nextInt();
            ex[i] = new External(usn, name, sem, seeMarks);
        }

        System.out.println("\n=== Final Marks ===");
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent: " + p[i].name + " (" + p[i].usn + ")");
            for (int j = 0; j < 5; j++) {
                int cie = in[i].internalMarks[j];
                int see = ex[i].seeMarks[j] / 2; // SEE reduced to 50%
                int finalMarks = cie + see;
                System.out.println("Course " + (j + 1) + ": " + finalMarks);
            }
        }
    }
}
