import java.util.Scanner;

public class QuadraticRoots {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of a: ");
        double a = sc.nextDouble();

        System.out.print("Enter value of b: ");
        double b = sc.nextDouble();

        System.out.print("Enter value of c: ");
        double c = sc.nextDouble();

        double determinant = b * b - 4 * a * c;

        if (determinant > 0) {
            double root1 = (-b + Math.sqrt(determinant)) / (2 * a);
            double root2 = (-b - Math.sqrt(determinant)) / (2 * a);
            System.out.println("Two real and distinct roots:");
            System.out.println("Root1 = " + root1);
            System.out.println("Root2 = " + root2);
        } else if (determinant == 0) {
            double root = -b / (2 * a);
            System.out.println("Two equal real roots:");
            System.out.println("Root = " + root);
        } else {
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-determinant) / (2 * a);
            System.out.println("Complex roots:");
            System.out.println("Root1 = " + realPart + " + " + imaginaryPart + "i");
            System.out.println("Root2 = " + realPart + " - " + imaginaryPart + "i");
        }
    }
}
