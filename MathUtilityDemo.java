class MathUtility {

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Division by zero not allowed.");
            return 0;
        }
        return a / b;
    }
}

public class MathUtilityDemo {
    public static void main(String[] args) {
        int a = 20, b = 5;

        System.out.println("Add       : " + MathUtility.add(a, b));
        System.out.println("Subtract  : " + MathUtility.subtract(a, b));
        System.out.println("Multiply  : " + MathUtility.multiply(a, b));
        System.out.println("Divide    : " + MathUtility.divide(a, b));
    }
}
